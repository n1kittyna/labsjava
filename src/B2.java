/**Глава 2 Вариант В: 6) В системе счисления с некоторым основанием десятичное число
 81 записывается в виде 100. Найти это основание.*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class B2 {
    public static void main(String[] args){
        int x = 81;
        String y = "100";

        for(int base = 2; base <= 100; base ++){
            if(toBase(x,base).equals(y)){
                System.out.println("основание системы счисления: " + base);
            }
        }
        printDevInf();
    }
     static String toBase(int number, int base){
        if (number == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while (number>0){
            sb.append(number%base);
            number /= base;
        }
        return sb.reverse().toString();
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
