package Testing;

import static org.junit.jupiter.api.Assertions.*;

import Models.Driver;
import Models.Rider;
import Repository.DriverData;
import Services.DriverManager;
import Services.RideManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DriverNotAvailableTest {
    private DriverManager driverManager;
    private RideManager rideManager;
    private DriverData driverData;

    @BeforeEach
    void setUp() {
        driverManager = new DriverManager();
        rideManager = new RideManager();
        driverData = DriverData.getInstance();


        driverManager.addDriver("D1", 1, 1);
        Driver driver = driverData.getDriverById("D1");
        driver.setAvailability(false);
    }

    @Test
    void testBookingFailsWhenDriverNotAvailable() {
        Rider rider = new Rider("R1", 0, 0);
        Driver driver = driverData.getDriverById("D1");

        String result = rideManager.startRide("RIDE-001", rider, driver);
        assertEquals("INVALID_RIDE", result, "Booking should fail when no available drivers");
    }
}
