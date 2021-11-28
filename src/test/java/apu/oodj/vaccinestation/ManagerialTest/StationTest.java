package apu.oodj.vaccinestation.ManagerialTest;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Internals.Managerial.Station;

public class StationTest {
    @Test
    public void testStationConstructor() {
        Station sample1 = new Station("MockName", "MockAddress");
        assertEquals("MockName", sample1.getName());
        assertEquals("MockAddress", sample1.getAddress());
        assertFalse(sample1.hasManager());

        Station sample2 = new Station("MockId", "MockManager", "MockName", "MockAddress");
        assertEquals("MockId", sample2.getId());
        assertEquals("MockManager", sample2.getManagerId());
        assertEquals("MockName", sample2.getName());
        assertEquals("MockAddress", sample2.getAddress());
        assertTrue(sample2.hasManager());
    }

    @Test
    public void testStationExportData() {
        Station sample = new Station("MockId", "MockManager", "MockName", "MockAddress");
        String expected = "MockId;;;MockManager;;;MockName;;;MockAddress";
        assertEquals(expected, sample.ExportData());

        sample = new Station("MockName", "MockAddress");
        StringBuilder sb = new StringBuilder();
        sb.append(sample.getId());
        sb.append(";;;");
        sb.append(";;;");
        sb.append("MockName");
        sb.append(";;;");
        sb.append("MockAddress");
        expected = sb.toString();
        assertEquals(expected, sample.ExportData());
    }

    @Test
    public void testStationParseData() {
        String data = "MockId;;;MockManager;;;MockName;;;MockAddress";
        Station sample = Station.ParseData(data);

        assertEquals("MockId", sample.getId());
        assertEquals("MockManager", sample.getManagerId());
        assertEquals("MockName", sample.getName());
        assertEquals("MockAddress", sample.getAddress());
    }

    @Test
    public void testStationParseDataNoManager() {
        String data = "MockId;;;;;;MockName;;;MockAddress";
        Station sample = Station.ParseData(data);

        assertEquals("MockId", sample.getId());
        assertFalse(sample.hasManager());
        assertEquals("MockName", sample.getName());
        assertEquals("MockAddress", sample.getAddress());
    }
}
