import entities.*;
import services.MainService;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Worker ticketSeller = new Worker("Victoria", "Kostenko", 200);
        Worker manager = new Worker("Andrew", "Petrov", 300);
        Worker ticketChecker = new Worker("Max", "Orlov", 300);

        MainService mainService = new MainService(ticketSeller, ticketChecker, manager);

        mainService.addHall("Big Hall", 10, 20);
        mainService.addHall("Medium Hall", 6, 15);
        mainService.addHall("Small Hall", 5, 10);

        System.out.println();

        Film trainspotting = new Film("Trainspotting", "Dark comedy",
                "Danny Boyle", 1996, Rating.NC17);
        Film seven = new Film("Se7en", "Crime thriller", "David Fincher",
                1995, Rating.R);
        Date date1 = new Date(2020, Calendar.NOVEMBER, 18, 16, 30);
        Date date2 = new Date(2020, Calendar.NOVEMBER, 19, 15, 30);

        mainService.addSeance(mainService.getHall(1), trainspotting, date1, 300);
        mainService.addSeance(mainService.getHall(0), seven, date1, 400);
        mainService.addSeance(mainService.getHall(1), trainspotting, date2, 300);

        System.out.println();

        System.out.println("Seances info:");
        System.out.println(mainService.getFilmSeancesInfo(trainspotting));
        System.out.println(mainService.getFilmSeancesInfo(seven));

        Visitor visitor1 = new Visitor("Marie", 18, 500);
        Visitor visitor2 = new Visitor("Dan", 13, 400);
        Visitor visitor3 = new Visitor("Andrew", 32, 200);

        Ticket ticket1 = mainService.sellTicket(mainService.getSeance(0), 3, 5, visitor1);
        Ticket ticket2 = mainService.sellTicket(mainService.getSeance(1), 6, 5, visitor2);
        Ticket ticket3 = mainService.sellTicket(mainService.getSeance(1), 6, 4, visitor3);

        System.out.println();

        mainService.checkTicket(ticket1, visitor1, mainService.getHall(1));
        mainService.checkTicket(ticket2, visitor2, mainService.getHall(0));
        mainService.checkTicket(ticket3, visitor2, mainService.getHall(1));
        mainService.checkTicket(ticket3, visitor3, mainService.getHall(2));

        System.out.println();
        System.out.println("Counting money earned today: " + mainService.earnedToday());
    }
}
