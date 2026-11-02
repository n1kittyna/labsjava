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

public class Star {
    private String name;
    private double mass;
    private String spectralClass;

    public Star() {
    }

    public Star(String name, double mass, String spectralClass) {
        this.name = name;
        this.mass = mass;
        this.spectralClass = spectralClass;
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

    public String getSpectralClass() {
        return spectralClass;
    }

    public void setSpectralClass(String spectralClass) {
        this.spectralClass = spectralClass;
    }

    public String describe() {
        return String.format("звезда %s класса %s массой %.3e кг",
                name, spectralClass, mass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Double.compare(star.mass, mass) == 0
                && Objects.equals(name, star.name)
                && Objects.equals(spectralClass, star.spectralClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mass, spectralClass);
    }

    @Override
    public String toString() {
        return "Star{name='" + name + "', mass=" + mass + ", spectralClass='" + spectralClass + "'}";
    }
}