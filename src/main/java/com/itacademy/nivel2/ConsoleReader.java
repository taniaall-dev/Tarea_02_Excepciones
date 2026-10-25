package com.itacademy.nivel2;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class ConsoleReader {

    private ConsoleReader() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static byte readByte(String message) {
        byte numByte;

        while (true) {
            try {
                System.out.println(message);
                numByte = scanner.nextByte();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }

        return numByte;
    }

    public static int readInt(String message) {
        int numInt;

        while (true) {
            try {
                System.out.println(message);
                numInt = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }

        return numInt;
    }

    public static float readFloat(String message) {
        float numFloat;

        while (true) {
            try {
                System.out.println(message);
                numFloat = scanner.nextFloat();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }

        return numFloat;
    }

    public static double readDouble(String message) {
        double numDouble;

        while (true) {
            try {
                System.out.println(message);
                numDouble = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }

        return numDouble;
    }
}
