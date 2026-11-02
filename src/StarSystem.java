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

public class StarSystem {
    private Star star;
    private final List<Planet> planets = new ArrayList<>();

    public StarSystem() {
    }

    public StarSystem(Star star) {
        this.star = star;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public boolean addPlanet(Planet planet) {
        if (planet == null) {
            return false;
        }
        return planets.add(planet);
    }

    public int countPlanets() {
        return planets.size();
    }

    public String getStarName() {
        return star == null ? "нет звезды" : star.getName();
    }

    public List<Planet> getPlanets() {
        return new ArrayList<>(planets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StarSystem that = (StarSystem) o;
        return Objects.equals(star, that.star)
                && Objects.equals(planets, that.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(star, planets);
    }

    @Override
    public String toString() {
        return "StarSystem{star=" + star + ", planets=" + planets + "}";
    }
}