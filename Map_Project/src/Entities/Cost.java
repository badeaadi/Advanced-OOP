package Entities;

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
    double getTime() {
        return time;
    }
    void setTime(double newTime) {
        this.time = newTime;
    }
    double getPay() {
        return pay;
    }
    void setPay(double newPay) {
        this.pay = newPay;
    }
    double getDistance() {
        return distance;
    }
    void setDistance(double newDistance) {
        this.distance = newDistance;
    }
    int getIndex() {
        return index;
    }
    void setIndex(int newIndex) {
        this.index = newIndex;
    }

    public String getTrans() {
        return trans;
    }
    void setTrans(String trans) {
        this.trans = trans;
    }

    @Override
    public String toString() {
        return "It takes " + time + " hours, " + pay + " pay, " + distance + " distance,"  + trans;
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