package com.daswath.examples.callcenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAswath on 10/24/2016.
 */
public class CallHandler {
    private final int LEVELS = 3;

    private final int NUM_RESP = 2;
    private final int NUM_MANAGERS = 1;
    private final int NUM_DIRECTORS = 1;

    private List<List<Employee>> employeeLevels;

    private List<List<Call>> callQueues;

    public CallHandler() {
        employeeLevels = new ArrayList<List<Employee>>(LEVELS);
        callQueues = new ArrayList<List<Call>>(LEVELS);

        createEmpsForLevel(0, NUM_RESP, Rank.RESPONDENT);
        createEmpsForLevel(1, NUM_MANAGERS, Rank.MANAGER);
        createEmpsForLevel(2, NUM_DIRECTORS, Rank.DIRECTOR);
    }

    private void createEmpsForLevel(int level, int size, Rank rank) {
        List<Employee> emps = new ArrayList<Employee>(size);
        for(int i = 0; i < size; i++) {
            emps.add(new Employee(rank));
        }
        employeeLevels.add(level, emps);
    }


    public void dispatchCall(Caller caller) {
        Call newCall = new Call(caller);
        Employee emp = getHandlerForCall(newCall);
        if (emp != null) {
            newCall.setCallHandler(emp);
            emp.assignCall(newCall);
        } else {
            newCall.reply("Please wait for a free employee");
            callQueues.get(newCall.getCallHandlerRank().ordinal()).add(newCall);
        }
    }

    public boolean assignCallToEmployee(Employee e) {
        for(int level = e.getRank().ordinal(); level >= 0; level--) {
            List<Call> callQueuesAtLevel = callQueues.get(level);
            if (callQueuesAtLevel.size() == 0) {
                return false;
            }
            Call callOnQ = callQueuesAtLevel.get(0);
            if (callOnQ != null) {
                e.assignCall(callOnQ);
                callOnQ.setCallHandler(e);
                return true;
            }
        }
        return false;
    }


    private Employee getHandlerForCall(Call call) {
        for (int level = call.getCallHandlerRank().ordinal(); level < LEVELS - 1; level++) {
            List<Employee> empsAtLevel = employeeLevels.get(level);
            for (Employee e : empsAtLevel) {
                if (e.isFree()) {
                    return e;
                }
            }
        }
        return null;
    }
}
