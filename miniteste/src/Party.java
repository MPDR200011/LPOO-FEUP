public class Party extends Event {
    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public Party(Event e) {
        super(e);
    }

    public void addEvent(Event e) {
        for (String key: e.audience.keySet()) {
            addPerson(e.audience.get(key));
        }
    }
}
