package services;

import entities.*;

import java.util.Date;

public final class ManagerService {
    private Worker manager;

    public ManagerService(Worker manager) {
        this.manager = manager;
    }

    public Seance createSeance(Hall hall, Film film, Date date, double price) {
        return new Seance(hall, film, date, price);
    }

    public String getName() {
        return manager.getName();
    }

    public void addSeance(Seances seances, Hall hall, Film film, Date date, double price) {
        Seance toBeAdded = new Seance(hall, film, date, price);
        seances.addSeance(toBeAdded);
    }

    public void removeSeance(Seances seances, Seance toBeRemoved) {
        seances.removeSeance(toBeRemoved);
    }

    public double getSalary() {
        return manager.getSalary();
    }
}
