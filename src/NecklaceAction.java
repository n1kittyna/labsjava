/**Глава 4 Вариант В:
 Создать консольное приложение, удовлетворяющее следующим требованиям:
 • Использовать возможности ООП: классы, наследование, полиморфизм, ин
 капсуляция.
 • Каждый класс должен иметь отражающее смысл название и информативный состав.
 • Наследование должно применяться только тогда, когда это имеет смысл.
 • При кодировании должны быть использованы соглашения об оформлении
 кода java code convention.
 • Классы должны быть грамотно разложены по пакетам.
 • Консольное меню должно быть минимальным.
 • Для хранения параметров инициализации можно использовать файлы.

 6) Камни. Определить иерархию драгоценных и полудрагоценных камней.
 Отобрать камни для ожерелья. Подсчитать общий вес (в каратах) и стоимость.
 Провести сортировку камней ожерелья на основе ценности. Найти камни
 в ожерелье, соответствующие заданному диапазону параметров прозрачности
 */
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NecklaceAction {
    public double calculateTotalWeight(List<Stone> necklace) {
        return necklace.stream().mapToDouble(Stone::getWeight).sum();
    }

    public double calculateTotalPrice(List<Stone> necklace) {
        return necklace.stream().mapToDouble(Stone::getPrice).sum();
    }

    public List<Stone> sortStonesByValue(List<Stone> necklace) {
        return necklace.stream()
                .sorted(Comparator.comparingDouble(Stone::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public List<Stone> findStonesByTransparencyRange(List<Stone> necklace,
                                                     double minTransparency,
                                                     double maxTransparency) {
        return necklace.stream()
                .filter(s -> s.getTransparency() >= minTransparency &&
                        s.getTransparency() <= maxTransparency)
                .collect(Collectors.toList());
    }
}