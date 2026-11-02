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
import java.util.List;
import java.util.Scanner;

public class StarSystemMain {

    public static void main(String[] args) {
        Star sun = new Star("Солнце", 1.989e30, "G2V");
        StarSystem system = new StarSystem(sun);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("система создана. Звезда: " + system.getStarName());

            while (true) {
                System.out.print("\nдобавить планету? (да/нет): ");
                String answer = scanner.nextLine().trim();

                if (answer.equalsIgnoreCase("нет")) {
                    break;
                }
                if (!answer.equalsIgnoreCase("да")) {
                    System.out.println("введите 'да' или 'нет'.");
                    continue;
                }

                System.out.print("введите название планеты: ");
                String planetName = scanner.nextLine().trim();
                if (planetName.isEmpty()) {
                    System.out.println("название не может быть пустым.");
                    continue;
                }

                double planetMass = readDouble(scanner,
                        "введите массу планеты (кг): ");

                Planet planet = new Planet(planetName, planetMass);

                System.out.print("добавить спутник для планеты " + planetName + "? (да/нет): ");
                String ansMoon = scanner.nextLine().trim();

                if (ansMoon.equalsIgnoreCase("да")) {
                    System.out.print("введите название спутника: ");
                    String moonName = scanner.nextLine().trim();
                    if (moonName.isEmpty()) {
                        System.out.println("название спутника пустое");
                    } else {
                        double moonMass = readDouble(scanner,
                                "введите массу спутника (кг): ");
                        planet.addMoon(new Moon(moonName, moonMass));
                    }
                }

                system.addPlanet(planet);
                System.out.println("планета добавлена.");
            }
        }

        System.out.println("звезда в системе: " + system.getStarName());
        System.out.println("количество планет в системе: " + system.countPlanets());

        List<Planet> planets = system.getPlanets();
        if (!planets.isEmpty()) {
            System.out.println("\nвсе планеты системы:");
            for (Planet p : planets) {
                System.out.println("  " + p.describe());
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("неправильный формат числа, установлено значение 0.");
            return 0;
        }
    }
}