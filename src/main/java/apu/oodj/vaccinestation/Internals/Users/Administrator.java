package apu.oodj.vaccinestation.Internals.Users;

import apu.oodj.vaccinestation.Enums.UserType;

public class Administrator extends User {
    public Administrator(String name, String email, String password) {
        super(name, email, password, UserType.Administrator);
    }

    public Administrator(String id, String name, String email, String password, UserType type) {
        super(id, name, email, password, type);
    }
}
