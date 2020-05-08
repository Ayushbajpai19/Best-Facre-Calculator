import java.util.Arrays;

public class TransitCalculator {
  
  int totalDays, totalRides;
  String ridePass[] = {"Single Ride", "7 Day Unlimited", "30 Day Unlimited"};
  double passCost[] = {2.75, 33, 127};
  
  public TransitCalculator (int numDays, int numRides) {
    if (numDays > 0 && numDays < 30 && numRides > 1) {
    totalDays = numDays;
    totalRides = numRides;
    } else System.out.println("Invalid settings.");
  }
  
  public double unlimited7Price() {
    int passNum = totalDays/7;
    if(totalDays%7>0) passNum++;
    double passCost7 = passNum * passCost[1];
    return passCost7;
  }
  
  public double[] getRidePrices() {
    double passCosts[] = {totalRides*passCost[0], unlimited7Price(), passCost[2]};
    return passCosts;
  }
  
  public String getBestFare() {
    int num = 0;
    for (int i=1; i<3; i++){
      if(getRidePrices()[i] < getRidePrices()[num]) {
        num = i;
      }
    }
    return "You should choose the " +ridePass[num]+ " at " +getRidePrices()[num]/totalRides+ " per ride.";
  }
  
  public static void main (String[] args) {
    TransitCalculator one = new TransitCalculator(29, 76);
    TransitCalculator two = new TransitCalculator(1, 5);
    TransitCalculator three = new TransitCalculator(7, 32);
    one.getBestFare();
    two.getBestFare();
    three.getBestFare();
    System.out.println(one.getBestFare());
    System.out.println(two.getBestFare());
    System.out.println(three.getBestFare());
    
  }
}
