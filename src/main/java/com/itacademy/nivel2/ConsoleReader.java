package com.itacademy.nivel2;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class ConsoleReader {

    private ConsoleReader() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static byte readByte(String message) {
        while (true) {
            System.out.println(message);

            try {
                byte value = scanner.nextByte();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }
    }

    public static int readInt(String message) {
        while (true) {
            System.out.println(message);

            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            System.out.println(message);

            try {
                float value = scanner.nextFloat();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.println(message);

            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Format error. Try again.");
            }
        }
    }

    public static char readChar(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();

            try {
                if (input.length() != 1) {
                    throw new InvalidInputException("You must enter a single character.");
                }

                return input.charAt(0);

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readString(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();

            try {
                if (input.isBlank()) {
                    throw new InvalidInputException("The entrance cannot be empty.");
                }

                return input;

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean readYesNo(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();

            try {
                if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                    throw new InvalidInputException("Invalid entry, please enter'y' or 'n'.");
                }

                return input.equalsIgnoreCase("Y");

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
