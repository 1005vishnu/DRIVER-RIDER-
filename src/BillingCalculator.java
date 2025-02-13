public class BillingCalculator
{
    public static double calculateBill(Ride ride)
    {
        double baseFare = 50;
        double distanceFare = 6.5 * ride.calculateDistance();
        double timeFare = 2 * ride.getTimeTaken();
        double subtotal = baseFare + distanceFare + timeFare;
        return subtotal * 1.2; // Adding 20% tax
    }
}