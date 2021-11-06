package apu.oodj.vaccinestation.Internals.Users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import apu.oodj.vaccinestation.Enums.CitizenType;
import apu.oodj.vaccinestation.Enums.UserType;

public class Citizen extends User {
    static String ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    CitizenType citizenType;
    String address;
    String phoneNumber;
    Date dob;

    public Citizen(String name, String email, String password, CitizenType citizenType, String address, String phoneNumber, Date dob) {
        super(name, email, password, UserType.User);
        this.citizenType = citizenType;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Citizen(String id, String name, String email, String password, UserType type, CitizenType citizenType, String address, String phoneNumber, Date dob) {
        super(id, name, email, password, type);
        this.citizenType = citizenType;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public CitizenType getCitizenType() {
        return citizenType;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDOB() {
        return dob;
    }

    /**
     * Check if the current citizen is a local citizen.
     * and not a foreigner.
     */
    public Boolean IsCitizen() {
        return CitizenType.Citizen == citizenType;
    }

    public String getDOBAsISO() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(Citizen.ISO8601);
        df.setTimeZone(tz);
        return df.format(this.dob);
    }

    /**
     * Export the citizen data as a string for database.
     * @return The exported data as string.
     */
    public String ExportData() {
        String otherData = super.ExportData();
        String[] extraData = new String[] {
            citizenType.toDataFormat(),
            address,
            phoneNumber,
            this.getDOBAsISO(),
        };
        return otherData + ";;;" + String.join(";;;", extraData);
    }

    /**
     * Parse the data from text database into Citizen object.
     * @param data the data to be parsed.
     * @return The parsed Citizen object.
     */
    public static Citizen ParseData(String data) {
        // Parse back string data into citizen object
        String[] dataArray = data.split(";;;");

        DateFormat isoFmt = new SimpleDateFormat(Citizen.ISO8601);
        Date parsedDob;
        try {
            parsedDob = isoFmt.parse(dataArray[8]);
        } catch (ParseException e) {
            // Unable to parse, for now just leave it be.
            throw new RuntimeException("Unable to parse date of birth: " + dataArray[8]);
        }

        Citizen citizen = new Citizen(
            dataArray[0],
            dataArray[1],
            dataArray[2],
            dataArray[3],
            UserType.fromString(dataArray[4]),
            CitizenType.fromString(dataArray[5]),
            dataArray[6],
            dataArray[7],
            parsedDob
        );
        return citizen;
    }
}
