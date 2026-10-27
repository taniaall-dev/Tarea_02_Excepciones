package com.itacademy.nivel3;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private int totalRows;
    private int seatsPerRow;
    private List<Seat> seats = new ArrayList<>();

    public ReservationService (int totalRows,int seatsPerRow){
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;

    }

    // TODO reserveSeat(int row, int seat, String name)
    // TODO cancelSeat(int row, int seat)
    // TODO cancelAllByPerson(String name)
    // TODO List<Seat> getAllSeats()
    // TODO List<Seat> getSeatsByPerson(String name)

    // TODO privado validateSeatPosition(row, seat)
}
