/**Глава 8 Вариант A:
 6) В зависимости от признака (0 или 1) в каждой строке текста удалить указан
 ный символ везде, где он встречается, или вставить его после k-гo символа.*/
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public void processFile(Path input, Path output, int flag, char symbol, int k)
            throws IOException {
        List<String> lines = Files.readAllLines(input, StandardCharsets.UTF_8);
        TextProcessorA processor = new TextProcessorA();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(processor.process(line, flag, symbol, k));
        }
        Files.write(output, result, StandardCharsets.UTF_8);
    }
}
