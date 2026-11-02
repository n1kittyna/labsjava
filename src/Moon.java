/**Глава 4 Вариант A
 Создать приложение, удовлетворяющее требованиям, приведенным в зада
 нии. Наследование применять только в тех заданиях, в которых это логически
 обосновано. Аргументировать принадлежность классу каждого создаваемого
 метода и корректно переопределить для каждого класса методы equals(),
 hashCode(), toString().

 6)Создать объект класса Звездная система, используя классы Планета,
 Звезда, Луна. Методы: вывести на консоль количество планет в звездной
 системе, название звезды, добавление планеты в систему.
 */
import java.util.Objects;

public class Moon {
    private String name;
    private double mass;

    public Moon() {
    }

    public Moon(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String describe() {
        return String.format("луна %s массой %.3e кг", name, mass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moon moon = (Moon) o;
        return Double.compare(moon.mass, mass) == 0
                && Objects.equals(name, moon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mass);
    }

    @Override
    public String toString() {
        return "Moon{name='" + name + "', mass=" + mass + "}";
    }
}