package apu.oodj.vaccinestation.Internals.Vaccine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import apu.oodj.vaccinestation.Enums.VaccineType;
import apu.oodj.vaccinestation.Internals.FileHandling;
import apu.oodj.vaccinestation.Internals.RandomId;

public class StoredVaccine {
    private String storeId;
    private String associatedStationId;
    private ArrayList<Vaccine> vaccines;

    public StoredVaccine(String managerId) {
        this.storeId = RandomId.generate("VaccStoreId");
        this.associatedStationId = managerId;
        this.vaccines = new ArrayList<Vaccine>();
    }

    public StoredVaccine(String storeId, String associatedStationId) {
        this.storeId = storeId;
        this.associatedStationId = associatedStationId;
        this.vaccines = new ArrayList<>();
    }

    public StoredVaccine(String storeId, String associatedStationId, ArrayList<Vaccine> vaccines) {
        this.storeId = storeId;
        this.associatedStationId = associatedStationId;
        this.vaccines = vaccines;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getAssociatedStationId() {
        return associatedStationId;
    }

    public ArrayList<Vaccine> getVaccines() {
        return vaccines;
    }

    public void addVaccine(Vaccine vaccine) {
        vaccines.add(vaccine);
    }

    public void addVaccines(Vaccine vaccine, long quantity) {
        for (long i = 0; i < quantity; i++) {
            vaccines.add(vaccine);
        }
    }

    public void removeVaccine(String vaccineId) {
        int index = -1;
        for (int i = 0; i < vaccines.size(); i++) {
            if (vaccines.get(i).getId().equals(vaccineId)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            vaccines.remove(index);
        }
    }

    public void removeVaccine(int index) {
        try {
            vaccines.remove(index);
        } catch (IndexOutOfBoundsException e) {
            // graceful catch, ignore
        }
    }

    public void removeVaccines(int count) {
        for (int i = 0; i < count; i++) {
            vaccines.remove(0);
        }
    }

    public void removeVaccines(int count, Boolean reverse) {
        if (reverse) {
            for (int i = 0; i < count; i++) {
                vaccines.remove(vaccines.size() - 1);
            }
        } else {
            for (int i = 0; i < count; i++) {
                vaccines.remove(0);
            }
        }
    }

    public void removeVaccinesById(String vaccineId) {
        ArrayList<Vaccine> temp = new ArrayList<>();
        for (Vaccine vaccine : vaccines) {
            if (!vaccine.getId().equals(vaccineId)) {
                temp.add(vaccine);
            }
        }
        vaccines = temp;
    }

    public void removeVaccinesById(String vaccineId, long count) {
        ArrayList<Vaccine> temp = new ArrayList<>();
        long deletedCount = 0;
        for (Vaccine vaccine : vaccines) {
            if (deletedCount < count && vaccine.getId().equals(vaccineId)) {
                deletedCount++;
                continue;
            }
            temp.add(vaccine);
        }
        vaccines = temp;
    }

    public void removeVaccine(Vaccine vaccine) {
        vaccines.remove(vaccine);
    }

    public Vaccine gainVaccine(String vaccineId) {
        int index = -1;
        for (int i = 0; i < vaccines.size(); i++) {
            if (vaccines.get(i).getId().equals(vaccineId)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            Vaccine vac = vaccines.get(index);
            vaccines.remove(index);
            return vac;
        }
        return null;
    }

    public long Count() {
        return vaccines.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreId: " + storeId + "\n");
        sb.append("AssociatedManagerId: " + associatedStationId + "\n");
        sb.append("Vaccines: " + vaccines.toString() + "\n");
        return sb.toString();
    }

    public String ExportData() {
        String[] bases = new String[] {
            storeId,
            associatedStationId,
        };
        String[] vaccineStrings = new String[vaccines.size()];
        for (int i = 0; i < vaccines.size(); i++) {
            vaccineStrings[i] = vaccines.get(i).ExportData();
        }
        return String.join(">>>>", bases) + ">>>>" + String.join(">>>>", vaccineStrings);
    }

    public static StoredVaccine ParseData(String data) {
        String[] bases = data.split(">>>>");
        ArrayList<String> vaccineStrings = new ArrayList<String>(
            Arrays.asList(bases)
        );

        StoredVaccine storage = new StoredVaccine(
            vaccineStrings.get(0),
            vaccineStrings.get(1)
        );

        for (int i = 2; i < vaccineStrings.size(); i++) {
            Vaccine vaccine = Vaccine.ParseData(vaccineStrings.get(i));
            storage.addVaccine(vaccine);
        }

        return storage;
    }

    public static void main(String[] args) {
        StoredVaccine storedVaccine = new StoredVaccine("MockId-123123123312");
        storedVaccine.addVaccines(new Vaccine("Sinovac", 2, "Sinovac Parent", VaccineType.InactivatedVirus), 100);
        try {
            FileHandling.WriteString("storedvaccines", storedVaccine.ExportData(), false);
            System.out.println("Saved temporary data");
        } catch (IOException exc) {
            exc.printStackTrace();
            return;
        }

        System.out.println("Reading back files...");
        String[] data;
        try {
            data = FileHandling.ReadFile("storedvaccines");
        } catch (IOException exc) {
            exc.printStackTrace();
            return;
        }

        StoredVaccine storedVaccine2 = StoredVaccine.ParseData(data[0]);
        System.out.println(storedVaccine2.toString());
    }
}
