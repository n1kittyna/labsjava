/**Задания к главе 3
 Вариант А
 Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно
 методы в классе, создающем массив объектов. Задать критерий выбора данных
 и вывести эти данные на консоль. В каждом классе, обладающем информацией,
 должно быть объявлено несколько конструкторов.
 6. House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип
 здания, Срок эксплуатации.
 Создать массив объектов. Вывести:
 a) список квартир, имеющих заданное число комнат;
 b) список квартир, имеющих заданное число комнат и расположенных на
 этаже, который находится в заданном промежутке;
 c) список квартир, имеющих площадь, превосходящую заданную.*/
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class House {
    private long id;
    private int flatNumber;
    private double area;
    private int floor;
    private int rooms;
    private String street;
    private String buildingType;
    private int lifetime;

    public House() {
    }
    public House(long id) {
        this.id = id;
    }
    public House(long id, int flatNumber, double area, int floor, int rooms,
                 String street, String buildingType, int lifetime) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.buildingType = buildingType;
        this.lifetime = lifetime;
    }

    public long getId() { return id; }
    public int getFlatNumber() { return flatNumber; }
    public double getArea() { return area; }
    public int getFloor() { return floor; }
    public int getRooms() { return rooms; }
    public String getStreet() { return street; }
    public String getBuildingType() { return buildingType; }
    public int getLifetime() { return lifetime; }

    public void setId(long id) { this.id = id; }
    public void setFlatNumber(int flatNumber) { this.flatNumber = flatNumber; }
    public void setArea(double area) { this.area = area; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setRooms(int rooms) { this.rooms = rooms; }
    public void setStreet(String street) { this.street = street; }
    public void setBuildingType(String buildingType) { this.buildingType = buildingType; }
    public void setLifetime(int lifetime) { this.lifetime = lifetime; }

    @Override
    public String toString() {
        return String.format(
                "номер квартиры: %d | количество комнат: %d | площадь: %.1f | этаж: %d | улица: %s | тип здания: %s | срок эксплуатации: %d лет",
                flatNumber, rooms, area, floor, street, buildingType, lifetime
        );
    }
}

