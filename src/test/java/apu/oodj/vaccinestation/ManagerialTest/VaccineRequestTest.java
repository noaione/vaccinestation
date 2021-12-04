package apu.oodj.vaccinestation.ManagerialTest;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

import apu.oodj.vaccinestation.Enums.VaccineType;
import apu.oodj.vaccinestation.Internals.Managerial.*;
import apu.oodj.vaccinestation.Internals.Vaccine.Vaccine;

public class VaccineRequestTest {
    @Test
    public void testVaccineRequestConstructor() {
        Date date = new Date();
        Vaccine vc = new Vaccine("MockVacName", 2, "MockVacManu", VaccineType.mRNA);
        Station st = new Station("MockStationName", "MockStationAddress");

        VaccineRequest vr = new VaccineRequest("MockUserId", vc, 1, date, date, st);
        assertEquals("MockUserId", vr.getUserId());
        assertEquals(vc, vr.getVaccine());
        assertEquals(1, vr.getDose());
        assertEquals(date, vr.getSubmitDate());
        assertEquals(date, vr.getVaccineDate());
        assertEquals(st, vr.getStation());
        assertTrue(vr.isProcessing());
        assertFalse(vr.isApproved());
        assertFalse(vr.isVaccinated());

        VaccineRequest vr2 = new VaccineRequest("MockUserId", vc, 1, date, date, 1, st);
        assertTrue(vr2.isApproved());
        assertFalse(vr2.isProcessing());

        VaccineRequest vr3 = new VaccineRequest("MockId", "MockUserId", vc, 1, date, date, 1, st, 1);
        assertEquals("MockId", vr3.getId());
        assertTrue(vr3.isVaccinated());
    }

    @Test
    public void testVaccineRequestExportData() {
        Date date = new Date();
        Vaccine vc = new Vaccine("MockVacName", 2, "MockVacManu", VaccineType.mRNA);
        Station st = new Station("MockStationName", "MockStationAddress");

        VaccineRequest vr = new VaccineRequest("MockId", "MockUserId", vc, 1, date, date, 1, st, 1);

        String expected = "MockId<<<<MockUserId<<<<";
        expected += vc.ExportData();
        expected += "<<<<1<<<<";
        expected += vr.getVaccineDateAsISO() + "<<<<";
        expected += vr.getSubmitDateAsISO() + "<<<<";
        expected += "1<<<<";
        expected += st.ExportData();
        expected += "<<<<1";

        assertEquals(expected, vr.ExportData());
    }

    @Test
    public void testVaccineRequestParseData() {
        String imported = "MockId<<<<MockUserId<<<<VacId-1638634510;;;MockVacName;;;2;;;MockVacManu;;;mRNA<<<<1<<<<2021-12-04T16:15:10.933Z<<<<2021-12-04T16:15:10.933Z<<<<1<<<<Station-1638634510;;;;;;MockStationName;;;MockStationAddress<<<<1";
        VaccineRequest vr = VaccineRequest.ParseData(imported);

        assertEquals("MockId", vr.getId());
        assertEquals("MockUserId", vr.getUserId());
        assertEquals("VacId-1638634510", vr.getVaccine().getId());
        assertEquals(1, vr.getDose());
        assertEquals("Station-1638634510", vr.getStation().getId());
        assertTrue(vr.isApproved());
        assertFalse(vr.isProcessing());
        assertTrue(vr.isVaccinated());   
    }
}
