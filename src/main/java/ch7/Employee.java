package ch7;

public abstract class Employee {

    private Call currentCall = null;
    protected Rank rank;

    public Employee(CallHandler handler) {}

    // Start the conversation
    public void receiveCall(Call call) {}

    // The issue is resolved, finish the call
    public void callCompleted() {}

    // The issue has not been resolved. Escalate the call, and assign a new call to the employee
    public void escalateAndReassign() {}

    //Assign a new call to an employee, if employee is free
    public boolean assignNewCall() {
        return false;
    }

    // Return whether or not the employee is free
    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}

class Manager extends Employee {

    public Manager(CallHandler handler) {
        super(handler);
        rank = Rank.manager;
    }
}

class Director extends Employee {
    public Director(CallHandler handler) {
        super(handler);
        rank = Rank.director;
    }
}

class Respondent extends Employee {

    public Respondent(CallHandler handler) {
        super(handler);
        rank = Rank.responder;
    }
}
