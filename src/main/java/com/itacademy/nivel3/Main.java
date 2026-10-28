package com.itacademy.nivel3;

import com.itacademy.nivel2.ConsoleReader;

public class Main {
    public static void main (String[] args) {
        while(true){
            int rows = ConsoleReader.readInt("How many rows does the room have?");
            int seatsPerRow = ConsoleReader.readInt("How many seats does the room have?");

            try {
                ReservationService reservationService = new ReservationService(rows,seatsPerRow);
                ConsoleUI consoleUI = new ConsoleUI(reservationService);
                consoleUI.start();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
