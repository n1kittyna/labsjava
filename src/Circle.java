/**Глава 3 Вариант С: 6)Определить класс Окружность на плоскости, координаты центра которой
 задаются с помощью Рациональной Дроби. Определить площадь и пери
 метр. Создать массив/список/множество объектов и определить группы
 окружностей, центры которых лежат на одной прямой. Определить наи
 больший и наименьший по площади (периметру) объект.*/
import java.util.StringJoiner;

public class Circle {
    private Rational centerX;
    private Rational centerY;
    private Rational radius;

    public Circle() {
        this(new Rational(), new Rational(), new Rational(1, 1));
    }

    public Circle(Rational centerX, Rational centerY, Rational radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public Rational getCenterX() { return centerX; }
    public Rational getCenterY() { return centerY; }
    public Rational getRadius() { return radius; }

    private double toDouble(Rational r) {
        return (double) r.getNumerator() / r.getDenominator();
    }

    public double area() {
        double r = toDouble(radius);
        return Math.PI * r * r;
    }

    public double perimeter() {
        double r = toDouble(radius);
        return 2 * Math.PI * r;
    }

    public String describe() {
        return String.format(" центр %s; %s, радиус %s, площадь %.2f, периметр %.2f",
                centerX, centerY, radius, area(), perimeter());
    }
}