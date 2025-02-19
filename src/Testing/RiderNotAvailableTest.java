package Testing;

import static org.junit.jupiter.api.Assertions.*;

import Models.Driver;
import Models.Rider;
import Repository.DriverData;
import Services.DriverManager;
import Services.RideManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RiderNotAvailableTest {
    private DriverManager driverManager;
    private RideManager rideManager;
    private DriverData driverData;

    @BeforeEach
    void setUp() {
        driverManager = new DriverManager();
        rideManager = new RideManager();
        driverData = DriverData.getInstance();

        // ✅ Adding a driver who is available
        driverManager.addDriver("D1", 1, 1);
        Driver driver = driverData.getDriverById("D1");
        driver.setAvailability(true);
    }

    @Test
    void testBookingFailsWhenRiderNotAvailable() {
        Rider rider = null; // ❌ Models.Rider is null in this case
        Driver driver = driverData.getDriverById("D1");

        String result = rideManager.startRide("RIDE-001", rider, driver);
        assertEquals("INVALID_RIDER", result, "Booking should fail when rider is null");
    }
}
