package com.itacademy.nivel1;

public class EmptySaleException extends RuntimeException{

    public EmptySaleException (){
        super("Para hacer una venta primero debes añadir productos");
    }
}
