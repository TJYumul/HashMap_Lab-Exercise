import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BookDA {
    private HashMap<String, Book> bookMap;
    private HashMap<String, Author> authorMap;

    public BookDA(HashMap<String, Author> authorMap) {
        this.authorMap = authorMap;
    }

    public HashMap<String, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(HashMap<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public HashMap<String, Book> readBooks() throws IOException {
        bookMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/Book.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) {
                String isbn = data[0].trim();
                String title = data[1].trim();
                String authorName = data[2].trim();

                Author author = authorMap.get(authorName);
                if (author == null) {
                    author = new Author(authorName, "");
                }

                Book book = new Book(isbn, title, author);
                bookMap.put(isbn, book);
            }
        }
        reader.close();
        return bookMap;
    }
}