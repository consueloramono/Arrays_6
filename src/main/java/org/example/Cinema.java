package org.example;

public class Cinema {

    private int[][][] seats;

    public Cinema(int numHalls, int numRows, int numSeatsPerRow) {
        seats = new int[numHalls + 1][numRows][numSeatsPerRow];
    }

    public void bookSeats(int hallNumber, int row, int[] seatsToBook) {
        for (int seat : seatsToBook) {
            if (seats[hallNumber][row - 1][seat - 1] == 0) {
                seats[hallNumber][row - 1][seat - 1] = 1;
                System.out.println("Seat booked: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            } else {
                System.out.println("Seat already booked: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        for (int seat : seatsToCancel) {
            if (seats[hallNumber][row - 1][seat - 1] == 1) {
                seats[hallNumber][row - 1][seat - 1] = 0;
                System.out.println("Booking canceled: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            } else {
                System.out.println("No booking found: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < seats[hallNumber].length; row++) {
            for (int startSeat = 0; startSeat <= seats[hallNumber][row].length - numSeats; startSeat++) {
                boolean available = true;
                for (int seat = startSeat; seat < startSeat + numSeats; seat++) {
                    if (seats[hallNumber][row][seat] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    System.out.println(numSeats + " seats available in Row " + (row + 1) + " of Hall " + hallNumber);
                    return true;
                }
            }
        }
        System.out.println("No " + numSeats + " consecutive seats available in any row of Hall " + hallNumber);
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Seating arrangement for Hall " + hallNumber + ":");
        for (int row = 0; row < seats[hallNumber].length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int seat = 0; seat < seats[hallNumber][row].length; seat++) {
                if (seats[hallNumber][row][seat] == 1) {
                    System.out.print("1 ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 5, 20);

        cinema.bookSeats(1, 1, new int[]{3, 4, 5, 9, 10, 11, 12, 13, 14, 19});
        cinema.bookSeats(1, 3, new int[]{3, 4, 5, 9, 10, 11, 12, 13, 14, 19});
        cinema.bookSeats(1, 4, new int[]{1, 2, 3, 4, 10, 15, 16, 17, 19});
        cinema.cancelBooking(1, 3, new int[]{4, 5, 13});
        cinema.checkAvailability(1, 10);
        cinema.printSeatingArrangement(1);
    }
}
