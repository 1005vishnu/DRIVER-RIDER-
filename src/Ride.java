
public class Ride
{
    private String rideId;
    private Rider rider;
    private Driver driver;
    private int startX, startY, endX, endY, timeTaken;
    private boolean isActive;

    public Ride(String rideId, Rider rider, Driver driver)
    {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.startX = rider.getX();
        this.startY = rider.getY();
        this.isActive = true;
    }

    public String getRideId()
    {
        return rideId; }
    public Driver getDriver()
    {
        return driver;
    }
    public boolean isActive()
    { return isActive; }

    public void stopRide(int endX, int endY, int timeTaken)
    {
        this.endX = endX;
        this.endY = endY;
        this.timeTaken = timeTaken;
        this.isActive = false;
    }

    public double calculateDistance()
    {
        return Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }

    public int getTimeTaken()
    { return timeTaken;
    }
}
