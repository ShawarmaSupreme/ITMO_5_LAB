package Server.Commands;

import Server.Models.Ticket;
import Server.CommandsManager;

import java.util.Scanner;
import static Server.Commands.Commands.tablica;
import static Server.CommandsManager.history;


public class RemoveLower {
    public static void removeLower(String[] argument) {
        long inputID = Long.parseLong(argument[0]);
        boolean availabilityFlag = false;
        long maxID = 0;
        for (Ticket tic : tablica) {
            if (tic.getID() < inputID) {
                tablica.remove(tic);
                System.out.println("элемент с ID " + inputID + " удален");
                availabilityFlag = true;
            }
        }
        if (!availabilityFlag) System.out.println("Нет элементов меньше заданного");
    }
    public static void addToHistory(){
        history.add(RemoveLower.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}
