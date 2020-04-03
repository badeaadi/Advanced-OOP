public class Cost {

    private double time, pay, distance; //hours, currency, kilometers
    private boolean poss;

    Cost(double newTime, double newPay, double newDistance, boolean possible) {
        this.time = newTime ;
        this.pay = newPay;
        this.distance = newDistance;
        this.poss = possible;
    }

    Cost add(Cost newCost) {
        return new Cost(this.time + newCost.time, this.pay + newCost.pay, this.distance + newCost.distance, poss);
    }
}
