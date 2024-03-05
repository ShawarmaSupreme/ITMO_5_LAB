package Server.Commands;

import Server.Models.Ticket;
import Server.CommandsManager;

import java.util.Scanner;

import static Server.CommandsManager.history;
import static Server.Models.IDstack.idStack;
import static Server.Commands.Commands.tablica;


public class RemoveByID {
    public static void removeByID(String[] arguments){
        long inputID = Long.parseLong(arguments[0]);
        boolean f = false;
        for (Ticket tic : tablica){
            if (tic.getID() == inputID){
                tablica.remove(tic);
                f = true;
                System.out.println("Элемент с ID: " + inputID + " удален");
                idStack.push((int) inputID);
                break;
            }
        }
        if (!f) {
            System.out.println("Элемент " + inputID + " не найден в таблице.");
        }
    }
    public static void addToHistory(){
        history.add(RemoveByID.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }

}
