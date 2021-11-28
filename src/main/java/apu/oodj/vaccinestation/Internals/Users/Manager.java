package apu.oodj.vaccinestation.Internals.Users;

import apu.oodj.vaccinestation.Enums.UserType;

public class Manager extends User {
    private String phoneNumber;

    public Manager(String username, String name, String email, String password, String phoneNumber) {
        super(username, name, email, password, UserType.Manager);
        this.phoneNumber = phoneNumber;
    }

    public Manager(String id, String username, String name, String email, String password, UserType type, String phoneNumber) {
        super(id, username, name, email, password, type);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String ExportData() {
        String topData = super.ExportData();
        return topData + ";;;" + phoneNumber;
    }

    public Manager Copy() {
        return new Manager(this.getId(), this.getUsername(), this.getName(), this.getEmail(), this.getPassword(), this.getType(), phoneNumber);
    }

    /**
     * Parse the data from text database into Manager object.
     * @param data the data to be parsed.
     * @return The parsed User object.
     */
    public static Manager ParseData(String data) {
        // Parse data from the text database.
        String[] content = data.split(";;;");
        return new Manager(content[0], content[1], content[2], content[3], content[4], UserType.fromString(content[5]), content[6]);
    }
}
