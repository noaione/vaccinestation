package apu.oodj.vaccinestation.Enums;

public enum VaccineType {
    mRNA,
    ViralVector,
    InactivatedVirus,
    ;

    public static VaccineType fromString(String str) {
        return VaccineType.valueOf(str);
    }

    public String toFormFormat() {
        if (this.equals(VaccineType.ViralVector)) {
            return "Viral Vector";
        }
        if (this.equals(VaccineType.InactivatedVirus)) {
            return "Inactivated Virus";
        }
        return this.name();
    }
}
