package com.itacademy.nivel3;

public class ConsoleUI {
    ReservationService reservationService;

    public ConsoleUI (ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void showMenu() {
        System.out.println(" --- Menu --- ");
        System.out.println(
                        "1. Mostrar todas las reservas\n" +
                        "2. Mostrar reservas de una persona\n" +
                        "3. Reservar una butaca\n" +
                        "4. Anular una reserva\n" +
                        "5. Anular todas las reservas de una persona\n" +
                        "0. Salir"
        );
    }
}
