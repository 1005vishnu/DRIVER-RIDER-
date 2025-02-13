import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DriverManager driverManager = new DriverManager();
        RiderManager riderManager = new RiderManager();
        RideManager rideManager = new RideManager();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "ADD_DRIVER" -> driverManager.addDriver(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                case "ADD_RIDER" -> System.out.println("Rider Added");
                case "MATCH" -> System.out.println("Matching Logic");
                case "START_RIDE" -> System.out.println(rideManager.startRide(input[1], new Rider(input[3], 0, 0), new Driver(input[2], 0, 0)));
                case "STOP_RIDE" -> System.out.println(rideManager.stopRide(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4])));
                case "BILL" -> {
                    Ride ride = RideData.getInstance().getRideById(input[1]);
                    double bill = BillingCalculator.calculateBill(ride);
                    System.out.printf("BILL %s %s %.2f%n", ride.getRideId(), ride.getDriver().getId(), bill);
                }
            }
        }
    }
}