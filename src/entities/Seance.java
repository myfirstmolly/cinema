package entities;

import java.util.Date;

public final class Seance {

    private Hall hall;
    private final Film film;
    private Date date;
    private final double price;

    public Seance(Hall hall, Film film, Date date, double price) {
        this.hall = hall;
        this.film = film;
        this.date = date;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "hall=" + hall +
                ", film=" + film +
                ", date=" + date +
                '}';
    }

    public boolean isSeatFree(int line, int place) {
        return hall.getSeat(line, place).isFree();
    }

    public double getPrice() {
        return price;
    }

    public Hall getHall() {
        return hall;
    }

    public Film getFilm() {
        return film;
    }

    public Date getDate() {
        return date;
    }

}
