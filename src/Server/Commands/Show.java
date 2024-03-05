package Server.Commands;

import Server.Models.Ticket;
import Server.CommandsManager;

import static Server.Commands.Commands.tablica;
import static Server.CommandsManager.history;

/**
 * ну типа джава док
 */
public class Show {
    public static void show(){
        for (Ticket tic : tablica) {
            System.out.print(tic.getName() + "   ID: ");
            System.out.println(tic.getID());
        }
    }
    public static void addToHistory(){
        history.add(Show.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}
