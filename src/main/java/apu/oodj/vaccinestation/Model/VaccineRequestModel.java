package apu.oodj.vaccinestation.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import apu.oodj.vaccinestation.Internals.FileHandling;
import apu.oodj.vaccinestation.Internals.Managerial.VaccineRequest;
import apu.oodj.vaccinestation.Internals.Users.User;

public class VaccineRequestModel extends AbstractTableModel {
    private List<VaccineRequest> requests;
    private List<User> users;
    private boolean appointmentMode;

    private final String[] columnNames = new String[] {
        "?", "User Id", "Full Name", "Vaccine Name", "Dose (1/2)", "Submitted Date", "Vaccination Date",
    };

    private final Class<?>[] columnClass = new Class[] {
        String.class, String.class, String.class, String.class, Integer.class, Date.class, Date.class,
    };

    public VaccineRequestModel(List<VaccineRequest> requests, boolean isAppointmentMode) {
        this.requests = requests;
        this.appointmentMode = isAppointmentMode;

        String[] rawUserStrings;
        try {
            rawUserStrings = FileHandling.ReadFile("userdata");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        users = new ArrayList<>();

        for (String rawUserString : rawUserStrings) {
            User user = User.ParseData(rawUserString);
            users.add(user);
        }
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return requests.size();
    }

    public User findUserFromId(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public VaccineRequest getRequest(int row) {
        return requests.get(row);
    }

    private String statusToString(int status) {
        switch (status) {
            case 1:
                return "Approved";
            case -1:
                return "Denied";
            default:
                return "Pending";
        }
    }

    private String vacStatusToString(Boolean status) {
        if (status) {
            return "Done";
        }
        return "Not Done";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        VaccineRequest row = requests.get(rowIndex);
        User user = findUserFromId(row.getUserId());
        if (columnIndex == 0) {
            if (appointmentMode) {
                return statusToString(row.getStatus());
            } else {
                return vacStatusToString(row.isVaccinated());
            }
        } else if (columnIndex == 1) {
            return row.getUserId();
        } else if (columnIndex == 2) {
            if (user == null) {
                return "UNKNOWN NAME";
            }
            return user.getName();
        } else if (columnIndex == 3) {
            return row.getVaccine().getName();
        } else if (columnIndex == 4) {
            return row.getDose();
        } else if (columnIndex == 5) {
            return row.getSubmitDate();
        } else if (columnIndex == 6) {
            return row.getVaccineDate();
        }
        return null;
    }
}
