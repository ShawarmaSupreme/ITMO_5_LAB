package Client.ErrorCheckers;

import java.util.Scanner;

public class InputCheck {
    public static Long IsLong(String inputLong) {
        Scanner scanner = new Scanner(System.in);
        int t = 0;
        long testLong = 0;
        while (t == 0) {
            try {
                testLong = Long.parseLong(inputLong);
                t++;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                IsLong(scanner.next());
                t++;
            }
        }
        return testLong;
    }
    public static Long IsDouble(String inputDouble) {
        Scanner scanner = new Scanner(System.in);
        int t = 0;
        long testDouble = 0;
        while (t == 0) {
            try {
                testDouble = Long.parseLong(inputDouble);
                t++;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                IsDouble(scanner.next());
                t++;
            }
        }
        return testDouble;
    }
    public static Float IsFloat(String inputFloat) {
        Scanner scanner = new Scanner(System.in);
        int t = 0;
        float testFloat = 0;
        while (t == 0) {
            try {
                testFloat = Float.parseFloat(inputFloat);
                t++;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
                IsFloat(scanner.next());
                t++;
            }
        }
        return testFloat;
    }
}