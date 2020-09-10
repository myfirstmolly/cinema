package entities;

public final class Ticket {
    private final Seance seance;
    private final int lineIndex;
    private final int seatIndex;
    private Visitor visitor;
    private final double price;

    public Ticket (Seance seance, int lineIndex, int seatIndex, Visitor visitor) {
        this.seance = seance;
        this.lineIndex = lineIndex;
        this.seatIndex = seatIndex;
        this.visitor = visitor;
        this.price = seance.getPrice();
    }

    public Hall getHall() {
        return seance.getHall();
    }

    public Rating getRating() {
        return seance.getFilm().getRating();
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public double getPrice() {
        return price;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public int getSeatIndex() {
        return seatIndex;
    }

    @Override
    public String toString () {
        return "Film: " + seance.getFilm().getName() + "\nHall: " +
                getHall().getName() + ". Line: " + lineIndex
                + " Seat: " + seatIndex + "\nPrice: " + price;
    }
}
