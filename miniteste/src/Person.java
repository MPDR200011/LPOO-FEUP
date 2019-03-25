public abstract class Person implements User {
    private String name;
    private int age;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getUsername() {
        return name+age;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (obj.getClass().getSuperclass() != Person.class) return false;

        Person p = (Person) obj;
        return name.equals(p.name);
    }
}
