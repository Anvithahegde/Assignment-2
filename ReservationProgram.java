import java.io.*;
import java.util.ArrayList;

public class ReservationProgram {

    AirplaneSeatMap seatMap = new AirplaneSeatMap();
    static int seatCount = 0;
    String SeatAssigned;

    public void UpdateSeatMap(String fileName) {

    }

    public void CheckSeatAvailabilityandAssignSeat(String fileName, String pname, String Class, String SeatPreference) {

        boolean seatAssigned = false;
        int index;
        int row;

        UpdateSeatMap(fileName);
        switch (Class) {
            case "First":
                index = 0;
                row = 1;
                if (SeatPreference.equals("W")) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index).equals("")) {
                            seatMap.arrayList.add(index, pname);
                            seatAssigned = true;
                            SeatAssigned = Integer.toString((row)) + "A";
                        } else if (seatMap.arrayList.get(index + 3).equals("")) {
                            seatMap.arrayList.add(+3, pname);
                            seatAssigned = true;
                            SeatAssigned = Integer.toString((row)) + "D";
                        }
                        index = index + 4;
                        row = row + 1;
                    }
                } else if ((SeatPreference.equals("C")) || (SeatPreference.equals("A"))) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index + 1).equals("")) {
                            seatMap.arrayList.add(index + 1, pname);
                            seatAssigned = true;
                            SeatAssigned = Integer.toString((row)) + "B";
                        } else if (seatMap.arrayList.get(index + 2).equals("")) {
                            seatMap.arrayList.add(+2, pname);
                            seatAssigned = true;
                            SeatAssigned = Integer.toString((row)) + "C";
                        }
                        index = index + 4;
                        row = row + 1;
                    }

                }
                System.out.println("\nThe Passenger is assigned the seat: " + SeatAssigned);
                break;

            case "Economy":
                index = 7;
                row = 10;

                if (SeatPreference.equals("W")) {
                    while (seatAssigned != true) {
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
                } else if (SeatPreference.equals("C")) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index + 1).equals("")) {
                            seatMap.arrayList.add(index + 1, pname);
                            SeatAssigned = Integer.toString((row)) + "B";
                            seatAssigned = true;
                        } else if (seatMap.arrayList.get(index + 4).equals("")) {
                            seatMap.arrayList.add(index + 4, pname);
                            SeatAssigned = Integer.toString((row)) + "E";
                            seatAssigned = true;
                        }
                        index = index + 6;
                        row = row + 1;
                    }
                } else if (SeatPreference.equals("A")) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index + 2).equals("")) {
                            seatMap.arrayList.add(index + 2, pname);
                            SeatAssigned = Integer.toString((row)) + "C";
                            seatAssigned = true;
                        } else if (seatMap.arrayList.get(index + 3).equals("")) {
                            seatMap.arrayList.add(index + 3, pname);
                            SeatAssigned = Integer.toString((row)) + "D";
                            seatAssigned = true;
                        }
                        index = index + 6;
                        row = row + 1;
                    }
                }
                System.out.println("\nThe Passenger is assigned the seat: " + SeatAssigned);
                break;
        }
    }

    public void WritePassengerDetailsToFile(String fileName) {
        int seatAssignedindex;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            try {
                for (String object : seatMap.arrayList) {
                    if ((object.equals(""))) {
                        ;
                    } else {
                        seatAssignedindex = seatMap.arrayList.indexOf(object);
                        out.write(Integer.toString((seatAssignedindex)));
                        out.write(",");
                        out.write(object);
                        out.newLine();
                    }
                }
            } catch (IOException e) {
                System.out.println("exception occurred" + e);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }

    public void CancelReservation(String pname) {

        int arrayListIndex;

        arrayListIndex = seatMap.arrayList.indexOf(pname);
        seatMap.arrayList.remove(arrayListIndex);
    }
}
