import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyName {

    public static void main(String[] args) {


        List<String> names = List.of("Mango", "Orange", "Mango", "PawPaw", "Orange", "Orange") ;

        var namesCount =
                names.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));

        System.out.println(namesCount);

        int[] array1 = new int[] {1, 2, 5, 6, 7};
        int[] array2 = new int[] {5, 3, 3, 10, 2};

       var array =  Stream.concat(
                Arrays.stream(array1).boxed(),
                Arrays.stream(array2).boxed()
        ).sorted()
                       .mapToInt(i -> i)
                               .toArray();

        System.out.println(Arrays.toString(array));

        IntStream
                .range(1, array.length)
                .map(i -> array[array.length -1-i]);
        System.out.println(Arrays.toString(array));


    }
}
