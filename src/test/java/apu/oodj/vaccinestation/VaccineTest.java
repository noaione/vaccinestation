package apu.oodj.vaccinestation;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.VaccineType;
import apu.oodj.vaccinestation.Internals.Vaccine.Vaccine;

public class VaccineTest {
    @Test
    public void vaccineDataMatch() {
        Vaccine vac = new Vaccine("MockId", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        assertEquals(vac.getId(), "MockId");
        assertEquals(vac.getName(), "Mock");
        assertEquals(vac.getDosage(), 2);
        assertEquals(vac.getManufacturer(), "Mocked");
        assertEquals(vac.getType(), VaccineType.InactivatedVirus);
    }

    @Test
    public void vaccineDosageMulti() {
        Vaccine vac = new Vaccine("MockId", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        assertEquals(vac.getDosage(), 2);
        assertTrue(vac.IsMultiDosage());
        vac.setDosage(1);
        assertEquals(vac.getDosage(), 1);
        assertFalse(vac.IsMultiDosage());
    }

    @Test
    public void vaccineExportTest() {
        Vaccine vac = new Vaccine("MockId", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        assertEquals(vac.ExportData(), "MockId;;;Mock;;;2;;;Mocked;;;InactivatedVirus");
    }

    @Test
    public void vaccineParseTest() {
        String dataTest = "MockId;;;Mock;;;2;;;Mocked;;;InactivatedVirus";
        Vaccine vac = Vaccine.ParseData(dataTest);
        assertEquals(vac.getId(), "MockId");
        assertEquals(vac.getName(), "Mock");
        assertEquals(vac.getDosage(), 2);
        assertEquals(vac.getManufacturer(), "Mocked");
        assertEquals(vac.getType(), VaccineType.InactivatedVirus);
    }
}
