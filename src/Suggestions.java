import java.util.NavigableSet;
import java.util.TreeSet;

public class Suggestions {


    public static void main(String[] args) {


        TreeSet<String> productName = new TreeSet<>();
        productName.add("Blueberry");
        productName.add("BlueBird");
        productName.add("AngryBird");
        productName.add("BlueLights");

        String typedIn = "A";

        NavigableSet<String> suggestions = productName.subSet(typedIn, true,
                typedIn + Character.MAX_VALUE, true);

        System.out.println(suggestions);
    }
}
