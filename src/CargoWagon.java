/**Глава 6 Вариант А6
 6) Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
 Вагон. Возможности: получить или изменить различную информацию
 о вагоне: регистрационный номер вагона, пункт назначения, владелец, ста
 тус (загрузка, разгрузка, в пути, в ремонте, готов к отправке, требуется ре
 монт); узнать снаряженную массу; отправить в пункт назначения; обслу
 жить; отремонтировать; загрузить; разгрузить; узнать хрупкость/ценность
 груза. Добавить дополнительные возможности для грузового и пассажир
 ского вагонов.*/
public class CargoWagon extends Wagon implements WagonInfo, WagonActionable {
    private Cargo cargo;
    private double maxCargoWeight;

    public CargoWagon(String registrationNumber, String destination, String owner, double tareWeight, WagonStatus status, double maxCargoWeight) {
        super(registrationNumber, destination, owner, tareWeight, status);
        this.maxCargoWeight = maxCargoWeight;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public double getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public double getCurrentCargoWeight() {
        return cargo == null ? 0 : cargo.getWeight();
    }

    public boolean isFragileCargo() {
        return cargo != null && cargo.isFragile();
    }

    public boolean isValuableCargo() {
        return cargo != null && cargo.isValuable();
    }

    @Override
    public String getRegistrationNumber() {
        return super.getRegistrationNumber();
    }

    @Override
    public String getDestination() {
        return super.getDestination();
    }

    @Override
    public void setDestination(String destination) {
        super.setDestination(destination);
    }

    @Override
    public String getOwner() {
        return super.getOwner();
    }

    @Override
    public void setOwner(String owner) {
        super.setOwner(owner);
    }

    @Override
    public WagonStatus getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(WagonStatus status) {
        super.setStatus(status);
    }

    @Override
    public double getTareWeight() {
        return super.getTareWeight();
    }

    @Override
    public void sendToDestination() {
        setStatus(WagonStatus.EN_ROUTE);
    }

    @Override
    public void service() {
        setStatus(WagonStatus.READY_FOR_DISPATCH);
    }

    @Override
    public void repair() {
        setStatus(WagonStatus.REPAIR);
    }

    @Override
    public void load() {
        setStatus(WagonStatus.LOADING);
    }

    @Override
    public void unload() {
        setStatus(WagonStatus.UNLOADING);
        cargo = null;
    }

    public void setCargo(Cargo cargo) {
        if (cargo != null && cargo.getWeight() > maxCargoWeight) {
            throw new IllegalArgumentException("вес груза превышает допустимую нагрузку");
        }
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", грузовой, макс. вес=" + maxCargoWeight + (cargo == null ? ", груз отсутствует" : ", " + cargo);
    }
}