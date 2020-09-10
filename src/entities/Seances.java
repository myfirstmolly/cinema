package entities;

import java.util.ArrayList;

public final class Seances {

    private final ArrayList<Seance> seances;

    public Seances() {
        seances = new ArrayList<>();
    }

    public void addSeance(Seance newSeance) {
        seances.add(newSeance);
    }

    public void removeSeance(Seance newSeance) {
        seances.remove(newSeance);
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }
}
