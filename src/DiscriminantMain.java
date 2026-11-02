/**Глава 7 Вариант А:
 6) Написать функциональный интерфейс с методом, который принимает три
 дробных числа: a, b, c и возвращает тоже дробное число. Написать реализа
 цию такого интерфейса в виде лямбда-выражения, которое возвращает дис
 криминант.*/
public class DiscriminantMain {

    public static void main(String[] args) {
        DiscriminantCalculator calculator = (a, b, c) -> b * b - 4 * a * c;

        double a = 1;
        double b = -5;
        double c = 6;

        double result = calculator.calculate(a, b, c);

        System.out.println("коэффициенты: a=" + a + ", b=" + b + ", c=" + c);
        System.out.println("дискриминант: " + result);

        printDiscriminant(calculator, a, b, c);
    }

    public static void printDiscriminant(DiscriminantCalculator calculator, double a, double b, double c) {
        System.out.println("дискриминант из метода: " + calculator.calculate(a, b, c));
    }
}