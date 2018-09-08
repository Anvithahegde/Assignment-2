import java.io.*;
import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        String flightName = args[0];

        try {
            File f = new File(flightName);

            if (f.exists() == false) {
                f.createNewFile();
            }

            DisplayPromptToUser();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DisplayPromptToUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Add [P]assenger,\t");
        System.out.println("Add [G]roup,\t");
        System.out.println("[C]ancel Reservations,\t");
        System.out.println("Print Seating [A]vailability Chart,\t");
        System.out.println("Print [M]anifest\t");
        System.out.println("[Q]uit\n");
        System.out.println("Please enter your input below:\n");
        String n = reader.next();
        ActOnUserInput(n);
        reader.close();
    }

    public static void ActOnUserInput(String s) {
        Scanner key = new Scanner(System.in);
        if (s.equals("p")) {
            System.out.print("Name: ");
            key.nextLine();
            System.out.print("Service Class: ");
            key.nextLine();
            System.out.print("Seat Preference: ");
            key.nextLine();
        }
    }
}

