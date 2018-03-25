package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;
    State state;
    @Override
    public void run() {
        System.out.println(state);
        while (target.getState().toString()!="TERMINATED") {
            if (state!=target.getState()) {
                System.out.println(target.getState().toString());
                state = target.getState();
            }
        }
    }
    LoggingStateThread(Thread target) {
        this.target = target;
        this.state = target.getState();
    }
}
