package Client.ErrorCheckers;

import java.util.Scanner;

public class EnumCheck {
    public static String IsTicketType(String inputStr) {
        inputStr = inputStr.toUpperCase();
            switch(inputStr) {
                case "1", "USUAL":
                    return "USUAL";
                case "2", "BUDGETARY":
                    return "BUDGETARY";
                case "3", "CHEAP":
                    return "CHEAP";
                default:
                    System.out.println("Ошибка ввода. Введите тип билета или номер из списка:\n" +
                            " 1 - USUAL\n 2 - BUDGETARY\n 3 - CHEAP");
                    }
        Scanner scanner = new Scanner(System.in);
        return IsTicketType(scanner.next());
    }
    public static String IsVenueType(String inputStr) {
        inputStr = inputStr.toUpperCase();
        switch(inputStr) {
            case "1", "LOFT":
                return "LOFT";
            case "2", "THEATRE":
                return "THEATRE";
            case "3", "CINEMA":
                return "CINEMA";
            case "4", "MALL":
                return "MALL";
            case "5", "STADIUM":
                return "STADIUM";
            default:
                System.out.println("Ошибка ввода. Введите название места или номер из списка:\n" +
                        " 1 - LOFT\n 2 - THEATRE\n 3 - CINEMA\n 4 - MALL\n 5 - STADIUM");
        }
        Scanner scanner = new Scanner(System.in);
        return IsVenueType(scanner.next());
    }
}