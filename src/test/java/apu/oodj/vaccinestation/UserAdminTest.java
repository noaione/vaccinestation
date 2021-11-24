package apu.oodj.vaccinestation;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.UserType;
import apu.oodj.vaccinestation.Internals.Users.Administrator;

public class UserAdminTest {
    @Test
    public void testUserDataMatch() {
        Administrator u = new Administrator("Mock", "Mock", "mock@localhost", "mocked");
        assertEquals(u.getId().split("-")[0], "Id");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.Administrator);
    }

    @Test
    public void testUserDataExport() {
        Administrator u = new Administrator("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.Administrator);
        assertEquals(u.ExportData(), "Mock;;;Mock;;;Mock;;;mock@localhost;;;mocked;;;administrator");
    }

    @Test
    public void testUserDataParse() {
        String test = "Mock;;;Mock;;;Mock;;;mock@localhost;;;mocked;;;administrator";
        Administrator u = Administrator.ParseData(test);
        assertEquals(u.getId(), "Mock");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.Administrator);
    }

    @Test
    public void testUserTypeCheck() {
        Administrator u = new Administrator("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.Administrator);
        assertFalse(u.IsUser());
        assertTrue(u.IsAdmin());
        assertFalse(u.IsManager());
    }
}
