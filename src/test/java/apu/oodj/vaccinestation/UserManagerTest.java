package apu.oodj.vaccinestation;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.UserType;
import apu.oodj.vaccinestation.Internals.Users.Manager;

public class UserManagerTest {
    @Test
    public void testUserDataMatch() {
        Manager u = new Manager("Mock", "Mock", "mock@localhost", "mocked");
        assertEquals(u.getId().split("-")[0], "Id");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.Manager);
    }

    @Test
    public void testUserDataExport() {
        Manager u = new Manager("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.Manager);
        assertEquals(u.ExportData(), "Mock;;;Mock;;;Mock;;;mock@localhost;;;mocked;;;manager");
    }

    @Test
    public void testUserDataParse() {
        String test = "Mock;;;Mock;;;Mock;;;mock@localhost;;;mocked;;;manager";
        Manager u = Manager.ParseData(test);
        assertEquals(u.getId(), "Mock");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.Manager);
    }

    @Test
    public void testUserTypeCheck() {
        Manager u = new Manager("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.Manager);
        assertFalse(u.IsUser());
        assertFalse(u.IsAdmin());
        assertTrue(u.IsManager());
    }
}
