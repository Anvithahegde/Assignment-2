import java.io.*;

public class ReservationProgram {

    String pname;

    public void CheckSeatAvailabiltyandAssignSeat(String fileName, String pname){
        WritePassengerDetailsToFile(fileName,pname);
    }

    public void WritePassengerDetailsToFile(String fileName,String pname)
    {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(pname);
            out.close();
            }
            catch (IOException e) {
                System.out.println("exception occurred" + e);
            }
        }
}
