package apu.oodj.vaccinestation.Enums;

public enum VaccineType {
    mRNA,
    ViralVector,
    InactivatedVirus,
    ;

    public static VaccineType fromString(String str) {
        return VaccineType.valueOf(str);
    }
}
