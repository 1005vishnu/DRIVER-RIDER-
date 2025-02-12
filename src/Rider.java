public class Rider {
    private String id;
    private int xCoordinate;
    private int yCoordinate;

    public Rider(String id, int x, int y) {
        this.id = id;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public String getId() { return id; }
    public int getX() { return xCoordinate; }
    public int getY() { return yCoordinate; }
}



