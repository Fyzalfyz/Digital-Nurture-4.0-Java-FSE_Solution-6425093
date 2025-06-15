/**
 *
 * @author Fyzal
 */
import java.util.*;

class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " - " + author;
    }
}

public class LibraryManagementSystem {
    static List<Book> books = new ArrayList<>();

    public static void linearSearch(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Linear: " + b);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Found (Linear)");
        }
    }

    public static void binarySearch(String title) {
        books.sort(Comparator.comparing(b -> b.title.toLowerCase()));
        int low = 0, high = books.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Book b = books.get(mid);
            int cmp = b.title.compareToIgnoreCase(title);
            if (cmp == 0) {
                System.out.println("Binary: " + b);
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Not Found (Binary)");
    }

    public static void main(String[] args) {
        books.add(new Book("Book 1", "Harry Potter", "J.K. Rowling"));
        books.add(new Book("Book 2", "Ponniyin Selvan", "Kalki Krishnamurthy"));
        books.add(new Book("Book 3", "Thirukkural", "Thiruvalluvar"));
        books.add(new Book("Book 4", "Parthiban Kanavu", "Kalki Krishnamurthy"));
        books.add(new Book("Book 5", "Life of Pi", "Yann Martel"));

        linearSearch("Harry Potter");
        binarySearch("Thirukkural");
    }
}
