package Client.DataManager;

import Server.CommandsManager;
import Server.Models.Ticket;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static Server.Commands.Commands.tablica;

public class WriteCSVFile {
    public static void writecsv() throws IOException {
        System.out.println("Введите название файла без расширения");
        Scanner scanner = new Scanner(System.in);
        String FilePath = scanner.nextLine();
        FilePath = FilePath + ".csv";
        FileWriter csvWriter = new FileWriter(FilePath);
        StringBuilder lines = new StringBuilder();

        for (Ticket ticket : tablica){
            lines.append(ticket.getID()).append(",")
                    .append(ticket.getName()).append(",")
                    .append(ticket.getCoordinates()).append(",")
                    .append(ticket.getPrice()).append(",")
                    .append(ticket.getTicketType()).append(",")
                    .append(ticket.getVenueType()).append(",")
                    .append("\n");
        }
        Files.writeString(Paths.get(FilePath), lines.toString());
        csvWriter.flush();
        csvWriter.close();
    }
    public static void writecsv(String[] arguments) throws IOException {
        String FilePath = arguments[0];
        FilePath = FilePath + ".csv";
        FileWriter csvWriter = new FileWriter(FilePath);
        StringBuilder lines = new StringBuilder();

        for (Ticket ticket : tablica){
            lines.append(ticket.getID()).append(",")
                    .append(ticket.getName()).append(",")
                    .append(ticket.getCoordinates()).append(",")
                    .append(ticket.getPrice()).append(",")
                    .append(ticket.getTicketType()).append(",")
                    .append(ticket.getVenueType()).append(",")
                    .append("\n");
        }
        Files.writeString(Paths.get(FilePath), lines.toString());
        csvWriter.flush();
        csvWriter.close();
    }
}