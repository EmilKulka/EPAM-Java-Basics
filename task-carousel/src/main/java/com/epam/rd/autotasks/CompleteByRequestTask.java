package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean completed = false;
    private boolean finished = false;

    public CompleteByRequestTask() {
    }

    @Override
    public void execute() {
        if(completed && !finished) {
            this.finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        this.completed = true;
    }
}
