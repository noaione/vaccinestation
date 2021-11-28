package apu.oodj.vaccinestation.UsersTest;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.UserType;
import apu.oodj.vaccinestation.Internals.Users.User;

public class UserTest {
    @Test
    public void testUserDataMatch() {
        User u = new User("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.User);
        assertEquals(u.getId(), "Mock");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.User);
    }

    @Test
    public void testUserDataExport() {
        User u = new User("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.User);
        assertEquals(u.ExportData(), "Mock;;;Mock;;;Mock;;;mock@localhost;;;mocked;;;user");
    }

    @Test
    public void testUserDataParse() {
        String test = "Mock;;;Mock;;;Mock;;;mock@localhost;;;mocked;;;user";
        User u = User.ParseData(test);
        assertEquals(u.getId(), "Mock");
        assertEquals(u.getUsername(), "Mock");
        assertEquals(u.getName(), "Mock");
        assertEquals(u.getEmail(), "mock@localhost");
        assertEquals(u.getPassword(), "mocked");
        assertEquals(u.getType(), UserType.User);
    }

    @Test
    public void testUserTypeCheck() {
        User u = new User("Mock", "Mock", "Mock", "mock@localhost", "mocked", UserType.User);
        assertTrue(u.IsUser());
        assertFalse(u.IsAdmin());
        assertFalse(u.IsManager());
        u.setType(UserType.Administrator);
        assertFalse(u.IsUser());
        assertTrue(u.IsAdmin());
        assertFalse(u.IsManager());
        u.setType(UserType.Manager);
        assertFalse(u.IsUser());
        assertFalse(u.IsAdmin());
        assertTrue(u.IsManager());
    }
}
