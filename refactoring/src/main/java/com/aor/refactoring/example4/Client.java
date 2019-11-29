package com.aor.refactoring.example4;

import java.util.Objects;

public class Client extends Person {

    public Client(String name, String phone) {
        super(name, phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client worker = (Client) obj;
        return Objects.equals(name, worker.name) &&
                Objects.equals(phone, worker.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
