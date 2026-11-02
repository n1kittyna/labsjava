/**Глава 8 Вариант C:
 6) Распаковать текст, сжатый по правилу из предыдущего задания.*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUnpacker {
    private static final Pattern TOKEN = Pattern.compile("#(\\d+)");

    public String unpack(String packed) {
        if (packed == null) return null;
        StringBuilder result = new StringBuilder();
        Matcher matcher = TOKEN.matcher(packed);
        int lastIndex = 0;

        while (matcher.find()) {
            result.append(packed, lastIndex, matcher.start());
            int count = Integer.parseInt(matcher.group(1));
            if (result.length() > 0) {
                char symbol = result.charAt(result.length() - 1);
                for (int i = 1; i < count; i++) {
                    result.append(symbol);
                }
            }
            lastIndex = matcher.end();
        }
        result.append(packed, lastIndex, packed.length());
        return result.toString();
    }
}
