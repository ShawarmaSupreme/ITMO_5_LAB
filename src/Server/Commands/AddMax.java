package Server.Commands;
import Server.Models.Ticket;
import Server.CommandsManager;

import java.util.Scanner;

import static Server.Commands.Add.add;
import static Server.Commands.Commands.tablica;
import static Server.CommandsManager.history;

public class AddMax{
    public static void addIfMax(String[] argument) {
        long inputID = Long.parseLong(argument[0]);
        boolean availabilityFlag = false;
        long maxID = 0;
        for (Ticket tic : tablica) {
            if (tic.getID() == inputID) {
                System.out.println("Такой ID уже существует");
                availabilityFlag = true;
                break;
            }
            maxID = Math.max(maxID, tic.getID());
        }
        maxID = Math.max(maxID, inputID);
        if (!availabilityFlag && maxID == inputID) {
            System.out.println("Элемент с индексом " + inputID + " можно добавить");
            add((int) inputID);
        } else if (!availabilityFlag) System.out.println("Данный ID не максимальный");
    }

    public static void addToHistory(){
        history.add(AddMax.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}