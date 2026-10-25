public class Calculator {

    public static void main(String[] args) {

        SimpleCalculator add = (num) -> {
            int total = 0;
            for (int i : num) {
                total += i;
            }
            return total;
        };

        System.out.println(add.calculate(2, 3, 4, 5));


        SimpleCalculator sub = (sum) -> {
            int total = 0;
            for (int i = 0; i < sum.length - 1; i++) {
                total += sum[i] - sum[i+1];
            }
            return total;
            };

        System.out.println(sub.calculate(20, 10, 5, 1));

    }
}


@FunctionalInterface
interface SimpleCalculator {

    int calculate(int... num);
}

