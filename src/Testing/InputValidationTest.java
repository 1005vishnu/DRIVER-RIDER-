package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Services.DriverManager;
import Services.RideManager;
import Models.Driver;

public class InputValidationTest {
    private DriverManager driverManager;
    private RideManager rideManager;

    @BeforeEach
    void setUp() {
        driverManager = new DriverManager();
        rideManager = new RideManager();
    }

    @Test
    void testInvalidDriverId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            driverManager.addDriver("", 1, 1); // Empty ID
        });
        assertEquals("Invalid Driver ID", exception.getMessage());
    }

    @Test
    void testInvalidCoordinates() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            driverManager.addDriver("D1", Integer.parseInt("X"), 5); // Non-numeric X
        });
        assertTrue(exception.getMessage().contains("For input string: \"X\""));
    }

    @Test
    void testStartRideWithInvalidRider() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rideManager.startRide("RIDE-001", null, new Driver("D1", 1, 1));
        });
        assertEquals("Invalid Rider", exception.getMessage());
    }
    @Test
    void testStopNonExistentRide() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rideManager.stopRide("RIDE-999", 4, 5, 10); //  Non-existent ride
        });
        assertEquals("INVALID_RIDE", exception.getMessage()); // ✅ Ensure correct error message
    }


    @Test
    void testBillingForNonExistentRide() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double bill = rideManager.getBill("RIDE-999");
        });
        assertEquals("Ride not found", exception.getMessage());
    }

}
