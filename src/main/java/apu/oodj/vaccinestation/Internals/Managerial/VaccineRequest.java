package apu.oodj.vaccinestation.Internals.Managerial;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import apu.oodj.vaccinestation.Internals.RandomId;
import apu.oodj.vaccinestation.Internals.Vaccine.Vaccine;

public class VaccineRequest {
    static String ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private String Id;
    private String userId;
    private Vaccine vaccine;
    private int dose;
    private Date submitDate;
    private Date vaccineDate;
    // 0 is not processed, 1 is approved, -1 is rejected
    private int status;
    private Station station;
    private Boolean isVaccinated;

    public VaccineRequest(String uuid, Vaccine vac, int dose, Date submitDate, Date vaccineDate, Station station) {
        this.Id = RandomId.generate("VacReq");
        this.userId = uuid;
        this.vaccine = vac;
        this.dose = dose;
        this.submitDate = submitDate;
        this.vaccineDate = vaccineDate;
        this.status = 0;
        this.station = station;
        this.isVaccinated = false;
    }

    public VaccineRequest(String uuid, Vaccine vac, int dose, Date submitDate, Date vaccineDate, int status, Station station) {
        this.Id = RandomId.generate("VacReq");
        this.userId = uuid;
        this.vaccine = vac;
        this.dose = dose;
        this.submitDate = submitDate;
        this.vaccineDate = vaccineDate;
        this.status = status;
        this.station = station;
        this.isVaccinated = false;
    }

    public VaccineRequest(String Id, String uuid, Vaccine vac, int dose, Date submitDate, Date vaccineDate, int status, Station station, int isVaccinated) {
        this.Id = Id;
        this.userId = uuid;
        this.vaccine = vac;
        this.dose = dose;
        this.submitDate = submitDate;
        this.vaccineDate = vaccineDate;
        this.status = status;
        this.station = station;
        this.isVaccinated = isVaccinated == 1;
    }

    public String getId() {
        return Id;
    }

    public String getUserId() {
        return userId;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public int getDose() {
        return dose;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public Date getVaccineDate() {
        return vaccineDate;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status == 1 || status == -1 || status == 0) {
            this.status = status;
        }
    }

    public Boolean isProcessing() {
        return status == 0;
    }

    public Boolean isApproved() {
        return status == 1;
    }

    public Boolean isRejected() {
        return status == -1;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean isVaccinated) {
        // Check if approved, if isn't just ignore it silently
        if (this.isApproved()) {
            this.isVaccinated = isVaccinated;
        }
    }

    public String getSubmitDateAsISO() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(VaccineRequest.ISO8601);
        df.setTimeZone(tz);
        return df.format(this.submitDate);
    }

    public String getVaccineDateAsISO() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(VaccineRequest.ISO8601);
        df.setTimeZone(tz);
        return df.format(this.vaccineDate);
    }

    public String ExportData() {
        String vacDate = this.getVaccineDateAsISO();
        String subDate = this.getSubmitDateAsISO();
        String vacInfo = this.vaccine.ExportData();

        int isVacNum = 0;
        if (this.isVaccinated) {
            isVacNum = 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(this.Id);
        sb.append("<<<<");
        sb.append(this.userId);
        sb.append("<<<<");
        sb.append(vacInfo);
        sb.append("<<<<");
        sb.append(this.dose);
        sb.append("<<<<");
        sb.append(subDate);
        sb.append("<<<<");
        sb.append(vacDate);
        sb.append("<<<<");
        sb.append(this.status);
        sb.append("<<<<");
        sb.append(this.station.ExportData());
        sb.append("<<<<");
        sb.append(isVacNum);

        return sb.toString();
    }

    public static VaccineRequest ParseData(String data) {
        String[] dataArray = data.split("<<<<");
        DateFormat isoFmt = new SimpleDateFormat(VaccineRequest.ISO8601);
        Date parsedSubDate;
        Date parsedVacDate;
        try {
            parsedSubDate = isoFmt.parse(dataArray[4]);
            parsedVacDate = isoFmt.parse(dataArray[5]);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse one of the date!");
        }

        Vaccine vaccine = Vaccine.ParseData(dataArray[2]);
        return new VaccineRequest(
            dataArray[0],
            dataArray[1],
            vaccine,
            Integer.parseInt(dataArray[3]),
            parsedSubDate,
            parsedVacDate,
            Integer.parseInt(dataArray[6]),
            Station.ParseData(dataArray[7]),
            Integer.parseInt(dataArray[8])
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof VaccineRequest) {
            VaccineRequest vr = (VaccineRequest) o;
            return this.Id.equals(vr.getId());
        }
        return false;
    }
}
