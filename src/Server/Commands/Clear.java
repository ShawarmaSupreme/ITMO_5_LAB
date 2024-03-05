package Server.Commands;

import Server.CommandsManager;

import static Server.Commands.Commands.tablica;
import static Server.CommandsManager.history;

public class Clear {
    public static void clear(){
        tablica.clear();
    }

    public static void addToHistory(){
        history.add(Clear.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}
