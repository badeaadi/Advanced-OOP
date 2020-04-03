import java.util.Comparator;

public class Cost {

    private double time, pay, distance; //hours, currency, kilometers
    private boolean poss;
    private int index;
    private String trans;

    Cost() {
        this.time = 0.0;
        this.pay = 0.0;
        this.distance = 0.0;
        this.poss = true;
    }
    Cost(double newTime, double newPay, double newDistance, boolean possible) {
        this.time = newTime ;
        this.pay = newPay;
        this.distance = newDistance;
        this.poss = possible;
    }
    Cost(double newTime, double newPay, double newDistance, boolean possible, int index) {
        this.time = newTime ;
        this.pay = newPay;
        this.distance = newDistance;
        this.poss = possible;
        this.index = index;
    }

    Cost add(Cost newCost) {
        return new Cost(this.time + newCost.time, this.pay + newCost.pay, this.distance + newCost.distance, poss);
    }
    public double getTime() {
        return time;
    }
    public void setTime(double newTime) {
        this.time = newTime;
    }
    public double getPay() {
        return pay;
    }
    public void setPay(double newPay) {
        this.pay = newPay;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double newDistance) {
        this.distance = newDistance;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int newIndex) {
        this.index = newIndex;
    }

    @Override
    public String toString() {
        return "It takes " + time + " hours, " + pay + " pay, " + distance + " distance,"  + trans;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
class CostTime implements Comparator<Cost> {

    @Override
    public int compare(Cost o1, Cost o2) {
        return Double.compare(o1.getTime(), o2.getTime());
    }
}

class CostDistance implements Comparator<Cost> {

    @Override
    public int compare(Cost o1, Cost o2) {
        return Double.compare(o1.getDistance(), o2.getDistance());
    }
}

class CostPay implements Comparator<Cost> {

    @Override
    public int compare(Cost o1, Cost o2) {
        return Double.compare(o1.getPay(), o2.getPay());
    }
}