package euler;


public class Main {

    public static void main(String[] args) {
        fibonacci();
        prime();
    }

    private static void fibonacci() { // problem 2
        int previous1 = 2;
        int previous2 = 1;
        int current = previous1 + previous2;
        int sum = 2;
        final int MAX = 4000000;
        for (; current <= MAX; ) {
            if (current % 2 == 0) {
                sum += current;
            }
            current = previous1 + previous2;
            previous2 = previous1;
            previous1 = current;

        }

        printAnswer(2, sum);
    }

    private static void prime(){ // problem 3
        long num = 125L;
        long max = (long)Math.floor(Math.sqrt((double)num));

        for(long i = 3; i <= max;){
            if (i != num && num % i == 0){
                num /= i;
            } else {
                i += 2;
            }
        }
        printAnswer(3, num);
    }

    private static void printAnswer(int problemNumber, Object answer) {
        System.out.printf("The answer to problem %d is %s\n", problemNumber, answer);
    }
}
