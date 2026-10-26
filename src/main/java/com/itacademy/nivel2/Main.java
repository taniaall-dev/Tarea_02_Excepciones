package com.itacademy.nivel2;

public class Main {

    public static void main(String[] args) {

        readAndDisplayData();
    }

    public static void readAndDisplayData() {
        String name = ConsoleReader.readString("Enter your name: ");
        byte age = ConsoleReader.readByte("Enter your age: ");
        char initial = ConsoleReader.readChar("Enter the initial of your name: ");
        int siblings = ConsoleReader.readInt("Enter the number of siblings you have: ");
        float height = ConsoleReader.readFloat("Enter your height: ");
        double weight = ConsoleReader.readDouble("Enter your weight: ");
        boolean answer = ConsoleReader.readYesNo("Do you know the true identity of M. Rajoy?");

        System.out.println(
                "\n--- Your data ---" +
                        "\nName: " + name +
                        "\nAge: " + age +
                        "\nInitial: " + initial +
                        "\nNumber of siblings: " + siblings +
                        "\nHeight: " + height +
                        "\nWeight: " + weight +
                        "\nDo you know the true identity of M. Rajoy? " + answer);
    }

}
