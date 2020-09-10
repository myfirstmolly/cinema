package entities;

public final class Seat {

    private boolean isFree;

    public Seat () {
        this.isFree = true;
    }

    public void setFree() {
        this.isFree = true;
    }

    public void setTaken() {
        this.isFree = false;
    }

    public boolean isFree() {
        return isFree;
    }

}
