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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Planet {
    private String name;
    private double mass;
    private final List<Moon> moons = new ArrayList<>();

    public Planet() {
    }

    public Planet(String name, double mass) {
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

    public List<Moon> getMoons() {
        return new ArrayList<>(moons);
    }

    public boolean addMoon(Moon moon) {
        if (moon == null) {
            return false;
        }
        return moons.add(moon);
    }

    public String describe() {
        StringJoiner joiner = new StringJoiner(", ",
                String.format("планета %s массой %.3e кг, спутники: ", name, mass), "");
        if (moons.isEmpty()) {
            joiner.add("нет");
        } else {
            for (Moon m : moons) {
                joiner.add(m.getName());
            }
        }
        return joiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Double.compare(planet.mass, mass) == 0 && Objects.equals(name, planet.name) && Objects.equals(moons, planet.moons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mass, moons);
    }

    @Override
    public String toString() {
        return "Planet{name='" + name + "', mass=" + mass + ", moons=" + moons + "}";
    }
}