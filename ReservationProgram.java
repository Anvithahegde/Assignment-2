import java.io.*;
import java.util.ArrayList;

public class ReservationProgram {

    AirplaneSeatMap seatMap = new AirplaneSeatMap();
    static int seatCount = 0;

    String SeatAssigned;
    public void CheckSeatAvailabilityandAssignSeat(String fileName, String pname, String Class){

        boolean seatAssigned = false;
        int index;
        int row;

        switch(Class){
            case "First":
                index = 0;
                row = 1;
                while(seatAssigned != true) {
                    if (seatMap.arrayList.get(index).equals("")) {
                        seatMap.arrayList.add(index, pname);
                        seatAssigned = true;
                        SeatAssigned = Integer.toString((row)) + "A";
                    } else if (seatMap.arrayList.get(index + 3).equals("")) {
                        seatMap.arrayList.add( + 3, pname);
                        seatAssigned = true;
                        SeatAssigned = Integer.toString((row)) + "F";
                    }
                    index = index + 4;
                    row = row + 1;
                }
                System.out.println("\nThe Passenger is assigned the seat: " + SeatAssigned);
                break;

            case "Economy":
                index = 7;
                row = 10;
                while(seatAssigned != true) {
                    if (seatMap.arrayList.get(index).equals("")) {
                        seatMap.arrayList.add(index, pname);
                        SeatAssigned = Integer.toString((row)) + "A";
                        seatAssigned = true;
                    } else if (seatMap.arrayList.get(index + 5).equals("")) {
                        seatMap.arrayList.add(index + 5, pname);
                        SeatAssigned = Integer.toString((row)) + "F";
                        seatAssigned = true;
                    }
                    index = index + 6;
                    row = row + 1;
                }
                System.out.println("\nThe Passenger is assigned the seat: " + SeatAssigned);
                break;
        }
        
        
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
