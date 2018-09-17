import java.io.*;
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
        System.out.println("AIRLINE RESERVATION SYSTEM\n");
        System.out.println("Add [P]assenger,\t");
        System.out.println("Add [G]roup,\t");
        System.out.println("[C]ancel Reservations,\t");
        System.out.println("Print Seating [A]vailability Chart,\t");
        System.out.println("Print [M]anifest\t");
        System.out.println("[Q]uit\n");
        System.out.println("Please enter your choice below:\n");
        String n = reader.next();
        ActOnUserInput(n,flightName);
        reader.close();
        return n;
    }

    public static void ActOnUserInput(String s, String flightName) {
        Scanner key = new Scanner(System.in);
        String pname;
        String ServiceClass;
        String SeatPreferred;

        if ((s.equals("p")) || (s.equals("P"))) {
            System.out.print("Name: ");
            pname = key.nextLine();
            System.out.print("Service Class: ");
            ServiceClass = key.nextLine();
            System.out.print("Seat Preference: ");
            SeatPreferred = key.nextLine();
            IndividualPassengerRequest individualPassengerRequest = new IndividualPassengerRequest();
            individualPassengerRequest.setIndividualPassengerRequest(pname,ServiceClass,SeatPreferred);
            individualPassengerRequest.processIndividualRequest(flightName);

        }
    }
}



