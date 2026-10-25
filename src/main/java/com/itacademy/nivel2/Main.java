package com.itacademy.nivel2;

public class Main {

    public static void main(String[] args) {

        byte age = ConsoleReader.readByte("Enter your age: ");
        int salary = ConsoleReader.readInt("Enter your annual salary: ");
        float height = ConsoleReader.readFloat("Enter your height: ");
        double weight = ConsoleReader.readDouble("Enter your weight: ");

        System.out.println("Your age is " + age +
                "\nYour annual salary is " + salary +
                "\nYour height is " + height +
                "\nYour weight is " + weight);
    }
}
