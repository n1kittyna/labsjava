/**Глава 8 Вариант C:
 6) Распаковать текст, сжатый по правилу из предыдущего задания.*/
public class UnpackMain {
    public static void main(String[] args) {
        String originalText = TextProcessMain2.SOURCE_TEXT;

        String packedText = pack(originalText);
        System.out.println("сжатый текст:");
        System.out.println(packedText);

        TextUnpacker unpacker = new TextUnpacker();
        System.out.println("\nраспакованный текст:");
        System.out.println(unpacker.unpack(packedText));
    }

    private static String pack(String text) {
        if (text == null || text.isEmpty()) return text;
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                result.append(text.charAt(i));
                if (count > 1) {
                    result.append("#").append(count);
                }
                count = 1;
            }
        }
        return result.toString();
    }
}