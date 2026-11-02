/**Глава 3 Вариант С: 6)Определить класс Окружность на плоскости, координаты центра которой
 задаются с помощью Рациональной Дроби. Определить площадь и пери
 метр. Создать массив/список/множество объектов и определить группы
 окружностей, центры которых лежат на одной прямой. Определить наи
 больший и наименьший по площади (периметру) объект.*/
import java.util.*;

public class CircleAction {

    public Optional<Circle> findMaxArea(List<Circle> circles) {
        return circles.stream().max(Comparator.comparingDouble(Circle::area));
    }

    public Optional<Circle> findMinPerimeter(List<Circle> circles) {
        return circles.stream().min(Comparator.comparingDouble(Circle::perimeter));
    }

    public List<List<Circle>> findCollinearGroups(List<Circle> circles) {
        List<List<Circle>> result = new ArrayList<>();
        Set<String> foundLines = new HashSet<>();

        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                Circle c1 = circles.get(i);
                Circle c2 = circles.get(j);

                List<Circle> group = new ArrayList<>();
                group.add(c1);
                group.add(c2);

                for (int k = j + 1; k < circles.size(); k++) {
                    Circle c3 = circles.get(k);
                    if (isCollinear(c1, c2, c3)) {
                        group.add(c3);
                    }
                }

                if (group.size() >= 3) {
                    String key = c1.getCenterX() + ":" + c1.getCenterY() + "|" +
                            c2.getCenterX() + ":" + c2.getCenterY();
                    if (!foundLines.contains(key)) {
                        foundLines.add(key);
                        result.add(group);
                    }
                }
            }
        }
        return result;
    }

    private boolean isCollinear(Circle a, Circle b, Circle c) {
        double x1 = (double) a.getCenterX().getNumerator() / a.getCenterX().getDenominator();
        double y1 = (double) a.getCenterY().getNumerator() / a.getCenterY().getDenominator();
        double x2 = (double) b.getCenterX().getNumerator() / b.getCenterX().getDenominator();
        double y2 = (double) b.getCenterY().getNumerator() / b.getCenterY().getDenominator();
        double x3 = (double) c.getCenterX().getNumerator() / c.getCenterX().getDenominator();
        double y3 = (double) c.getCenterY().getNumerator() / c.getCenterY().getDenominator();

        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) < 1e-9;
    }
}