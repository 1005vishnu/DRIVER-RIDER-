package Testing;

import static org.junit.jupiter.api.Assertions.*;

import Services.RideManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StopNonExistentRideTest {
    private RideManager rideManager;

    @BeforeEach
    void setUp() {
        rideManager = new RideManager();
    }

    @Test
    void testStoppingNonExistentRideFails() {
        String result = rideManager.stopRide("RIDE-999", 5, 5, 30);
        assertEquals("INVALID_RIDE", result, "Stopping a non-existent ride should fail");
    }
}
