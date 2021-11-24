package apu.oodj.vaccinestation.Internals.Users;

import apu.oodj.vaccinestation.Enums.UserType;

public class Manager extends User {
    public Manager(String username, String name, String email, String password) {
        super(username, name, email, password, UserType.Manager);
    }

    public Manager(String id, String username, String name, String email, String password, UserType type) {
        super(id, username, name, email, password, type);
    }

    /**
     * Parse the data from text database into Manager object.
     * @param data the data to be parsed.
     * @return The parsed User object.
     */
    public static Manager ParseData(String data) {
        // Parse data from the text database.
        String[] content = data.split(";;;");
        return new Manager(content[0], content[1], content[2], content[3], content[4], UserType.fromString(content[5]));
    }
}
