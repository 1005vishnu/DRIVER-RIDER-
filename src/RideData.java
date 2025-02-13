import java.util.*;

public class RideData {
    private static RideData instance;
    private final Map<String, Ride> rides = new HashMap<>();

    private RideData() {}

    public static RideData getInstance() {
        if (instance == null) instance = new RideData();
        return instance;
    }

    public void addRide(Ride ride) { rides.put(ride.getRideId(), ride); }
    public Ride getRideById(String rideId) { return rides.get(rideId); }
}