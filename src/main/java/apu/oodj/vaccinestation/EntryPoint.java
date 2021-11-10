package apu.oodj.vaccinestation;

import java.io.IOException;

import apu.oodj.vaccinestation.Internals.FileHandling;
import apu.oodj.vaccinestation.Internals.Users.User;

public class EntryPoint
{
    public static boolean isFirstTime() {
        Boolean userExist = FileHandling.FileExist("userdata.txt");
        if (!userExist) {
            return true;
        }

        String[] userData;

        try {
            userData = FileHandling.ReadFile("userdata.txt");
        } catch (IOException exc) {
            exc.printStackTrace();
            return true;
        }

        // Coerce into User class
        for (String user : userData) {
            if (User.ParseData(user).IsAdmin()) {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        System.out.println("Starting our system...");
        Boolean isFirstTime = isFirstTime();
        if (isFirstTime) {
            FirstTimeRun ftr = new FirstTimeRun();
            ftr.setVisible(true);
        } else {
            LoginPage pf = new LoginPage("", "");
            pf.setVisible(true);
        }
    }
}
