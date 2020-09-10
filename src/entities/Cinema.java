package entities;

import java.util.ArrayList;

public final class Cinema {

    private final ArrayList<Hall> halls;

    public Cinema() {
        halls = new ArrayList<>();
    }

    public void addHall(Hall newHall) {
        halls.add(newHall);
    }

    public Hall getHall(int i) {
        return halls.get(i);
    }

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public boolean isHall(Hall hall) {
        for (Hall temp :
                halls) {
            if (temp.equals(hall))
                return true;
        }
        return false;
    }
}
