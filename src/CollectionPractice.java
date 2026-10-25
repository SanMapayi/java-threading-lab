import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionPractice {


    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 15)
                .boxed().collect(Collectors.toList());

        Iterator<Integer> it = integerList.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0 ) {
                it.remove();
            }
        }

        System.out.println(integerList.subList(6, Math.min(9, integerList.size())));


//
//        int chuckSize = 3;
//        List<Integer> listToBeAdded;
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i = 0; i <integerList.size() ; i +=chuckSize) {
//            System.out.println(i);
//            listToBeAdded = integerList.subList(i , Math.min(chuckSize + i, integerList.size()));
//            System.out.println(listToBeAdded);
//            lists.add(listToBeAdded);
//        }
//
//        System.out.println(lists);


       var listOfRandom = new Random().ints(1, 10)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(listOfRandom);

        Map<Integer, Integer> findDuplicate = new HashMap<>();

       var listUsingGroup = listOfRandom.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        n -> 1,
                        (o,  n) -> o + n
                ));

       listUsingGroup.entrySet().forEach(System.out::println);


//        listOfRandom.forEach(
//                n -> {
//                    findDuplicate.merge(n, 1, (oldValue, newValue) -> oldValue + newValue);
//                }
//        );
//
//        findDuplicate.entrySet()
//                .forEach(System.out::println);
    }
}