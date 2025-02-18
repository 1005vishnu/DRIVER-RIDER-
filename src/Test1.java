import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Test1 {
    private DriverManager driverManager;
    private RideManager rideManager;
    private DriverData driverData;
    private RideData rideData;

    @BeforeEach
    void setUp() {
        // ✅ Reset Singleton instances using Reflection
        try {
            java.lang.reflect.Field driverField = DriverData.class.getDeclaredField("instance");
            driverField.setAccessible(true);
            driverField.set(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Reinitialize after reset
        driverManager = new DriverManager();
        driverData = DriverData.getInstance();
    }

    @Test
    void testRideScenario() {
        // ✅ Step 1: Add Driver
        driverManager.addDriver("D1", 1, 1);

        // ✅ Step 2: Fetch Drivers after adding
        List<Driver> allDrivers = driverData.getAllDrivers();
        System.out.println("All Drivers after adding: " + allDrivers);
        assertFalse(allDrivers.isEmpty(), "Driver list should not be empty");

        // ✅ Step 3: Fetch Driver from DriverData
        Driver driver = driverData.getDriverById("D1");
        assertNotNull(driver, "Driver should exist in DriverData");

        // ✅ Step 4: Ensure driver is available
        driver.setAvailability(true);

        // ✅ Step 5: Create Rider
        Rider rider = new Rider("R1", 0, 0);

        // ✅ Step 6: Start Ride
        rideManager = new RideManager();
        String startRideResult = rideManager.startRide("RIDE-001", rider, driver);
        assertEquals("RIDE_STARTED RIDE-001", startRideResult, "Ride should start successfully");

        // ✅ Step 7: Stop Ride
        String stopRideResult = rideManager.stopRide("RIDE-001", 4, 5, 32);
        assertEquals("RIDE_STOPPED RIDE-001", stopRideResult, "Ride should stop successfully");

        // ✅ Step 8: Calculate Bill
        rideData = RideData.getInstance();
        Ride ride = rideData.getRideById("RIDE-001");
        assertNotNull(ride, "Ride should exist in RideData");

        double bill = BillingCalculator.calculateBill(ride);
        assertTrue(bill > 0, "Bill amount should be greater than zero");

        // ✅ Step 9: Print Expected Output
        System.out.printf("BILL %s %s %.2f%n", ride.getRideId(), ride.getDriver().getId(), bill);
    }
}
