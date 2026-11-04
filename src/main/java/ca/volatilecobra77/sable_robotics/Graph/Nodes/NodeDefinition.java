package ca.volatilecobra77.sable_robotics.Graph.Nodes;

public record NodeDefinition(
        String id,
        String name,
        String category,
        String description,
        Class<? extends GraphNode> nodeClass,
        boolean executionNode
) {}