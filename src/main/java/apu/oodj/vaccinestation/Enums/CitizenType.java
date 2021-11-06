package apu.oodj.vaccinestation.Enums;

public enum CitizenType {
    Citizen,
    Foreigner,
    ;

    public String toDataFormat() {
        return this.name().toLowerCase();
    }

    public static CitizenType fromString(String str) {
        String fLet = str.substring(0, 1).toUpperCase();
        String fRem = str.substring(1);
        return CitizenType.valueOf(fLet + fRem);
    }
}
