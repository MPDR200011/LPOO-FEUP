package com.aor.refactoring.example4;

import java.util.Objects;

public class Worker extends Person {
    private Login loginInformation;

    public Worker(String name, String phone, String username, String password) {
        super(name, phone);
        this.loginInformation = new Login(username, password);
    }

    public boolean login(String username, String password) {
        return loginInformation.login(username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name) &&
                Objects.equals(phone, worker.phone) &&
                Objects.equals(loginInformation, worker.loginInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, loginInformation);
    }
}
