package services;

import entities.*;

import java.util.EnumMap;

public final class CheckerService {

    private Worker ticketChecker;

    public CheckerService(Worker ticketChecker) {
        this.ticketChecker = ticketChecker;
    }

    private boolean ticketIsValid(Ticket ticket, Visitor visitor, Hall hall) {
        if (ticket == null) return false;

        boolean rightHall = ticket.getHall().equals(hall);
        boolean rightVisitor = ticket.getVisitor().equals(visitor);
        boolean appropriateAge = visitor.getAge() >= ticket.getRating().getAge();

        if (rightHall && rightVisitor && appropriateAge) return true;
        return false;
    }

    public String checkTicket(Ticket ticket, Visitor visitor, Hall hall) {
        if (ticket == null) return "Ticket is invalid.";

        boolean rightHall = ticket.getHall().equals(hall);
        boolean rightVisitor = ticket.getVisitor().equals(visitor);
        boolean appropriateAge = visitor.getAge() >= ticket.getRating().getAge();

        if(!rightHall) return "The hall is wrong. Ticket is invalid.";
        if(!rightVisitor) return "The name on ticket doesn't match visitor's name. Ticket is invalid.";
        if(!appropriateAge) return "Visitor's age doesn't match film rating.";

        return "Ticket is valid.";
    }

    public double getSalary() {
        return ticketChecker.getSalary();
    }
}
