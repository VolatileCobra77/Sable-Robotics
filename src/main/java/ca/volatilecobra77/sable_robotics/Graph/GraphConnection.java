package ca.volatilecobra77.sable_robotics.Graph;

import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;

import java.util.UUID;

public record GraphConnection(
        UUID source,
        NodePort sourcePort,
        UUID target,
        NodePort targetPort,
        GraphDataType type
) {

}
