/**Глава 8 Вариант A:
 6) В зависимости от признака (0 или 1) в каждой строке текста удалить указан
 ный символ везде, где он встречается, или вставить его после k-гo символа.*/
public class TextProcessMainA {
    public static void main(String[] args) {
        TextProcessorA processor = new TextProcessorA();
        String line = "мама мыла раму";
        char symbol = 'а';
        int k = 3;

        System.out.println("исходная строка: " + line);
        System.out.println("режим 0 (удаление): " + processor.process(line, 0, symbol, k));
        System.out.println("режим 1 (вставка): " + processor.process(line, 1, symbol, k));
    }
}