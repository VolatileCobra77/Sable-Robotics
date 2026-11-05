package ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec.BaseExecNode;

public class ExecPort extends NodePort{
    private boolean fired;
    public ExecPort(String name, BaseExecNode parentNode, boolean input, int id) {
        super(GraphDataType.EXEC, name, parentNode.getId(), input, id);
    }
    public void setActive(){
        fired = true;
    }

    @Override
    public Object data(GraphExecutionContext context) {
        if (fired) {
            fired = false;
            context.processPort(this);
        };
        return null;
    }
}
