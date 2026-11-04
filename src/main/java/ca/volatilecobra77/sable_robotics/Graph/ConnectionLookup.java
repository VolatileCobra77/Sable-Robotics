package ca.volatilecobra77.sable_robotics.Graph;

import java.util.UUID;

public record ConnectionLookup(
        UUID source,
        UUID dest
) {
}
