package Server.Commands;

import Server.CommandsManager;
import Server.Models.Coordinates;
import Server.Models.Enums.TicketType;
import Server.Models.Enums.VenueType;
import Server.Models.Ticket;
import Server.Models.Venue;

import java.time.ZonedDateTime;
import java.util.*;

import static Server.Commands.Add.add;
import static Server.Models.IDstack.addID;
//ServerSocket s = serverSocket(port)
//Socket client = s.accept()
//br = new (client.getInputStream)
//bw
//write()
//Socket s = new Socket(ip, port)
public class Commands {
    public static Queue<String> history = new LinkedList<>();
    public static LinkedHashSet<Ticket> tablica = new LinkedHashSet<>();



    public void addIfMax(String[] argument) {
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
        history.add(Add.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }

}
