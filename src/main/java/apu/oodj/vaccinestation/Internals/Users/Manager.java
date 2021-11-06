package apu.oodj.vaccinestation.Internals.Users;

import apu.oodj.vaccinestation.Enums.UserType;

public class Manager extends User {
    public Manager(String name, String email, String password) {
        super(name, email, password, UserType.Manager);
    }

    public Manager(String id, String name, String email, String password, UserType type) {
        super(id, name, email, password, type);
    }
}
