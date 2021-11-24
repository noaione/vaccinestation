package apu.oodj.vaccinestation.Internals.Vaccine;

import apu.oodj.vaccinestation.Enums.VaccineType;
import apu.oodj.vaccinestation.Internals.RandomId;

public class Vaccine {
    private String Id;
    private String name;
    // 1 or 2
    private int dosage;
    private String manufacturer;
    private VaccineType type;

    public Vaccine(String name, int dosage, String manufacturer, VaccineType type) {
        this.Id = RandomId.generate("VacId");
        this.name = name;
        this.dosage = dosage;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public Vaccine(String id, String name, int dosage, String manufacturer, VaccineType type) {
        Id = id;
        this.name = name;
        this.dosage = dosage;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public VaccineType getType() {
        return type;
    }

    public void setType(VaccineType type) {
        this.type = type;
    }

    public boolean IsMultiDosage() {
        return dosage > 1;
    }

    public String toString() {
        return "Vaccine{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", dosage=" + dosage +
                ", manufacturer='" + manufacturer + '\'' +
                ", type=" + type +
                '}';
    }

    public String ExportData() {
        String[] data = new String[] {
            Id,
            name,
            Integer.toString(dosage),
            manufacturer,
            type.toString()
        };
        return String.join(";;;", data);
    }

    public static Vaccine ParseData(String data) {
        String[] dataArray = data.split(";;;");
        return new Vaccine(
            dataArray[0],
            dataArray[1],
            Integer.parseInt(dataArray[2]),
            dataArray[3],
            VaccineType.fromString(dataArray[4])
        );
    }
}
