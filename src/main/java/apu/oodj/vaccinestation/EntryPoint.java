package apu.oodj.vaccinestation;

public class EntryPoint 
{
    public static void main( String[] args )
    {
        String username = "", password = "";
        LoginPage pf = new LoginPage(username, password);
        pf.setVisible(true);
        //System.out.println("Initializing System...");
    }
}
