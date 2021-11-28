package apu.oodj.vaccinestation.Internals.Managerial;

import apu.oodj.vaccinestation.Internals.RandomId;

public class Station {
    private String Id;
    private String managerId;

    private String name;
    private String address;

    public Station(String name, String address) {
        this.Id = RandomId.generate("Station");
        this.managerId = "";
        this.name = name;
        this.address = address;
    }

    public Station(String id, String managerId, String name, String address) {
        this.Id = id;
        this.managerId = managerId;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean hasManager() {
        return !this.managerId.strip().equals("");
    }

    public String ExportData() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Id);
        sb.append(";;;");
        sb.append(this.managerId);
        sb.append(";;;");
        sb.append(this.name);
        sb.append(";;;");
        sb.append(this.address);
        return sb.toString();
    }

    public static Station ParseData(String data) {
        String[] dataArray = data.split(";;;");
        return new Station(dataArray[0], dataArray[1], dataArray[2], dataArray[3]);
    }
}
