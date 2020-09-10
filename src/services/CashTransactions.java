package services;

import entities.Seance;
import entities.Seances;
import entities.Ticket;
import entities.Visitor;

public final class CashTransactions {

    private static double cash;
    private SellerService sellerService;

    public CashTransactions(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public Ticket sellTicket(Seances seances, Seance seance, int lineIndex, int seatIndex, Visitor visitor) {
        Ticket ticket = sellerService.giveTicket(seances, seance, lineIndex, seatIndex, visitor);
        sellerService.setSeatTaken(seance, lineIndex, seatIndex);
        cash += seance.getPrice();
        visitor.setMoney(visitor.getMoney() - seance.getPrice());
        return ticket;
    }

    public SellerService getSellerService() {
        return sellerService;
    }

    public double getSalary() {
        return sellerService.getSalary();
    }

    public double getMoney() {
        return cash;
    }

}
