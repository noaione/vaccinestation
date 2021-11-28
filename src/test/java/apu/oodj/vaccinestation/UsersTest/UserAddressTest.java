package apu.oodj.vaccinestation.UsersTest;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Internals.Users.Address;

public class UserAddressTest {
    @Test
    public void testAddressNoCountry() {
        Address address = new Address("Place");
        assertEquals(address.getAddress(), "Place");
        assertEquals(address.getCountry(), "Malaysia");
    }

    @Test
    public void testAddressWithCountry() {
        Address address = new Address("Place", "United States");
        assertEquals(address.getAddress(), "Place");
        assertEquals(address.getCountry(), "United States");
    }

    @Test
    public void testAddressExportData() {
        Address address = new Address("Place", "United States");
        Address address2 = new Address("Place");
        assertEquals(address.ExportData(), "Place;;;United States");
        assertEquals(address2.ExportData(), "Place;;;Malaysia");
    }
}
