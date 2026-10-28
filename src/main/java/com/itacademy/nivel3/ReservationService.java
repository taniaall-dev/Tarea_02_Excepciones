package com.itacademy.nivel3;

import com.itacademy.nivel3.Exceptions.InvalidPersonNameException;
import com.itacademy.nivel3.Exceptions.InvalidSeatException;
import com.itacademy.nivel3.Exceptions.SeatAlreadyEmptyException;
import com.itacademy.nivel3.Exceptions.SeatAlreadyTakenException;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private final int  totalRows;
    private final int seatsPerRow;
    private List<Seat> seats = new ArrayList<>();

    public ReservationService(int totalRows, int seatsPerRow) {
        validateDimensions(totalRows, seatsPerRow);

        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;

    }

    public void reserveSeat(int row, int seat, String name) {
        validateSeatPosition(row, seat);
        validateName(name);

        if (seats.contains(new Seat(row, seat, ""))) {
            throw new SeatAlreadyTakenException("The seat is taken");
        }

        seats.add(new Seat(row, seat, name));
    }

    public void cancelSeat(int row, int seat) {
        validateSeatPosition(row, seat);

        if (!seats.contains(new Seat(row, seat, ""))) {
            throw new SeatAlreadyEmptyException("The seat is not reserved");
        }
        seats.remove(new Seat(row, seat, ""));
    }

    public void cancelAllByPersona(String name) {
        validateName(name);

        for (int i = 0; i < seats.size(); ) {
            Seat reservationActually = seats.get(i);
            if (reservationActually.getPersonName().equals(name)) {
                seats.remove(i);
            } else {
                i++;
            }
        }
    }

    public List<Seat> getAllSeats() {
        return List.copyOf(seats);
    }

    public List<Seat> getSeatsByPerson(String name) {
        validateName(name);

        List<Seat> seatByPersonReservation = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.getPersonName().equals(name)) {
                seatByPersonReservation.add(seat);
            }
        }
        return seatByPersonReservation;
    }

    private void validateSeatPosition(int row, int seat) {
        if (row < 1 || row > totalRows) {
            throw new InvalidSeatException("Error: Invalid row");
        }
        if (seat < 1 || seat > seatsPerRow) {
            throw new InvalidSeatException("Error: Invalid seat");
        }
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new InvalidPersonNameException("Error: Name cannot be empty");
        }
        for (int i = 0; i < name.length(); i++) {

            if (Character.isDigit(name.charAt(i))) {
                throw new InvalidPersonNameException("Error: Name cannot contain numbers");
            }
        }
    }
    private void validateDimensions(int totalRows, int seatsPerRow) {
        if (totalRows < 1 || seatsPerRow < 1) {
            throw new IllegalArgumentException("Error: Positive numbers are required");
        }
    }

}
