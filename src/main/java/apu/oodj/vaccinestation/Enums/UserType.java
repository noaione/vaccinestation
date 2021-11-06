package apu.oodj.vaccinestation.Enums;

public enum UserType {
    User,
    Manager,
    Administrator,
    ;

    public String toDataFormat() {
        return this.name().toLowerCase();
    }

    public static UserType fromString(String str) {
        String fLet = str.substring(0, 1).toUpperCase();
        String fRem = str.substring(1);
        return UserType.valueOf(fLet + fRem);
    }
}
