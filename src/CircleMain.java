import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CircleMain {
    public static void main(String[] args) {
        List<Circle> circles = List.of(
                new Circle(new Rational(1, 1), new Rational(1, 1), new Rational(5, 1)),
                new Circle(new Rational(2, 1), new Rational(2, 1), new Rational(3, 1)),
                new Circle(new Rational(3, 1), new Rational(3, 1), new Rational(4, 1)),
                new Circle(new Rational(10, 1), new Rational(1, 1), new Rational(1, 1))
        );

        CircleAction action = new CircleAction();

        for (int i = 0; i < circles.size(); i++) {
            System.out.println("окружность " + (i + 1) + ": " + circles.get(i).describe());
        }

        Optional<Circle> maxArea = action.findMaxArea(circles);
        maxArea.ifPresent(c -> System.out.println("\nнаибольшая площадь у " + c.describe()));

        Optional<Circle> minPerim = action.findMinPerimeter(circles);
        minPerim.ifPresent(c -> System.out.println("наименьший периметр у " + c.describe()));

        List<List<Circle>> groups = action.findCollinearGroups(circles);
        if (groups.isEmpty()) {
            System.out.println("\nгрупп окружностей на одной прямой не найдено");
        } else {
            System.out.println("\nгруппы окружностей, центры которых лежат на одной прямой:");
            for (int i = 0; i < groups.size(); i++) {
                System.out.println("группа " + (i + 1) + ":");
                for (Circle c : groups.get(i)) {
                    int idx = circles.indexOf(c) + 1;
                    System.out.println("  окружность " + idx + ": " + c.describe());
                }
            }
        }
    }
}