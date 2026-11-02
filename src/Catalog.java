/**Глава 5 Вариант А:
 * 6) Создать класс Catalog с внутренним классом, с помощью объектов которо
 * го можно хранить информацию об истории выдач книги читателям.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String catalogName;
    private List<IssueRecord> records;

    public Catalog(String catalogName) {
        this.catalogName = catalogName;
        this.records = new ArrayList<>();
    }

    public String getCatalogName() {
        return catalogName;
    }

    public List<IssueRecord> getRecords() {
        return List.copyOf(records);
    }

    public IssueRecord registerIssue(String bookTitle, String readerName, LocalDate issueDate, LocalDate returnDate) {
        IssueRecord record = new IssueRecord(bookTitle, readerName, issueDate, returnDate);
        records.add(record);
        return record;
    }

    public List<IssueRecord> findIssuesByReader(String readerName) {
        List<IssueRecord> result = new ArrayList<>();
        for (IssueRecord record : records) {
            if (record.getReaderName().equals(readerName)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<IssueRecord> findActiveIssues() {
        List<IssueRecord> result = new ArrayList<>();
        for (IssueRecord record : records) {
            if (!record.isReturned()) {
                result.add(record);
            }
        }
        return result;
    }

    public class IssueRecord {
        private String bookTitle;
        private String readerName;
        private LocalDate issueDate;
        private LocalDate returnDate;

        public IssueRecord(String bookTitle, String readerName, LocalDate issueDate, LocalDate returnDate) {
            this.bookTitle = bookTitle;
            this.readerName = readerName;
            this.issueDate = issueDate;
            this.returnDate = returnDate;
        }

        public String getBookTitle() {
            return bookTitle;
        }

        public String getReaderName() {
            return readerName;
        }

        public LocalDate getIssueDate() {
            return issueDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public boolean isReturned() {
            return returnDate != null;
        }

        public String getCatalogName() {
            return catalogName;
        }

        @Override
        public String toString() {
            return "книга='" + bookTitle + '\'' + ", читатель='" + readerName + '\'' + ", выдана=" + issueDate + ", возвращена=" + (returnDate == null ? "нет" : returnDate);
        }
    }
}