package io.takima;


import io.takima.service.EmployeeService;

import java.util.ArrayList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        ArrayList<UUID> uuids = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            uuids.add(UUID.randomUUID());
        }

        for (UUID uuid : uuids) {
            System.out.println(uuid);
        }
    }
}
