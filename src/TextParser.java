/**Глава 8 Вариант B:
 6) Создать программу обработки текста учебника по программированию с ис
 пользованием классов: Символ, Слово, Предложение, Абзац, Лексема, Листинг,
 Знак препинания и др. Во всех задачах с формированием текста заменять табу ляции и последовательности пробелов одним пробелом.
 Предварительно текст следует разобрать на составные части, выполнить
 одно из перечисленных ниже заданий и вывести полученный результат.
 Напечатать слова текста в алфавитном порядке по первой букве.
 Слова, начинающиеся с новой буквы, печатать с красной строки.*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final Pattern NORMALIZE = Pattern.compile("\\s+");
    private static final Pattern SENTENCE_SPLIT = Pattern.compile("(?<=[.!?])\\s+");
    private static final Pattern WORD = Pattern.compile("[\\p{L}-]+");

    public Text parse(String source) {
        Text text = new Text();
        String normalized = NORMALIZE.matcher(source).replaceAll(" ").strip();
        String[] paragraphStrings = normalized.split("\\n\\s*\\n|\\n");

        for (String paragraphString : paragraphStrings) {
            Paragraph paragraph = new Paragraph();
            String[] sentenceStrings = SENTENCE_SPLIT.split(paragraphString.strip());
            for (String sentenceString : sentenceStrings) {
                if (sentenceString.isBlank()) continue;
                Sentence sentence = new Sentence();
                Matcher matcher = WORD.matcher(sentenceString);
                while (matcher.find()) {
                    sentence.addWord(new Word(matcher.group()));
                }
                paragraph.addSentence(sentence);
            }
            if (!paragraph.getSentences().isEmpty()) {
                text.addParagraph(paragraph);
            }
        }
        return text;
    }
}