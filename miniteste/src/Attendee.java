public class Attendee extends Person {

    private boolean hasPaid;

    public Attendee(String name) {
        super(name);
        this.hasPaid = false;
    }

    public Attendee(String name, int age) {
        super(name, age);
        this.hasPaid = false;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    @Override
    public String toString() {
        return "Attendee " + getName() + (hasPaid() ? " has" : " hasn't") + " paid its registration.";
    }
}
