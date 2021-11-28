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

    private String identificationNumber;
    private CitizenType citizenType;
    private Address address;
    private String phoneNumber;
    private Date dob;

    public Citizen(String username, String name, String email, String password, String idNumber, CitizenType citizenType, Address address, String phoneNumber, Date dob) {
        super(username, name, email, password, UserType.User);
        this.identificationNumber = idNumber;
        this.citizenType = citizenType;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Citizen(String username, String name, String email, String password, String idNumber, CitizenType citizenType, String address, String phoneNumber, Date dob) {
        super(username, name, email, password, UserType.User);
        this.identificationNumber = idNumber;
        this.citizenType = citizenType;
        if (citizenType == CitizenType.Citizen) {
            this.address = new Address(address, "Malaysia");
        } else {
            this.address = new Address(address, "");
        }
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Citizen(String id, String username, String name, String email, String password, UserType type, String idNumber, CitizenType citizenType, Address address, String phoneNumber, Date dob) {
        super(id, username, name, email, password, type);
        this.identificationNumber = idNumber;
        this.citizenType = citizenType;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public CitizenType getCitizenType() {
        return citizenType;
    }

    public Address getAddress() {
        return address;
    }

    public String getHomeAddress() {
        return address.getAddress();
    }

    public String getCountry() {
        return address.getCountry();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDOB() {
        return dob;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setCitizenType(CitizenType citizenType) {
        this.citizenType = citizenType;
    }

    public void setAddress(String homeAddress) {
        this.address.setAddress(homeAddress);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDOB(Date dob) {
        this.dob = dob;
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
            identificationNumber,
            citizenType.toDataFormat(),
        };
        String addressData = address.ExportData();
        String[] extraData2 = new String[] {
            phoneNumber,
            this.getDOBAsISO(),
        };
        return (
            otherData + ";;;" +
            String.join(";;;", extraData) + ";;;" +
            addressData + ";;;" +
            String.join(";;;", extraData2)
        ); 
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
            parsedDob = isoFmt.parse(dataArray[11]);
        } catch (ParseException e) {
            // Unable to parse, for now just leave it be.
            throw new RuntimeException("Unable to parse date of birth: " + dataArray[8]);
        }

        Address address = new Address(dataArray[8], dataArray[9]);

        Citizen citizen = new Citizen(
            dataArray[0],
            dataArray[1],
            dataArray[2],
            dataArray[3],
            dataArray[4],
            UserType.fromString(dataArray[5]),
            dataArray[6],
            CitizenType.fromString(dataArray[7]),
            address,
            dataArray[10],
            parsedDob
        );
        return citizen;
    }

    public Citizen Copy() {
        return new Citizen(
            this.getId(),
            this.getUsername(),
            this.getName(),
            this.getEmail(),
            this.getPassword(),
            this.getType(),
            this.getIdentificationNumber(),
            this.getCitizenType(),
            this.getAddress().Copy(),
            this.getPhoneNumber(),
            this.getDOB()
        );
    }
}
