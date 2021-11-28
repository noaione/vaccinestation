package apu.oodj.vaccinestation.VaccineTest;

import static org.junit.Assert.*;

import org.junit.Test;

import apu.oodj.vaccinestation.Enums.VaccineType;
import apu.oodj.vaccinestation.Internals.Vaccine.StoredVaccine;
import apu.oodj.vaccinestation.Internals.Vaccine.Vaccine;

public class StoredVaccineTest {
    @Test
    public void storedVaccineDataMatch() {
        Vaccine vac = new Vaccine("VacMockId", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        StoredVaccine storage = new StoredVaccine("StoreMockId", "MockId");
        assertEquals(storage.getStoreId(), "StoreMockId");
        assertEquals(storage.getAssociatedManagerId(), "MockId");
        assertEquals(storage.Count(), 0);
        storage.addVaccines(vac, 2);
        assertEquals(storage.Count(), 2);
    }

    @Test
    public void storedVaccineDataCountTest() {
        Vaccine vac = new Vaccine("VacMockId", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        Vaccine vac2 = new Vaccine("VacMockId2", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        StoredVaccine storage = new StoredVaccine("StoreMockId", "MockId");

        assertEquals(storage.Count(), 0);
        storage.addVaccines(vac, 15);
        storage.addVaccine(vac2);
        assertEquals(storage.Count(), 16);
        storage.removeVaccines(2);
        assertEquals(storage.Count(), 14);
        storage.removeVaccine("VacMockId2");
        assertEquals(storage.Count(), 13);
    }

    @Test
    public void storedVaccineExportTest() {
        StoredVaccine storage = new StoredVaccine("StoreMockId", "MockId");
        assertEquals(storage.ExportData(), "StoreMockId>>>>MockId>>>>");
        Vaccine vac = new Vaccine("VacMockId", "Mock", 2, "Mocked", VaccineType.InactivatedVirus);
        storage.addVaccines(vac, 2);
        StringBuilder sb = new StringBuilder();
        sb.append("StoreMockId>>>>MockId>>>>");
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                sb.append(vac.ExportData());
            } else {
                sb.append(vac.ExportData() + ">>>>");
            }
        }
        assertEquals(storage.ExportData(), sb.toString());
    }

    @Test
    public void storedVaccineParseTest() {
        String test1 = "StoreMockId>>>>MockId>>>>";
        String test2 = "StoreMockId2>>>>MockId2>>>>VacMockId;;;Mock;;;2;;;Mocked;;;InactivatedVirus>>>>VacMockId;;;Mock;;;2;;;Mocked;;;InactivatedVirus";

        StoredVaccine storage = StoredVaccine.ParseData(test1);

        assertEquals(storage.getStoreId(), "StoreMockId");
        assertEquals(storage.getAssociatedManagerId(), "MockId");
        assertEquals(storage.Count(), 0);

        storage = StoredVaccine.ParseData(test2);

        assertEquals(storage.getStoreId(), "StoreMockId2");
        assertEquals(storage.getAssociatedManagerId(), "MockId2");
        assertEquals(storage.Count(), 2);
    }
}
