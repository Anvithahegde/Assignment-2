import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        String flightName = args[0];
        String in;
        try {
            File f = new File(flightName);

            if (f.exists() == false) {
                f.createNewFile();
            }

            in = DisplayPromptToUserAndReceiveInput(flightName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String DisplayPromptToUserAndReceiveInput(String flightName) {
        Scanner reader = new Scanner(System.in);
        while(true) {
            System.out.println("\nAdd [P]assenger,Add [G]roup,[C]ancel Reservations,\nPrint Seat [A]vailability Chart," +
                    "Print [M]anifest,[Q]uit\n");

            String n = reader.next();
            ActOnUserInput(n, flightName);
            if(n.equals("Q"))
                break;
        }
        reader.close();
        return "Q";
    }

    public static void ActOnUserInput(String s, String flightName) {


        String pname;
        String ServiceClass;
        String SeatPreferred;
        Scanner key = new Scanner(System.in);

        if ((s.equals("P"))) {
            System.out.print("Name: ");
            pname = key.nextLine();
            System.out.print("Service Class Preference[First/Economy]: ");
            ServiceClass = key.nextLine();
            if((ServiceClass.equals("First")) || (ServiceClass.equals("Economy"))) {
                System.out.print("Seat Preference: ");
                SeatPreferred = key.nextLine();
                if ((SeatPreferred.equals("W")) || (SeatPreferred.equals("C")) || (SeatPreferred.equals("A"))) {
                    IndividualPassengerRequest individualPassengerRequest = new IndividualPassengerRequest();
                    individualPassengerRequest.setIndividualPassengerRequest(pname, SeatPreferred, ServiceClass);
                    individualPassengerRequest.processIndividualRequest(flightName);
                }

            }
        }
        else if((s.equals("Q"))){
            ReservationProgram reservationProgram = new ReservationProgram();
            reservationProgram.WritePassengerDetailsToFile(flightName);
        }
    }
}
