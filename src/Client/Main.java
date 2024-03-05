package Client;

import Server.CommandsManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Client.DataManager.ReadCSVFile.CSVreader;
import static Client.ErrorCheckers.EnumCheck.IsTicketType;
import static Client.ErrorCheckers.EnumCheck.IsVenueType;
import static Client.ErrorCheckers.InputCheck.*;
import static Server.CommandsManager.comMan;
import static Server.Models.IDstack.idStack;

public class Main {
    public static int IndexOfWork = 0;
    //читает команду из терминала и кидает в чекеры и комманд менеджер
    public static Map<String, String[]> CommandsGetMap = new HashMap<>(){{
        put("add", null);
        put("addmax", null);
        put("clear", null);
        put("executescript", null);
        put("help", null);
        put("history", null);
        put("info", null);
        put("removelower", null);
        put("show", null);
        put("updateid", null);
        put("remove", null);
    }};
    public static String command;
    public static String[] arguments = new String[10];
    public static void main(String[] args) throws Exception {
        idStack.push(1);
        CSVreader("/Users/shawama_supreme/Desktop/MyFirstApp/src/Client/DataManager/data.csv");
        System.out.println("Введите 0 для вывода списка команд");
        Scanner scanner = new Scanner(System.in);
        CommandsManager CM = new CommandsManager();
        while (IndexOfWork == 0) {
            command = scanner.nextLine();
            if (command.toLowerCase() == "add" || command.toLowerCase() == "3") readAddArgs();
            if (command.toLowerCase() == "addmax" || command.toLowerCase() == "10") readAddMaxArgs();
            if (command.toLowerCase() == "remove" || command.toLowerCase() == "5" ||
                    command.toLowerCase() == "removelower" || command.toLowerCase() == "11") readRemoveArgs();
            if (command.toLowerCase() == "updateid" || command.toLowerCase() == "4") readUpdateArgs();
            comMan(command);
        }
    }
    public static void readAddArgs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название места:");
        arguments[0] = scanner.nextLine();

        System.out.println("Введите вместимость");
        long capacity = IsLong(scanner.next());
        arguments[1] = Long.toString(capacity);

        System.out.println("Введите тип местa: 1 - LOFT\n 2 - THEATRE\n 3 - CINEMA\n 4 - MALL\n 5 - STADIUM");
        String userInput = IsVenueType(scanner.next());
        arguments[2] = userInput;

        System.out.println("Введите имя на билете");
        arguments[3] = scanner.nextLine();

        System.out.println("Введите координату х");
        long fxToAdd = IsLong(scanner.next());
        arguments[4] = Long.toString(fxToAdd);

        System.out.println("Введите координату у");
        double yToAdd = IsDouble(scanner.next());
        arguments[5] = Double.toString(yToAdd);

        System.out.println("Введите стоимость");
        Float priceToAdd = IsFloat(scanner.next());
        arguments[6] = Float.toString(priceToAdd);

        System.out.println("Введите тип билета: 1 - USUAL\n 2 - BUDGETARY\n 3 - CHEAP");
        userInput = IsTicketType(scanner.next());
        arguments[7] = userInput;
        CommandsGetMap.put(command, arguments);
    }
    public static void readAddMaxArgs(){
        System.out.println("Введите желаемый ID");
        Scanner scanner = new Scanner(System.in);
        arguments[0] = scanner.nextLine();
        CommandsGetMap.put(command, arguments);
    }
    public static void readRemoveArgs(){
        System.out.println("Введите желаемый ID");
        Scanner scanner = new Scanner(System.in);
        arguments[0] = scanner.nextLine();
        CommandsGetMap.put(command, arguments);
    }
    public static void readUpdateArgs(){
        System.out.println("Введите ID элемента, который нужно обновить");
        Scanner scanner = new Scanner(System.in);
        arguments[0] = scanner.nextLine();
        System.out.println("Введите новый ID");
        arguments[1] = scanner.nextLine();
        CommandsGetMap.put(command, arguments);
    }
}
