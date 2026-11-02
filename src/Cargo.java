/**Глава 6 Вариант А6
 6) Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
 Вагон. Возможности: получить или изменить различную информацию
 о вагоне: регистрационный номер вагона, пункт назначения, владелец, ста
 тус (загрузка, разгрузка, в пути, в ремонте, готов к отправке, требуется ре
 монт); узнать снаряженную массу; отправить в пункт назначения; обслу
 жить; отремонтировать; загрузить; разгрузить; узнать хрупкость/ценность
 груза. Добавить дополнительные возможности для грузового и пассажир
 ского вагонов.*/
public class Cargo {
    private String name;
    private boolean fragile;
    private boolean valuable;
    private double weight;

    public Cargo(String name, boolean fragile, boolean valuable, double weight) {
        this.name = name;
        this.fragile = fragile;
        this.valuable = valuable;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isFragile() {
        return fragile;
    }

    public boolean isValuable() {
        return valuable;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "груз='" + name + '\'' + ", хрупкий=" + fragile + ", ценный=" + valuable + ", вес=" + weight;
    }
}