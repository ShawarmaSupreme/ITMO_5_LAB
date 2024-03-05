package Server.Models;

import Server.Models.Enums.VenueType;

import static Server.Models.IDstack.lookID;

public class Venue {
    public Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long capacity; //Значение поля должно быть больше 0
    private VenueType type; //Поле может быть null

    public Venue(String name, long capacity, VenueType type) {
        this.id = lookID();
        this.name = name;
        this.type = type;
    }
}