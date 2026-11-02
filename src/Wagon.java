/**Глава 6 Вариант А6
 6) Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
 Вагон. Возможности: получить или изменить различную информацию
 о вагоне: регистрационный номер вагона, пункт назначения, владелец, ста
 тус (загрузка, разгрузка, в пути, в ремонте, готов к отправке, требуется ре
 монт); узнать снаряженную массу; отправить в пункт назначения; обслу
 жить; отремонтировать; загрузить; разгрузить; узнать хрупкость/ценность
 груза. Добавить дополнительные возможности для грузового и пассажир
 ского вагонов.*/
public abstract class Wagon {
    private String registrationNumber;
    private String destination;
    private String owner;
    private double tareWeight;
    private WagonStatus status;

    public Wagon(String registrationNumber, String destination, String owner, double tareWeight, WagonStatus status) {
        this.registrationNumber = registrationNumber;
        this.destination = destination;
        this.owner = owner;
        this.tareWeight = tareWeight;
        this.status = status;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getTareWeight() {
        return tareWeight;
    }

    public WagonStatus getStatus() {
        return status;
    }

    public void setStatus(WagonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "номер='" + registrationNumber + '\'' + ", пункт назначения='" + destination + '\'' + ", владелец='" + owner + '\'' + ", снаряженная масса=" + tareWeight + ", статус=" + status;
    }
}