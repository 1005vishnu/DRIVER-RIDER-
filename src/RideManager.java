public class RideManager {
    private RideData rideData = RideData.getInstance();

    public String startRide(String rideId, Rider rider, Driver driver) {
        if (rideData.getRideById(rideId) != null) return "INVALID_RIDE";
        Ride ride = new Ride(rideId, rider, driver);
        rideData.addRide(ride);
        driver.setAvailability(false);
        return "RIDE_STARTED " + rideId;
    }

    public String stopRide(String rideId, int endX, int endY, int timeTaken) {
        Ride ride = rideData.getRideById(rideId);
        if (ride == null || !ride.isActive()) return "INVALID_RIDE";
        ride.stopRide(endX, endY, timeTaken);
        ride.getDriver().setAvailability(true);
        return "RIDE_STOPPED " + rideId;
    }
}