/**Глава 2 вариант А: 6) Найти число, цифры в котором идут в строгом порядке возрастания.
 Если таких чисел несколько, найти первое из них.*/
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class A2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите количество чисел: ");
        int n = scanner.nextInt();

        String[] numbers = new String[n];
        System.out.println("введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }

        String result = null;

        /*Поиск первого числа с возрастающими цифрами*/

        for (String numStr : numbers) {
            boolean isAscending = true;

            for (int i = 0; i < numStr.length() - 1; i++) {
                if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                    isAscending = false;
                    break;
                }
            }

            if (isAscending) {
                result = numStr;
                break;
            }
        }

        if (result != null) {
            System.out.println("число с возрастающими цифрами: " + result);
        } else {
            System.out.println("чисел с возрастающими цифрами нет");
        }

        printDevInf();
        scanner.close();
    }
    private static void printDevInf() {
        String DevName = "Никитина";
        LocalDateTime receivedDate = LocalDateTime.of(2026, 10, 29, 17, 0, 0);
        LocalDateTime submissionDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("фамилия разработчика: " + DevName);
        System.out.println("дата и время получения задания: " + receivedDate.format(formatter));
        System.out.println("дата и время сдачи задания: " + submissionDate.format(formatter));
    }
}