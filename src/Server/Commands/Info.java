package Server.Commands;

import Client.DataManager.ReadCSVFile;
import Server.CommandsManager;
import static Server.Commands.Commands.tablica;

import static Server.CommandsManager.history;

public class Info {
    public static void info(){
        System.out.println("Дата создания коллекции: " + ReadCSVFile.tablicaCreationDate);
        System.out.println("Количество элементов в коллекции: " + tablica.size());
    }
    public static void addToHistory(){
        history.add(Info.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}
