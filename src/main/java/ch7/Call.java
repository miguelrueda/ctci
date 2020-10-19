package ch7;

enum Rank {
    responder(0),
    manager(1),
    director(2);

    private int value;

    Rank(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}

class Caller {
    public Caller() {}
}

public class Call {

    // Minimal rank of employee who can handle this call
    private Rank rank;

    // Person who is calling
    private Caller caller;

    // Employee who is handling call
    private Employee handler;

    public Call(Caller c) {
        rank = Rank.responder;
        caller = c;
    }

    // Set employee who is handling call
    public void setHandler(Employee e) {
        handler = e;
    }

    public void reply(String message) {}

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank r) {
        rank = r;
    }

    public Rank incrementRank() {
        return null;
    }

    public void disconnect() {}
}
