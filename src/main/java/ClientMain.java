import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("This is going to be the launching point of our application");


        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            List<Items> items = Arrays.asList(mapper.readValue(Paths.get("src/resources/items.json").toFile(), Items[].class));

            // print books
            items.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }
