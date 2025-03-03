package Services;

import Models.Driver;
import Repository.DriverData;

import java.util.*;
public class DriverManager {
    private DriverData driverData = DriverData.getInstance();

    public void addDriver(String id, int x, int y) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Driver ID");
        }
        driverData.addDriver(new Driver(id, x, y));
    }

    public List<Driver> getAvailableDrivers() {
        return driverData.getAllDrivers().stream()
                .filter(Driver::isAvailable)
                .toList();
    }
}
