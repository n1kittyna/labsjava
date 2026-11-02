/**Глава 6 Вариант А6
 6) Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
 Вагон. Возможности: получить или изменить различную информацию
 о вагоне: регистрационный номер вагона, пункт назначения, владелец, ста
 тус (загрузка, разгрузка, в пути, в ремонте, готов к отправке, требуется ре
 монт); узнать снаряженную массу; отправить в пункт назначения; обслу
 жить; отремонтировать; загрузить; разгрузить; узнать хрупкость/ценность
 груза. Добавить дополнительные возможности для грузового и пассажир
 ского вагонов.*/
import java.util.ArrayList;
import java.util.List;

public class WagonMain {
    public static void main(String[] args) {
        CargoWagon cargoWagon = new CargoWagon("А123БВ", "улан-удэ", "ржд",
                22.5, WagonStatus.READY_FOR_DISPATCH, 60.0);
        PassengerWagon passengerWagon = new PassengerWagon("В456ГД", "иркутск", "жд",
                18.0, WagonStatus.READY_FOR_DISPATCH, 54);

        List<WagonInfo> wagons = new ArrayList<>();
        wagons.add(cargoWagon);
        wagons.add(passengerWagon);

        System.out.println("информация о вагонах:");
        for (WagonInfo wagon : wagons) {
            System.out.println(wagon.shortInfo());
        }

        Cargo cargo = new Cargo("стекло", true, false, 15.0);
        cargoWagon.setCargo(cargo);
        cargoWagon.load();
        System.out.println("грузовой вагон после погрузки:");
        System.out.println(cargoWagon);
        System.out.println("хрупкий груз: " + cargoWagon.isFragileCargo());
        System.out.println("ценный груз: " + cargoWagon.isValuableCargo());

        passengerWagon.boardPassenger();
        passengerWagon.boardPassenger();
        System.out.println("пассажирский вагон после посадки:");
        System.out.println(passengerWagon);
        System.out.println("свободных мест: " + passengerWagon.getFreeSeats());

        List<WagonActionable> actions = new ArrayList<>();
        actions.add(cargoWagon);
        actions.add(passengerWagon);
        System.out.println("отправка вагонов:");
        for (WagonActionable action : actions) {
            action.sendToDestination();
        }

        System.out.println("статусы после отправки:");
        for (WagonInfo wagon : wagons) {
            System.out.println(wagon.shortInfo());
        }
    }
}