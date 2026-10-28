package com.itacademy.nivel3;

import java.util.Objects;

public class Seat {
    private int row;
    private int seat;
    private String personName;

    public Seat(int row, int seat, String personName) {
        this.row = row;
        this.seat = seat;
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat1 = (Seat) o;
        return row == seat1.row && seat == seat1.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }

    @Override
    public String toString() {
        return "Row " + row +
                ", Seat " + seat +
                ", Reserved by " + personName;
    }

    public String getPersonName() {
        return personName;
    }

}
