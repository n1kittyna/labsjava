/**Глава 7 Вариант А:
 6) Написать функциональный интерфейс с методом, который принимает три
 дробных числа: a, b, c и возвращает тоже дробное число. Написать реализа
 цию такого интерфейса в виде лямбда-выражения, которое возвращает дис
 криминант.*/
@FunctionalInterface
public interface DiscriminantCalculator {
    double calculate(double a, double b, double c);
}