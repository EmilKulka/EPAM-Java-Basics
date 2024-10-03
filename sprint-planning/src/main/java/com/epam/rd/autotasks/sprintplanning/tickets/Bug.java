package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    private final UserStory userStory;
    private boolean completed;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if(userStory == null || !userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
        this.completed = false;
    }

    public UserStory getUserStory() {
        return userStory;
    }
    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format("[Bug %d] %s: %s", getId(), getUserStory().getName(), getName());
    }
}
