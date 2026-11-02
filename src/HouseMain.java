import java.util.ArrayList;
import java.util.List;

public class HouseMain {
    public static void main(String[] args) {

        List<House> houses = new ArrayList<>();
        houses.add(new House(1, 5, 56.4, 3, 2, "Ленина", "панельный", 50));
        houses.add(new House(2, 12, 78.2, 5, 3, "Пушкина", "кирпичный", 80));
        houses.add(new House(3, 7, 42.0, 2, 1, "Павлова", "деревянный", 45));
        houses.add(new House(4, 33, 120.5, 9, 4, "Иванова", "панельный", 100));
        houses.add(new House(5, 15, 60.0, 4, 2, "Комарова", "кирпичный", 60));

        HouseAction action = new HouseAction();

        System.out.println("а) список квартир с 2 комнатами: ");
        action.findByRooms(houses, 2).forEach(h -> System.out.println(h));

        System.out.println("\n b) 2-комнатные квартиры на этажах со 2 по 4: ");
        action.findByRoomsAndFloorRange(houses, 2, 2, 4).forEach(h -> System.out.println(h));

        System.out.println("\n c) квартиры с площадью более 70 кв.м: ");
        action.findByAreaGreaterThan(houses, 70.0).forEach(h -> System.out.println(h));
    }
}