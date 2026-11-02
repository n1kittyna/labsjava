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
import java.util.List;

public class StoneMain {
    public static void main(String[] args) {
        NecklaceCreator creator = new NecklaceCreator();
        List<Stone> necklace = creator.createNecklace();

        NecklaceAction action = new NecklaceAction();

        double totalWeight = action.calculateTotalWeight(necklace);
        double totalPrice = action.calculateTotalPrice(necklace);

        System.out.println("общий вес ожерелья: " + totalWeight + " карат");
        System.out.println("общая стоимость ожерелья: " + totalPrice);

        System.out.println("камни, отсортированные по ценности:");
        List<Stone> sortedStones = action.sortStonesByValue(necklace);
        for (Stone stone : sortedStones) {
            System.out.println(stone.getName() + " - цена: " + stone.getPrice());
        }

        double minRange = 0.85;
        double maxRange = 0.96;
        System.out.println("камни с прозрачностью в диапазоне [" + minRange + ", " + maxRange + "]:");
        List<Stone> foundStones = action.findStonesByTransparencyRange(necklace, minRange, maxRange);
        for (Stone stone : foundStones) {
            System.out.println(stone.getName() + " - прозрачность: " + stone.getTransparency());
        }
    }
}