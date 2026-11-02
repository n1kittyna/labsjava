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
import java.util.List;
import java.util.stream.Collectors;

public class HouseAction {
    // a) список квартир, имеющих заданное число комнат
    public List<House> findByRooms(List<House> houses, int rooms) {
        return houses.stream().filter(h -> h.getRooms() == rooms).collect(Collectors.toList());
    }
    // b) квартиры с заданным числом комнат и этажом в заданном промежутке
    public List<House> findByRoomsAndFloorRange(List<House> houses, int rooms, int minFloor, int maxFloor) {
        return houses.stream().filter(h -> h.getRooms() == rooms).filter(h -> h.getFloor() >= minFloor && h.getFloor() <= maxFloor).collect(Collectors.toList());
    }
    // c) квартиры с площадью, превосходящей заданную
    public List<House> findByAreaGreaterThan(List<House> houses, double minArea) {
        return houses.stream().filter(h -> h.getArea() > minArea).collect(Collectors.toList());
    }
}