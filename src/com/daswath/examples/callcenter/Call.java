package com.daswath.examples.callcenter;

/**
 * Created by DAswath on 10/24/2016.
 */
public class Call {
    private Rank callHandlerRank;
    private Caller caller;
    private Employee callHandler;

    public Call(Caller c) {
        this.caller = c;
        this.callHandlerRank = Rank.RESPONDENT;
    }

    public void setCallHandler(Employee e) {
        callHandler = e;
    }

    public void reply(String message) {
        System.out.println(message);
    }

    public void hangUp() {
        reply("done");
    }

    public Rank getCallHandlerRank() {
        return callHandlerRank;
    }

    public Rank incrementRank() {
        if (callHandlerRank == Rank.RESPONDENT) {
            callHandlerRank = Rank.MANAGER;
        } else if (callHandlerRank == Rank.MANAGER) {
            callHandlerRank = Rank.DIRECTOR;
        }
        return callHandlerRank;
    }
}
