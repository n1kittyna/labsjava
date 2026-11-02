/**Глава 3 Вариант С: 6)Определить класс Окружность на плоскости, координаты центра которой
 задаются с помощью Рациональной Дроби. Определить площадь и пери
 метр. Создать массив/список/множество объектов и определить группы
 окружностей, центры которых лежат на одной прямой. Определить наи
 больший и наименьший по площади (периметру) объект.*/

public class Rational {
    private final long numerator;
    private final long denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long getNumerator() { return numerator; }
    public long getDenominator() { return denominator; }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
