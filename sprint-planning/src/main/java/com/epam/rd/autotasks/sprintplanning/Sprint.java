package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    private final int capacity;
    private final int ticketLimit;
    private Ticket[] tickets;
    private int currentEstimate = 0;
    private int nextTicketIndex = 0;


    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null || userStory.isCompleted()) {
            return false;
        }
        for(UserStory dependency : userStory.getDependencies()) {
            boolean dependencyFound = false;
            for(Ticket ticket : tickets) {
                if(ticket == dependency) {
                    dependencyFound = true;
                    break;
                }
            }
            if(!dependencyFound) {
                return false;
            }
        }

        if(nextTicketIndex < ticketLimit && userStory.getEstimate() + currentEstimate <= capacity){
            currentEstimate += userStory.getEstimate();
            tickets[nextTicketIndex++] = userStory;
            return true;
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null|| bugReport.getUserStory() == null || bugReport.isCompleted()) {
            return false;
        }
        if(nextTicketIndex < ticketLimit && bugReport.getEstimate() + currentEstimate <= capacity) {
            currentEstimate += bugReport.getEstimate();
            tickets[nextTicketIndex++] = bugReport;
            return true;
        }

        return false;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, nextTicketIndex);
    }

    public int getTotalEstimate() {
        return currentEstimate;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTicketLimit() {
        return ticketLimit;
    }
}
