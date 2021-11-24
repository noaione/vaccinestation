package apu.oodj.vaccinestation;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Internals.RandomId;

public class RandomIdTest {
    @Test
    public void testRandomId() {
        String test = RandomId.generate();
        assertEquals(test.split("-")[0], "Id");
    }

    @Test
    public void testRandomIdPrefixed() {
        String test = RandomId.generate("Prefix");
        assertEquals(test.split("-")[0], "Prefix");
    }
}
