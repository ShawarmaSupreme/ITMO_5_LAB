package Server.Models;

import Server.Models.Enums.TicketType;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;

/**
 *
 */
public class Ticket{
    public static LinkedHashSet<Ticket> tablica = new LinkedHashSet<>();
    @Override
    public String toString(){
        return this.name;
    }
        public long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Float price; //Поле может быть null, Значение поля должно быть больше 0
        private TicketType type; //Поле не может быть null
        private Venue venue; //Поле не может быть null
    public Ticket(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, Float price, TicketType type, Venue venue) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.venue = venue;
    }

    public long getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Coordinates getCoordinates(){
        return this.coordinates;
    }
    public java.time.ZonedDateTime getCreationDate(){
        return this.creationDate;
    }
    public Float getPrice(){
        return this.price;
    }
    public Enum<TicketType> getTicketType(){
        return this.type;
    }
    public Venue getVenueType(){
        return this.venue;
    }
}