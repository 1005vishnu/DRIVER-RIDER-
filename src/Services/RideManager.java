package Services;

import Models.Driver;
import Models.Ride;
import Models.Rider;
import Repository.RideData;

public class RideManager {
    private RideData rideData = RideData.getInstance();

    public String startRide(String rideId, Rider rider, Driver driver) {
        if (rider == null) {
            throw new IllegalArgumentException("Invalid Rider");
        }
        if (rideData.getRideById(rideId) != null) {
            throw new IllegalArgumentException("INVALID_RIDE");
        }
        if (driver == null || !driver.isAvailable()) {
            throw new IllegalArgumentException("INVALID_RIDE");
        }

        Ride ride = new Ride(rideId, rider, driver);
        rideData.addRide(ride);
        driver.setAvailability(false);

        return "RIDE_STARTED " + rideId;
    }


    public String stopRide(String rideId, int endX, int endY, int timeTaken) {
        Ride ride = rideData.getRideById(rideId);
        if (ride == null || !ride.isActive()) {
            throw new IllegalArgumentException("INVALID_RIDE"); // Ensure exception is thrown
        }

        ride.stopRide(endX, endY, timeTaken);
        ride.getDriver().setAvailability(true);
        return "RIDE_STOPPED " + rideId;
    }


    public String cancelRide(String rideId) {
        Ride ride = rideData.getRideById(rideId);
        if (ride == null || !ride.isActive()) return "INVALID_CANCEL";

        ride.getDriver().setAvailability(true);
        rideData.getAllRides().remove(rideId);

        return "RIDE_CANCELLED " + rideId;
    }

    public double estimateFare(Rider rider, Driver driver, int endX, int endY) {
        if (rider == null || driver == null || !driver.isAvailable()) return -1; // Check for null rider

        double distance = DistanceCalculator.calculateDistance(rider.getX(), rider.getY(), endX, endY);
        return 50 + (6.5 * distance);
    }

    public double getBill(String rideId) {
        Ride ride = rideData.getRideById(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride not found");
        }
        return BillingCalculator.calculateBill(ride);
    }

}
