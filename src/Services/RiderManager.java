package Services;

import Models.Driver;
import Models.Rider;
import Repository.DriverData;

import java.util.*;

public class RiderManager {
    private DriverData driverData = DriverData.getInstance();

    public List<Driver> matchDrivers(Rider rider) {
        List<Driver> drivers = driverData.getAllDrivers();
        return drivers.stream()
                .filter(d -> d.isAvailable() && DistanceCalculator.calculateDistance(
                        rider.getX(), rider.getY(), d.getX(), d.getY()) <= 5)
                .sorted(Comparator.comparingDouble(
                        d -> DistanceCalculator.calculateDistance(rider.getX(), rider.getY(), d.getX(), d.getY())))
                .limit(5)
                .toList();
    }
}

