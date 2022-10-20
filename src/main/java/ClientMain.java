import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("This is going to be the launching point of our application");
        Scanner myObj = new Scanner(System.in);



        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of items
            List<Items> items = Arrays.asList(mapper.readValue(Paths.get("src/resources/items.json").toFile(), Items[].class));

            // convert JSON array to list of locations
            List<Location> locations = List.of(mapper.readValue(Paths.get("src/resources/locations.json").toFile(),Location[].class));
            //Location loc = mapper.readValue(Paths.get("src/resources/locations.json").toFile(),Location.class);
            int currentLocationIndex = 0;

            /*
            // print items
            // items.forEach(System.out::println);

            // System.out.println("\n********************\n");
            // locations.forEach(System.out::println);
            */
            System.out.println("\n" + locations.get(currentLocationIndex).getName());
            System.out.println("\n" + locations.get(currentLocationIndex).getExit().getNorth());


            String test = myObj.nextLine();
            TextParser myTest = new TextParser(test, currentLocationIndex);
            test = myTest.getInput();
            currentLocationIndex = myTest.getIndex();

            System.out.printf("the string is: %s and the index is: %s",
                    test, currentLocationIndex);

            System.out.println("\n" + locations.get(currentLocationIndex).getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }
