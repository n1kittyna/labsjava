// Задание 1 Вариант В: 6) Ввести с консоли n целых чисел. На консоль вывести: Простые числа
import java.util.Scanner;

public class Zadanie1B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите количество чисел: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("простые числа:");
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        scanner.close();
    }
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}