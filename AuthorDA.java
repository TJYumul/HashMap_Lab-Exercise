import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA {
    private HashMap<String, Author> authorMap;

    public AuthorDA() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src/Author.csv"));
        authorMap = new HashMap<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] data = line.split(",");
            if (data.length == 2) {
                String name = data[0].trim();
                String bio = data[1].trim();
                authorMap.put(name, new Author(name, bio));
            }
        }
    }

    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }
}