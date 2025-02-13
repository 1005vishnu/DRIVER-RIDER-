import java.util.*;

public class DriverData {
    private static DriverData instance;
    private final Map<String, Driver> drivers = new HashMap<>();

    private DriverData() {}

    public static DriverData getInstance() {
        if (instance == null) instance = new DriverData();
        return instance;
    }

    public void addDriver(Driver driver) { drivers.put(driver.getId(), driver); }
    public List<Driver> getAllDrivers() { return new ArrayList<>(drivers.values()); }
}