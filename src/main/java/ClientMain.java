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

            // convert JSON array to list of items
            List<Items> items = Arrays.asList(mapper.readValue(Paths.get("src/resources/items.json").toFile(), Items[].class));

            // convert JSON array to list of locations
            List<Location> locations = List.of(mapper.readValue(Paths.get("src/resources/locations.json").toFile(),Location[].class));
            //Location loc = mapper.readValue(Paths.get("src/resources/locations.json").toFile(),Location.class);


            // print items
            items.forEach(System.out::println);

            System.out.println("\n********************\n");
            locations.forEach(System.out::println);
            System.out.println("\n" + locations.get(0).getName());
            System.out.println("\n" + locations.get(0).getExit().getNorth());




        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }
