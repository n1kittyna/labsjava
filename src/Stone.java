/**Глава 4 Вариант В:
 Создать консольное приложение, удовлетворяющее следующим требованиям:
 • Использовать возможности ООП: классы, наследование, полиморфизм, ин
 капсуляция.
 • Каждый класс должен иметь отражающее смысл название и информативный состав.
 • Наследование должно применяться только тогда, когда это имеет смысл.
 • При кодировании должны быть использованы соглашения об оформлении
 кода java code convention.
 • Классы должны быть грамотно разложены по пакетам.
 • Консольное меню должно быть минимальным.
 • Для хранения параметров инициализации можно использовать файлы.

 6) Камни. Определить иерархию драгоценных и полудрагоценных камней.
 Отобрать камни для ожерелья. Подсчитать общий вес (в каратах) и стоимость.
 Провести сортировку камней ожерелья на основе ценности. Найти камни
 в ожерелье, соответствующие заданному диапазону параметров прозрачности
 */
import java.util.Objects;

public abstract class Stone {
    private String name;
    private double weight;
    private double price;
    private double transparency;

    public Stone() {
    }

    public Stone(String name, double weight, double price, double transparency) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stone stone = (Stone) o;
        return Double.compare(stone.weight, weight) == 0 && Double.compare(stone.price, price) == 0 && Double.compare(stone.transparency, transparency) == 0 && Objects.equals(name, stone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price, transparency);
    }

    @Override
    public String toString() {
        return "Stone{" + "name='" + name + '\'' + ", weight=" + weight + ", price=" + price + ", transparency=" + transparency + '}';
    }
}