package com.daswath.examples.callcenter;

/**
 * Created by DAswath on 10/24/2016.
 */
public class Employee {
    private Call currentCall;
    private Rank empRank;

    public Employee(Rank rank) {
        this.empRank = rank;
    }

    public Rank getRank() {
        return empRank;
    }

    public void assignCall(Call newCall) {
        currentCall = newCall;
    }

    public boolean isFree() {
        return currentCall != null;
    }
}
