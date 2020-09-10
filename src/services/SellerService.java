package services;

import entities.*;

import java.util.ArrayList;

public final class SellerService {

    private Worker seller;

    public SellerService(Worker seller) {
        this.seller = seller;
    }

    public void setSeatTaken(Seance seance, int lineIndex, int seatIndex) {
        seance.getHall().getSeat(lineIndex, seatIndex).setTaken();
    }

    public ArrayList<Seance> filmSeancesInfo (Seances seances, Film film) {
        ArrayList<Seance> filmSeances = new ArrayList<>();

        for (Seance temp :
                seances.getSeances()) {
            if (temp.getFilm().equals(film))
                filmSeances.add(temp);
        }

        return filmSeances;
    }

    public double getSalary () {
        return seller.getSalary();
    }

    public Ticket giveTicket(Seances seancesList, Seance seance, int lineIndex, int seatIndex, Visitor visitor) {
        for (Seance s :
                seancesList.getSeances()) {
            if (s.equals(seance))
                return new Ticket(seance, lineIndex, seatIndex, visitor);
        }
        throw new ArrayIndexOutOfBoundsException("No such seance");
    }

}
