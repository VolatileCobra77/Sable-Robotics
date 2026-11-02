package ca.volatilecobra77.sable_robotics.Graph;

import java.util.UUID;

public record GraphConnection(
        UUID source,
        String sourcePort,
        UUID target,
        String targetPort,
        GraphDataType type
) {

}
