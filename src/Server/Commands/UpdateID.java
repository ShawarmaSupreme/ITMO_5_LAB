package Server.Commands;

import Server.Models.Ticket;
import Server.CommandsManager;

import java.util.Scanner;

import static Server.Commands.Commands.tablica;
import static Server.CommandsManager.history;

public class UpdateID {
    public static void updateID(String[] arguments){
        int inputID = Integer.parseInt(arguments[0]);
        int newID = Integer.parseInt(arguments[1]);
        boolean f = false;
        for (Ticket tic : tablica){
            if (tic.getID() == inputID){
                tic.id = newID;
                tablica.remove(tic);
                tablica.add(tic);
                f = true;
                System.out.println("Элемент с ID: " + inputID + " найден в таблице. ID изменен на " + newID);
                break;
            }
        }
        if (!f) {
            System.out.println("Элемент " + inputID + " не найден в таблице.");
        }
    }
    public static void addToHistory(){
        history.add(UpdateID.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}
