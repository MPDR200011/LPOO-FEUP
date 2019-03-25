import java.util.ArrayList;
import java.util.List;

public class Bar {
    private boolean isHappyHour;
    private List<BarObserver> observers;

    public Bar() {
        this.isHappyHour = false;
        this.observers = new ArrayList<>();
    }

    public void startHappyHour() {
        isHappyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        isHappyHour = false;
        notifyObservers();
    }

    public boolean isHappyHour() {
        return isHappyHour;
    }

    void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
