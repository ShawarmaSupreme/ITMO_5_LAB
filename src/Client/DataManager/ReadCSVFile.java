package Client.DataManager;

import Server.CommandsManager;
import Server.Models.Enums.TicketType;
import Server.Models.Enums.VenueType;
import Server.Models.Coordinates;
import Server.Models.Ticket;
import Server.Models.Venue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;

import static Server.Commands.Commands.tablica;
import static Server.Models.IDstack.addID;


public class ReadCSVFile {
    public static ZonedDateTime tablicaCreationDate = ZonedDateTime.now();
    public static void CSVreader(String csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length >= 8) {

                    String venueNameToAdd = fields[0].trim();
                    long capacity = Long.parseLong(fields[1].trim());
                    VenueType venueType = VenueType.valueOf(fields[2].trim());
                    String ticketNameToAdd = fields[3].trim();
                    long fxToAdd = Long.parseLong(fields[4].trim());
                    Double yToAdd = Double.parseDouble(fields[5].trim());
                    Float priceToAdd = Float.parseFloat(fields[6].trim());
                    TicketType ticketTypeToAdd = TicketType.valueOf(fields[7].trim());

                    ZonedDateTime creationDate = ZonedDateTime.now();
                    int id = addID();

                    Venue venue = new Venue(venueNameToAdd, capacity, venueType);
                    Coordinates coordinates = new Coordinates(fxToAdd, yToAdd);
                    Ticket ticketToAdd = new Ticket(id, ticketNameToAdd, coordinates, creationDate, priceToAdd, ticketTypeToAdd, venue);
                    tablica.add(ticketToAdd);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("!!!!!!!!! Файл не найден !!!!!!!!!".toUpperCase());
        } catch (IOException e) {
            System.out.println("!!!!!!!!! Ошибка чтения файла !!!!!!!!!".toUpperCase());
        } catch (Exception e) {
            System.out.println("!!!!!!!!! Файл поврежден !!!!!!!!!".toUpperCase());
        }
    }
}