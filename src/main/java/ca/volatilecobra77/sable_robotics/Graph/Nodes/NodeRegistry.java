package ca.volatilecobra77.sable_robotics.Graph.Nodes;

import ca.volatilecobra77.sable_robotics.Graph.Nodes.Data.BaseDataNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec.BaseExecNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec.UpdateNode;
import ca.volatilecobra77.sable_robotics.Graph.RobotNode;
import ca.volatilecobra77.sable_robotics.Sable_robotics;
import net.neoforged.fml.loading.FMLEnvironment;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class NodeRegistry {
    private static final Map<String, NodeDefinition> NODES = new LinkedHashMap<>();

    public static void register(Class<? extends GraphNode> clazz){
        RobotNode annotation = clazz.getAnnotation(RobotNode.class);
        if (annotation == null) {
            throw new IllegalArgumentException(String.format("Class %s must have a @RobotNode annotation to be registered as a node", clazz.getName()));
        };
        if (!BaseExecNode.class.isAssignableFrom(clazz) && !BaseDataNode.class.isAssignableFrom(clazz)){
            throw new IllegalArgumentException(String.format("Class %s must extend BaseExecNode or BaseDataNode", clazz.getName()));
        }
        try {
            GraphNode instance = clazz.getDeclaredConstructor().newInstance();

            NODES.put(annotation.id(), new NodeDefinition(
                    annotation.id(),
                    annotation.name(),
                    annotation.category(),
                    annotation.description(),
                    clazz,
                    instance instanceof BaseExecNode
            ));

        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "Could not register node: " + clazz.getName(), e
            );
        }
    }
    public static void registerBuiltinNodes() {
        NodeRegistry.register(UpdateNode.class);
        //NodeRegistry.register(ConstantNode.class);
        //NodeRegistry.register(MathAddNode.class);
        if (!FMLEnvironment.production) { //Register dev nodes, if you're reading this, feel free to enable this and recompile if you for some reason want these in your prod build
            //NodeRegistry.register(DebugLoggerNode.class);
        }

    }
    public static NodeDefinition get(String id) {
        return NODES.get(id);
    }

    public static Collection<NodeDefinition> getAll() {
        return Collections.unmodifiableCollection(NODES.values());
    }

    public static GraphNode create(String id) {
        NodeDefinition definition = get(id);

        if (definition == null) {
            throw new IllegalArgumentException("Unknown node: " + id);
        }

        try {
            return definition.nodeClass()
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "Could not instantiate node: " + id, e
            );
        }
    }
}
