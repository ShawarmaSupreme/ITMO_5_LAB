package Server;

import java.lang.reflect.Method;
import java.util.*;


import static Client.Main.arguments;
import static Server.Commands.Add.add;
import static Server.Commands.AddMax.addIfMax;
import static Client.Main.*;
import static Server.Commands.AddMax.addIfMax;
import static java.awt.AWTEventMulticaster.add;

public class CommandsManager {
    public static Queue<String> history = new LinkedList<>();
    static Map<String, Method> CommandsMap = new HashMap<>();
    public static void comMan(String command) throws Exception{
        CommandsMap.put("add", CommandsManager.class.getMethod("addInvoker"));
        CommandsMap.put("addmax", null);
        CommandsMap.put("clear", null);
        //put("executescript", CommandsManager::executescriptInvoker);
        CommandsMap.put("help", null);
        CommandsMap.put("history", null);
        CommandsMap.put("info", null);
        CommandsMap.put("removelower", null);
        CommandsMap.put("show", null);
        CommandsMap.put("updateid", null);
        CommandsMap.put("remove", null);

        String cmd = "add";
        CommandsMap.get(cmd).invoke(null);

    }
    public static void addInvoker(){
        add(arguments);
    }
    public static void addIfMaxInvoker(CommandsManager CM, String[] args){
        addIfMax(args);
    }
//    public static void clearInvoker(CommandsManager CM, String[] args){
//        clear();
//    }
////    public static void executescriptInvoker(CommandsManager CM, String[] args){
////        executescript(args);
////    }
//    public static void helpInvoker(CommandsManager CM, String[] args){
//        help();
//    }
//    public static void historyInvoker(CommandsManager CM, String[] args){
//        getHistory();
//    }
//    public static void infoInvoker(CommandsManager CM, String[] args){
//        info();
//    }
//    public static void removelowerInvoker(CommandsManager CM, String[] args){
//        removeLower(args);
//    }
//    public static void showInvoker(CommandsManager CM, String[] args){
//        show();
//    }
//    public static void updateIDInvoker(CommandsManager CM, String[] args){
//        updateID(args);
//    }
//    public static void removeByIDInvoker(CommandsManager CM, String[] args){
//        removeByID(args);
//    }
}









//    public static void readCom(String Com, String[] argumentArray) throws IOException {
//        if (Com == null) {
//            System.out.print("Введите команду: ");
//            Scanner scanner = new Scanner(System.in);
//            String command = scanner.nextLine();
//            command = command.trim().toLowerCase();
//
//            switch (command) {
//                case "exit", "9":
//                    System.out.println("Завершение программы");
//                    CommandReader.IndexOfWork++;
//                    scanner.close();
//                    break;
//                case "help", "0":
//                    help();
//                    Help.addToHistory();
//                    break;
//                case "ticket_add", "3":
//                    add();
//                    Add.addToHistory();
//                    break;
//                case "history", "12":
//                    getHistory();
//                    History.addToHistory();
//                    break;
//                case "info", "1":
//                    info();
//                    Info.addToHistory();
//                    break;
//                case "show", "2":
//                    show();
//                    Show.addToHistory();
//                    break;
//                case "clear", "6":
//                    clear();
//                    Clear.addToHistory();
//                    break;
//                case "update id", "4":
//                    updateID();
//                    UpdateID.addToHistory();
//                    break;
//                case "remove", "5":
//                    removeByID();
//                    RemoveByID.addToHistory();
//                    break;
//                case "save":
//                    writecsv();
//                    break;
//                case "8", "execute_script":
//                    System.out.println("Введите путь к файлу\n" +
//                            "/Users/shawama_supreme/Desktop/MyFirstApp/src/DataManager/Script");
//                    String scriptFile = scanner.next();
//                    scriptReader(scriptFile);
//                    break;
//                case "10", "add_if_max":
//                    addIfMax();
//                    break;
//                default:
//                    System.out.println("Неизвестная команда, повторите ввод");
//            }
//        } else {
//            switch (Com) {
//                case "exit", "9":
//                    System.out.println("Завершение программы");
//                    CommandReader.IndexOfWork++;
//                    break;
//                case "help", "0":
//                    help();
//                    Help.addToHistory();
//                    break;
//                case "ticket_add", "3":
//                    add(argumentArray);
//                    Add.addToHistory();
//                    break;
//                case "history", "12":
//                    getHistory();
//                    History.addToHistory();
//                    break;
//                case "info", "1":
//                    info();
//                    Info.addToHistory();
//                    break;
//                case "show", "2":
//                    show();
//                    Show.addToHistory();
//                    break;
//                case "clear", "6":
//                    clear();
//                    Clear.addToHistory();
//                    break;
//                case "update_id", "4":
//                    updateID(argumentArray);
//                    UpdateID.addToHistory();
//                    break;
//                case "remove", "5":
//                    removeByID(argumentArray);
//                    RemoveByID.addToHistory();
//                    break;
//                case "save":
//                    writecsv(argumentArray);
//                    break;
//                case "8", "execute_script":
//                    scriptReader(argumentArray[0]);
//                    break;
//                case "10", "add_if_max":
//                    addIfMax(argumentArray[0]);
//                    break;
//                default:
//                    System.out.println("В скрипте обнаружена неизвестная команда");
//            }
//        }
//    }