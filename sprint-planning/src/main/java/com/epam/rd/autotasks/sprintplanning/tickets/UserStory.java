package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    private UserStory[] dependencies;
    private boolean completed;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependencies = dependsOn;
        this.completed = false;
    }

    @Override
    public void complete() {
        for (UserStory dependency : dependencies) {
            if (!dependency.isCompleted()) {
                return;
            }
        }
        this.completed = true;
    }

    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return String.format("[US %d] %s", getId(), getName());
    }


}
