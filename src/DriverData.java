import java.util.*;

public class DriverData {
    private static DriverData instance;
    private final Map<String, Driver> drivers = new HashMap<>();

    private DriverData() {}

    public static DriverData getInstance() {
        if (instance == null) instance = new DriverData();
        return instance;
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
        System.out.println("Added Driver: " + driver.getId()); // ✅ Debugging Print
    }

    public List<Driver> getAllDrivers() {
        return new ArrayList<>(drivers.values());
    }

    // ✅ Fix: Add method to get driver by ID
    public Driver getDriverById(String id) {
        System.out.println("Fetching Driver: " + id); // ✅ Debugging Print
        return drivers.get(id);
    }
}
