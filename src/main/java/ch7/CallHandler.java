package ch7;

import java.util.List;

public class CallHandler {

    // 3 levels of employees: respondents, managers, directors
    private final int LEVELS = 3;

    // Initialize 10 respondents, 4 managers and 2 directors
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;

    // Queues for each call's rank
    List<List<Call>> callQueues;

    public CallHandler() {}

    // Gets the first available employee who can handle this call
    public Employee getHandlerForCall(Call call) {
        return null;
    }

    // Routes the call to an available employee, or saves in a queue if no employee is available
    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    // Routes the call to an available employee, or saves in a queue if no employee is available
    public void dispatchCall(Call call) {
        // Try to route the call to an employee with minimal rank
        Employee emp = getHandlerForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            // Place the call into corresponding call queue according to its rank
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    // An employee got free. Look for waiting call that employee can serve. Return true if
    // we assigned a call, fallse otherwise
    public boolean assignCall(Employee emp) {
        return false;
    }
}
