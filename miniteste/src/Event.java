import java.util.HashMap;
import java.util.Map;

public class Event {
    protected String title;
    protected String date;
    protected String description;

    protected Map<String, Person> audience;

    public Event(String title) {
        this(title, "");
    }

    public Event(String title, String date) {
        this(title, date, "");
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.audience = new HashMap<>();
    }

    public Event(Event e) {
        this(e.title, e.date, e.description);
        this.audience = e.audience;
    }

    public void addPerson(Person p) {
        if (!audience.containsKey(p.getName())) {
            audience.put(p.getName(), p);
        }
    }

    public int getAudienceCount() {
        return audience.size();
    }

    @Override
    public String toString() {
        return title+" is a "+description+" and will be held at "+date+".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Event e = (Event) obj;
        return title.equals(e.title) && date.equals(e.date) && description.equals(e.description);
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
