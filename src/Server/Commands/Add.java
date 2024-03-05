package Server.Commands;

import Server.Models.Enums.TicketType;
import Server.Models.Enums.VenueType;
import Server.Models.Coordinates;
import Server.Models.Ticket;
import Server.Models.Venue;
import Server.CommandsManager;

import java.time.ZonedDateTime;
import java.util.Scanner;

import static Server.Commands.Commands.tablica;
import static Server.CommandsManager.history;
import static Client.ErrorCheckers.EnumCheck.IsTicketType;
import static Client.ErrorCheckers.EnumCheck.IsVenueType;
import static Client.ErrorCheckers.InputCheck.*;
import static Server.Models.IDstack.addID;

public class Add {

    public static void add(String[] arguments){
        String venueNameToAdd = arguments[0];
        long capacity = Long.parseLong(arguments[1]);
        String userInput = arguments[2];
        String ticketNameToAdd = arguments[3];
        long fxToAdd = Long.parseLong(arguments[4]);
        double yToAdd = Double.parseDouble(arguments[5]);
        Float priceToAdd = Float.parseFloat(arguments[6]);
        String ticketType = arguments[7];

        VenueType venueType = VenueType.valueOf(userInput);
        TicketType ticketTypeToAdd = TicketType.valueOf(ticketType);
        ZonedDateTime creationDate = ZonedDateTime.now();
        Venue venue = new Venue(venueNameToAdd, capacity, venueType);
        Coordinates coordinates = new Coordinates(fxToAdd, yToAdd);
        Ticket ticketToAdd = new Ticket(addID(), ticketNameToAdd, coordinates, creationDate, priceToAdd, ticketTypeToAdd, venue);
        tablica.add(ticketToAdd);
        System.out.println("Билет добавлен");
    }

    static void add(int inputID){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите название места:");
        String venueNameToAdd = scanner.nextLine();

        System.out.println("Введите вместимость");
        long capacity = IsLong(scanner.next());

        System.out.println("Введите тип местa: 1 - LOFT\n 2 - THEATRE\n 3 - CINEMA\n 4 - MALL\n 5 - STADIUM");
        String userInput = IsVenueType(scanner.next());
        VenueType venueType = VenueType.valueOf(userInput);

        System.out.println("Введите имя на билете");
        String ticketNameToAdd = scanner.next();

        System.out.println("Введите координату х");
        long fxToAdd = IsLong(scanner.next());

        System.out.println("Введите координату у");
        double yToAdd = IsDouble(scanner.next());

        System.out.println("Введите стоимость");
        Float priceToAdd = IsFloat(scanner.next());

        System.out.println("Введите тип билета: 1 - USUAL\n 2 - BUDGETARY\n 3 - CHEAP");
        userInput = IsTicketType(scanner.next());
        TicketType ticketTypeToAdd = TicketType.valueOf(userInput);

        System.out.println("Билет добавлен");



        ZonedDateTime creationDate = ZonedDateTime.now();

        Venue venue = new Venue(venueNameToAdd, capacity, venueType);
        Coordinates coordinates = new Coordinates(fxToAdd, yToAdd);
        Ticket ticketToAdd = new Ticket(inputID, ticketNameToAdd, coordinates, creationDate, priceToAdd, ticketTypeToAdd, venue);
        tablica.add(ticketToAdd);
    }

    public static void addToHistory(){
        history.add(Add.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}