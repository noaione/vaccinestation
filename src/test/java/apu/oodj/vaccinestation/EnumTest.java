package apu.oodj.vaccinestation;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.*;

public class EnumTest {
    @Test
    public void testCitizenType() {
        CitizenType tipe = CitizenType.Foreigner;
        assertEquals(tipe, CitizenType.Foreigner);
        assertEquals(tipe.toDataFormat(), "foreigner");
        assertEquals(tipe.toString(), "Foreigner");
        CitizenType parsed = CitizenType.fromString("Citizen");
        assertEquals(parsed, CitizenType.Citizen);
    }

    @Test
    public void testUserType() {
        UserType tipe = UserType.User;
        assertEquals(tipe, UserType.User);
        assertEquals(tipe.toDataFormat(), "user");
        assertEquals(tipe.toString(), "User");
        UserType parsed = UserType.fromString("Manager");
        assertEquals(parsed, UserType.Manager);
    }


    @Test
    public void testVaccineType() {
        VaccineType tipe = VaccineType.mRNA;
        assertEquals(tipe, VaccineType.mRNA);
        assertEquals(tipe.toString(), "mRNA");
        VaccineType parsed = VaccineType.fromString("ViralVector");
        assertEquals(parsed, VaccineType.ViralVector);
    }
}
