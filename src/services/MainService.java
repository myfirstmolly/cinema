package services;

import entities.*;

import java.util.ArrayList;
import java.util.Date;

public final class MainService {

    private CashTransactions cashTransactions;
    private CheckerService checkerService;
    private ManagerService managerService;
    private final Cinema myCinema = new Cinema();
    private final Seances seances = new Seances();

    public MainService(Worker seller, Worker checker, Worker manager) {
        SellerService sellerService = new SellerService(seller);
        cashTransactions = new CashTransactions(sellerService);
        checkerService = new CheckerService(checker);
        managerService = new ManagerService(manager);
    }

    public void addHall(String name, int lines, int seats) {
        Hall toBeAdded = new Hall(name, lines, seats);
        myCinema.addHall(toBeAdded);
        System.out.println("Hall '" + name + "' is added.");
    }

    public Hall getHall(int i) {
        return myCinema.getHall(i);
    }

    public Seance getSeance(int i) {
        return seances.getSeances().get(i);
    }

    public void addSeance(Hall hall, Film film, Date date, double price) {
        if(!myCinema.isHall(hall)) {
            System.out.println("There is no such hall");
            return;
        }

        managerService.addSeance(seances, hall, film, date, price);
        System.out.println("Manager " + managerService.getName() + " added a seance in hall '" +
                hall.getName() + "' scheduled to: " + date + ".\nThe film is '" + film.getName() +
                "'.\nThe price for a ticket is: " + price);
    }

    public String getFilmSeancesInfo(Film film) {
        System.out.println("Seances for '" + film.getName() + "': ");
        ArrayList<Seance> filmSeances = cashTransactions.getSellerService().filmSeancesInfo(seances, film);
        if(filmSeances.isEmpty())
            return "There are no seances for this film.";
        StringBuilder stringBuilder = new StringBuilder();
        for (Seance s :
                filmSeances) {
            stringBuilder.append("Date: "
                    + s.getDate() + ". Hall: " + s.getHall().getName() + ". Price: " + s.getPrice() + "\n");
        }
        return stringBuilder.toString();
    }

    public Ticket sellTicket(Seance seance, int lineIndex, int seatIndex, Visitor visitor) {
        Ticket ticket = cashTransactions.sellTicket(seances, seance, lineIndex, seatIndex, visitor);
        System.out.println("Ticket to '" + seance.getFilm().getName() + "', line " + lineIndex +
                " seat " + seatIndex + " is sold to " + visitor.getName() + ".");
        return ticket;
    }

    public void checkTicket(Ticket ticket, Visitor visitor, Hall hall) {
        System.out.println(visitor.getName() + "'s ticket is checked. " +
                checkerService.checkTicket(ticket, visitor, hall));
    }

    public double earnedToday() {
        return cashTransactions.getMoney() - cashTransactions.getSalary() -
                checkerService.getSalary() - managerService.getSalary();
    }
}
