import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookReport {
    public static void main(String[] args) throws IOException {

        AuthorDA authorDA = new AuthorDA();
        HashMap<String, Author> authorMap = authorDA.getAuthorMap();

        BookDA bookDA = new BookDA(authorMap);
        HashMap<String, Book> bookMap = bookDA.readBooks();

        for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
            Book book = entry.getValue();
            Author author = book.getAuthor();
            System.out.println(book.getIsbn() + " " + book.getTitle());
            System.out.println("\t" + author.getName() + " - " + author.getBio() + "\n");
        }
    }
}