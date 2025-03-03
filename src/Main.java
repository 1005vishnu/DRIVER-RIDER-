import Services.RiderManager;
import Models.Driver;
import Models.Ride;
import Models.Rider;
import Repository.RideData;
import Services.BillingCalculator;
import Services.DriverManager;
import Services.RideManager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DriverManager driverManager = new DriverManager();
        RiderManager riderManager = new RiderManager();
        RideManager rideManager = new RideManager();

        while (sc.hasNextLine()) {
            try {
                String[] input = sc.nextLine().trim().split(" ");
                if (input.length == 0) continue; // Ignore empty input

                switch (input[0]) {
                    case "ADD_DRIVER" -> {
                        validateInput(input, 4);
                        driverManager.addDriver(input[1], parseInt(input[2]), parseInt(input[3]));
                        System.out.println("Driver Added: " + input[1]);
                    }
                    case "ADD_RIDER" -> {
                        validateInput(input, 2);
                        System.out.println("Rider Added: " + input[1]);
                    }
                    case "MATCH" -> {
                        validateInput(input, 2);
                        System.out.println("Matching Logic for Rider: " + input[1]);
                    }
                    case "START_RIDE" -> {
                        validateInput(input, 4);
                        System.out.println(rideManager.startRide(input[1], new Rider(input[3], 0, 0), new Driver(input[2], 0, 0)));
                    }
                    case "STOP_RIDE" -> {
                        validateInput(input, 5);
                        System.out.println(rideManager.stopRide(input[1], parseInt(input[2]), parseInt(input[3]), parseInt(input[4])));
                    }
                    case "BILL" -> {
                        validateInput(input, 2);
                        Ride ride = RideData.getInstance().getRideById(input[1]);
                        if (ride == null) throw new IllegalArgumentException("Invalid Ride ID: " + input[1]);
                        double bill = BillingCalculator.calculateBill(ride);
                        System.out.printf("BILL %s %s %.2f%n", ride.getRideId(), ride.getDriver().getId(), bill);
                    }
                    default -> throw new IllegalArgumentException("Invalid Command: " + input[0]);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format - " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    // Helper method to validate input length
    private static void validateInput(String[] input, int expectedLength) {
        if (input.length != expectedLength) {
            throw new IllegalArgumentException("Invalid input format for command: " + input[0]);
        }
    }

    // Helper method to parse integers safely
    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format: " + value);
        }
    }
}
