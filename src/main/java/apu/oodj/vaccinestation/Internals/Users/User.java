package apu.oodj.vaccinestation.Internals.Users;

import apu.oodj.vaccinestation.Enums.*;
import apu.oodj.vaccinestation.Internals.RandomId;

/**
 * User class, represents a user of the system.
 * This is the base class implementation
 * @author Aiman Maharana
 */
public class User {
    // Internal information
    private String id;
    private String username;
    private String name;
    private String email;
    private String password;
    private UserType type;

    public User(String username, String name, String email, String password) {
        // Randomize ID based on timestamp.
        this.id = RandomId.generate();
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = UserType.User;
    }

    public User(String username, String name, String email, String password, UserType type) {
        this.id = RandomId.generate();
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(String id, String username, String name, String email, String password, UserType type) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Boolean IsUser() {
        return type == UserType.User;
    }

    public Boolean IsManager() {
        return type == UserType.Manager;
    }

    public Boolean IsAdmin() {
        return type == UserType.Administrator;
    }

    /**
     * Export the User data as a string for database.
     * @return The exported data as string.
     */
    public String ExportData() {
        // Export data into the text database.
        String[] content = new String[] {
            this.id,
            this.username,
            this.name,
            this.email,
            this.password,
            this.type.toDataFormat()
        };
        return String.join(";;;", content);
    }

    /**
     * Parse the data from text database into User object.
     * @param data the data to be parsed.
     * @return The parsed User object.
     */
    public static User ParseData(String data) {
        // Parse data from the text database.
        String[] content = data.split(";;;");
        return new User(content[0], content[1], content[2], content[3], content[4], UserType.fromString(content[5]));
    }

    public User Copy() {
        return new User(this.id, this.username, this.name, this.email, this.password, this.type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User other = (User) obj;
            return this.id.equals(other.getId());
        }
        return false;
    }
}
