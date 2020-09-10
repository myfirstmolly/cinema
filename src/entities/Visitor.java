package entities;

public final class Visitor {
    private final int age;
    private final String name;
    private double money;

    public Visitor(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void watchSchedule() {
        System.out.println("I want to watch a movie!");
    }
}
