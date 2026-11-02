/**Глава 8 Вариант B:
 6) Создать программу обработки текста учебника по программированию с ис
 пользованием классов: Символ, Слово, Предложение, Абзац, Лексема, Листинг,
 Знак препинания и др. Во всех задачах с формированием текста заменять табу ляции и последовательности пробелов одним пробелом.
 Предварительно текст следует разобрать на составные части, выполнить
 одно из перечисленных ниже заданий и вывести полученный результат.
 Напечатать слова текста в алфавитном порядке по первой букве.
 Слова, начинающиеся с новой буквы, печатать с красной строки.*/
import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private final List<Word> words = new ArrayList<>();
    private final List<PunctuationMark> marks = new ArrayList<>();
    public void addWord(Word word) { words.add(word); }
    public void addPunctuationMark(PunctuationMark mark) { marks.add(mark); }
    public List<Word> getWords() { return words; }
}