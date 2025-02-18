import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DuplicateRideTest {
    private DriverManager driverManager;
    private RideManager rideManager;
    private DriverData driverData;
    private RideData rideData;

    @BeforeEach
    void setUp() {
        driverManager = new DriverManager();
        rideManager = new RideManager();
        driverData = DriverData.getInstance();
        rideData = RideData.getInstance();

        // ✅ Adding a driver who is available
        driverManager.addDriver("D1", 1, 1);
        Driver driver = driverData.getDriverById("D1");
        driver.setAvailability(true);
    }

    @Test
    void testBookingFailsForDuplicateRideId() {
        Rider rider = new Rider("R1", 0, 0);
        Driver driver = driverData.getDriverById("D1");

        rideManager.startRide("RIDE-001", rider, driver);

        String result = rideManager.startRide("RIDE-001", rider, driver);
        assertEquals("INVALID_RIDE", result, "Booking should fail for duplicate ride ID");
    }
}

