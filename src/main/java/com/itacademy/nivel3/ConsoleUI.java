package com.itacademy.nivel3;

import com.itacademy.nivel2.ConsoleReader;
import com.itacademy.nivel3.Exceptions.InvalidPersonNameException;
import com.itacademy.nivel3.Exceptions.InvalidSeatException;
import com.itacademy.nivel3.Exceptions.SeatAlreadyEmptyException;
import com.itacademy.nivel3.Exceptions.SeatAlreadyTakenException;

import java.util.List;

public class ConsoleUI {
    private final ReservationService reservationService;

    public ConsoleUI(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void showMenu() {
        System.out.println(" --- Menu --- ");
        System.out.println(
                "1. Show all reservations\n" +
                        "2. Show reservations for one person\n" +
                        "3. Reserve a seat\n" +
                        "4. Cancel a reservation\n" +
                        "5. Cancel all reservations for one person\n" +
                        "0. Exit"
        );
    }

    public void start() {

        while (true) {
            showMenu();

            byte optionChosen = ConsoleReader.readByte("Choose an option: ");

            switch (optionChosen) {
                case 1 -> {
                    List<Seat> seats = reservationService.getAllSeats();
                    showReservations(seats);
                }
                case 2 -> {
                    try {
                        String name = ConsoleReader.readString("Write the name of person: ");
                        List<Seat> seats = reservationService.getSeatsByPerson(name);
                        showReservations(seats);
                    } catch (InvalidPersonNameException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        reservationService.reserveSeat(ConsoleReader.readInt("Enter row: "), ConsoleReader.readInt("Enter seat: "), ConsoleReader.readString("Enter the name: "));
                        System.out.println("Seat reserved");
                    } catch (InvalidSeatException | InvalidPersonNameException | SeatAlreadyTakenException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        reservationService.cancelSeat(ConsoleReader.readInt("Enter row to cancel: "), ConsoleReader.readInt("Enter seat to cancel: "));
                        System.out.println("Reservation cancelled");
                    } catch (InvalidSeatException | SeatAlreadyEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    String name = ConsoleReader.readString("Enter the name of the person:");
                    try {
                        List<Seat> seats = reservationService.getSeatsByPerson(name);

                        if (seats.isEmpty()) {
                            System.out.println("This person has no reservations");
                        } else {
                            reservationService.cancelAllByPersona(name);
                            System.out.println("Reservations cancelled");
                        }
                    } catch (InvalidPersonNameException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Goodbye");
                    return;
                }
                default -> System.out.println("Please choose a valid menu option: ");
            }
        }
    }

    private static void showReservations(List<Seat> seats) {
        if (seats.isEmpty()) {
            System.out.println("No reservations");
        } else {
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }
}
