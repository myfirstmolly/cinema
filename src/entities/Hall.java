package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Hall {

    private final UUID code;
    private String name;
    private final List<List<Seat>> seats;

    public Hall(String name, int lines, int seats) {
        this.name = name;
        this.seats = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            ArrayList<Seat> temp = new ArrayList<>();
            for (int j = 0; j < seats; j++) {
                temp.add(new Seat());
            }
            this.seats.add(temp);
        }

        this.code = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return code == hall.code ||
                Objects.equals(name, hall.name);
    }

    @Override
    public String toString() {
        return "Hall{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", hall=" + seats +
                '}';
    }

    public String getCode() {
        return code.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seat getSeat(int lineIndex, int seatIndex) {
        return seats.get(lineIndex).get(seatIndex);
    }

    public List<List<Seat>> getSeats() {
        return seats;
    }
}
