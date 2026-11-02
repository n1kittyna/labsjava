/**Глава 5 Вариант А:
 * 6) Создать класс Catalog с внутренним классом, с помощью объектов которо
 * го можно хранить информацию об истории выдач книги читателям.
 */
import java.time.LocalDate;
import java.util.List;

public class CatalogMain {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("городская библиотека");

        catalog.registerIssue("война и мир", "иванов",
                LocalDate.of(2025, 1, 10), LocalDate.of(2025, 2, 10));
        catalog.registerIssue("преступление и наказание", "петров",
                LocalDate.of(2025, 2, 15), null);
        catalog.registerIssue("мастер и маргарита", "иванов",
                LocalDate.of(2025, 3, 1), null);

        System.out.println("каталог: " + catalog.getCatalogName());

        System.out.println("история выдач:");
        for (Catalog.IssueRecord record : catalog.getRecords()) {
            System.out.println(record);
        }

        System.out.println("выдачи читателя иванов:");
        List<Catalog.IssueRecord> ivanovIssues = catalog.findIssuesByReader("иванов");
        for (Catalog.IssueRecord record : ivanovIssues) {
            System.out.println(record);
        }

        System.out.println("книги на руках:");
        for (Catalog.IssueRecord record : catalog.findActiveIssues()) {
            System.out.println(record);
        }

        Catalog.IssueRecord directRecord = catalog.new IssueRecord(
                "анна каренина", "сидоров",
                LocalDate.of(2025, 4, 1), null);
        System.out.println("прямое создание внутреннего класса:");
        System.out.println(directRecord);
        System.out.println("каталог записи: " + directRecord.getCatalogName());
    }
}