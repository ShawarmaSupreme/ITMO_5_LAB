package Server.Models;

public class Coordinates {
    private long fx; //Значение поля должно быть больше -152
    private Double y; //Значение поля должно быть больше -249, Поле не может быть null

    public Coordinates(long fx, Double y){
        this.fx = fx;
        this.y = y;
    }
}