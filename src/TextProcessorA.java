/**Глава 8 Вариант A:
 6) В зависимости от признака (0 или 1) в каждой строке текста удалить указан
 ный символ везде, где он встречается, или вставить его после k-гo символа.*/
public class TextProcessorA {
    public String process(String line, int flag, char symbol, int k) {
        if (line == null) return null;
        return switch (flag) {
            case 0 -> line.replace(String.valueOf(symbol), "");
            case 1 -> insertSymbol(line, symbol, k);
            default -> throw new IllegalArgumentException("некорректный признак: " + flag);
        };
    }

    private String insertSymbol(String line, char symbol, int k) {
        if (k < 1 || k > line.length()) return line;
        StringBuilder builder = new StringBuilder(line);
        builder.insert(k, symbol);
        return builder.toString();
    }
}
