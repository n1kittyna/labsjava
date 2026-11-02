// Задание 1 Вариант А: 6) Вывести фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Zadanie1A {
    public static void main(String[] args) {
        String DevName = "Никитина";
        LocalDateTime receivedDate = LocalDateTime.of(2026, 10, 29, 17, 0, 0);
        LocalDateTime submissionDate = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("фамилия разработчика: " + DevName);
        System.out.println("дата и время получения задания: " + receivedDate.format(formatter));
        System.out.println("дата и время сдачи задания: " + submissionDate.format(formatter));
    }
}