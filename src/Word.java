/**Глава 8 Вариант B:
 6) Создать программу обработки текста учебника по программированию с ис
 пользованием классов: Символ, Слово, Предложение, Абзац, Лексема, Листинг,
 Знак препинания и др. Во всех задачах с формированием текста заменять табу ляции и последовательности пробелов одним пробелом.
 Предварительно текст следует разобрать на составные части, выполнить
 одно из перечисленных ниже заданий и вывести полученный результат.
 Напечатать слова текста в алфавитном порядке по первой букве.
 Слова, начинающиеся с новой буквы, печатать с красной строки.*/
public class Word implements Comparable<Word> {
    private final String value;
    public Word(String value) { this.value = value; }
    public String getValue() { return value; }
    public char getFirstLetter() { return Character.toLowerCase(value.charAt(0)); }
    @Override
    public int compareTo(Word other) {
        int byFirst = Character.compare(this.getFirstLetter(), other.getFirstLetter());
        if (byFirst != 0) return byFirst;
        return this.value.compareToIgnoreCase(other.value);
    }
}