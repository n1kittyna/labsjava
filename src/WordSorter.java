/**Глава 8 Вариант B:
 6) Создать программу обработки текста учебника по программированию с ис
 пользованием классов: Символ, Слово, Предложение, Абзац, Лексема, Листинг,
 Знак препинания и др. Во всех задачах с формированием текста заменять табу ляции и последовательности пробелов одним пробелом.
 Предварительно текст следует разобрать на составные части, выполнить
 одно из перечисленных ниже заданий и вывести полученный результат.
 Напечатать слова текста в алфавитном порядке по первой букве.
 Слова, начинающиеся с новой буквы, печатать с красной строки.*/
import java.util.List;

public class WordSorter {
    private static final String RED_LINE = "    ";

    public String sortAndFormat(List<Word> words) {
        List<Word> sorted = words.stream().sorted().toList();
        StringBuilder result = new StringBuilder();
        Character previousFirst = null;

        for (Word word : sorted) {
            char currentFirst = word.getFirstLetter();
            if (previousFirst == null || currentFirst != previousFirst) {
                if (previousFirst != null) result.append('\n');
                result.append(RED_LINE);
                previousFirst = currentFirst;
            } else {
                result.append(' ');
            }
            result.append(word.getValue());
        }
        result.append('\n');
        return result.toString();
    }
}