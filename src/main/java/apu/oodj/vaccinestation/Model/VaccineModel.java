package apu.oodj.vaccinestation.Model;

import apu.oodj.vaccinestation.Internals.Vaccine.Vaccine;

import java.util.List;

import javax.swing.AbstractListModel;

public class VaccineModel extends AbstractListModel<Vaccine> {
    private final List<Vaccine> vaccineList;

    public VaccineModel(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

    @Override
    public int getSize() {
        return vaccineList.size();
    }

    @Override
    public Vaccine getElementAt(int index) {
        return vaccineList.get(index);
    }
}
