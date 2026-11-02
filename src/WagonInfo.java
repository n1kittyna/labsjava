/**Глава 6 Вариант А6
 6) Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
 Вагон. Возможности: получить или изменить различную информацию
 о вагоне: регистрационный номер вагона, пункт назначения, владелец, ста
 тус (загрузка, разгрузка, в пути, в ремонте, готов к отправке, требуется ре
 монт); узнать снаряженную массу; отправить в пункт назначения; обслу
 жить; отремонтировать; загрузить; разгрузить; узнать хрупкость/ценность
 груза. Добавить дополнительные возможности для грузового и пассажир
 ского вагонов.*/
public interface WagonInfo {
    String getRegistrationNumber();
    String getDestination();
    void setDestination(String destination);
    String getOwner();
    void setOwner(String owner);
    WagonStatus getStatus();
    void setStatus(WagonStatus status);
    double getTareWeight();

    default boolean isReadyToDispatch() {
        return getStatus() == WagonStatus.READY_FOR_DISPATCH;
    }

    default String shortInfo() {
        return "вагон " + getRegistrationNumber() + ", назначение: " + getDestination() + ", статус: " + getStatus();
    }
}