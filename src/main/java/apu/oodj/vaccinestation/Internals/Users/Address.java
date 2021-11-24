package apu.oodj.vaccinestation.Internals.Users;

public class Address {
    private String address;
    private String country;

    public Address(String address, String country) {
        this.address = address;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String ExportData() {
        String[] extraData = new String[] {
            address,
            country,
        };
        return String.join(";;;", extraData);
    }
}
