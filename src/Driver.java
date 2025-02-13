

public class Driver
{
    private String id;
    private int xCoordinate;
    private int yCoordinate;
    private boolean isAvailable;

    public Driver(String id, int x, int y)
    {
        this.id = id;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.isAvailable = true;
    }

    public String getId()
    {
        return id;}
    public int getX()
    {
        return xCoordinate;}
    public int getY()
    { return yCoordinate;
    }
    public boolean isAvailable()
    { return isAvailable;
    }

    public void setAvailability(boolean available)
    {
        this.isAvailable = available; }
    public void updateLocation(int x, int y)
    {
        this.xCoordinate = x; this.yCoordinate = y; }
}

