package apu.oodj.vaccinestation.UsersTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.CitizenType;
import apu.oodj.vaccinestation.Enums.UserType;
import apu.oodj.vaccinestation.Internals.Users.Address;
import apu.oodj.vaccinestation.Internals.Users.Citizen;

public class UserCitizenTest {
    @Test
    public void testUserDataMatch() {
        Date nd = new Date();
        Address a = new Address("Place");
        Address a2 = new Address("Place", "United States");
        Citizen u = new Citizen("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.User, "123", CitizenType.Citizen, a, "123123", nd);
        Citizen u2 = new Citizen("Mock2", "Mock 2", "mock2@localhost", "mocked", "123123", CitizenType.Foreigner, a2, "123123", nd);
        assertEquals(u2.getId().split("-")[0], "Id");
        assertEquals(u.getId(), "Mock");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.User);
        assertEquals(u2.getType(), UserType.User);
        assertEquals(u.getCitizenType(), CitizenType.Citizen);
        assertEquals(u2.getCitizenType(), CitizenType.Foreigner);
        assertEquals(u.getAddress(), a);
        assertEquals(u.getHomeAddress(), a.getAddress());
        assertEquals(u.getCountry(), a.getCountry());
        assertEquals(u.getIdentificationNumber(), "123");
        assertEquals(u2.getAddress(), a2);
        assertEquals(u2.getHomeAddress(), a2.getAddress());
        assertEquals(u2.getCountry(), a2.getCountry());
        assertEquals(u.getPhoneNumber(), "123123");
        assertEquals(u.getDOB(), nd);
    }

    @Test
    public void testUserTypeCheck() {
        Date nd = new Date();
        Address a = new Address("Place", "United States");
        Citizen u = new Citizen("Mock2", "Mock 2", "mock2@localhost", "mocked", "123123", CitizenType.Foreigner, a, "123123", nd);

        assertTrue(u.IsUser());
        assertFalse(u.IsAdmin());
        assertFalse(u.IsManager());
        assertFalse(u.IsCitizen());
        u.setCitizenType(CitizenType.Citizen);
        assertTrue(u.IsCitizen());
    }

    @Test
    public void testUserDataExport() {
        Date nd = new Date();
        Address a = new Address("Place", "United States");
        Citizen u = new Citizen("Mock2", "Mock 2", "mock2@localhost", "mocked", "123123", CitizenType.Foreigner, a, "123123", nd);

        StringBuilder sb = new StringBuilder();
        sb.append(u.getId() + ";;;");
        sb.append(u.getUsername() + ";;;");
        sb.append(u.getName() + ";;;");
        sb.append(u.getEmail() + ";;;");
        sb.append(u.getPassword() + ";;;");
        sb.append(u.getType().toDataFormat() + ";;;");
        sb.append(u.getIdentificationNumber() + ";;;");
        sb.append(u.getCitizenType().toDataFormat() + ";;;");
        sb.append(u.getHomeAddress() + ";;;");
        sb.append(u.getCountry() + ";;;");
        sb.append(u.getPhoneNumber() + ";;;");
        sb.append(u.getDOBAsISO());

        assertEquals(u.ExportData(), sb.toString());
    }

    @Test
    public void testUserDataParse() {
        String test = "Id-1637732348;;;Mock2;;;Mock 2;;;mock2@localhost;;;mocked;;;user;;;123123;;;foreigner;;;Place;;;United States;;;123123;;;2021-11-24T05:39:08.019Z";

        Citizen u = Citizen.ParseData(test);
        assertEquals(u.getId(), "Id-1637732348");
        assertEquals(u.getUsername(), "Mock2");
        assertEquals(u.getName(), "Mock 2");
        assertEquals(u.getEmail(), "mock2@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.User);
        assertEquals(u.getCitizenType(), CitizenType.Foreigner);
        assertEquals(u.getHomeAddress(), "Place");
        assertEquals(u.getCountry(), "United States");
        assertEquals(u.getIdentificationNumber(), "123123");
        assertEquals(u.getPhoneNumber(), "123123");
    }
}
