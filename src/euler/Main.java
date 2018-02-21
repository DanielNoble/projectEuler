package euler;


public class Main {

    public static void main(String[] args) {
        mult();
        fibonacci();
        prime();
        palindrome();
        evenlyDivisible();
    }

    private static void mult() { // problem 1
        int sum = 0;
        for (int i = 3; i < 1000; i++){
            if (i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        printAnswer(1, sum);
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

    private static void palindrome() { // problem 4
        int largest = 0;
        for (int i = 100; i < 1000; i++){
            for (int j = 100; j < 1000; j++){
                int value = i * j;
                String current = String.valueOf(value);
                if (value / 100000 > 0) {
                    if (current.charAt(5) == current.charAt(0) && current.charAt(4) == current.charAt(1) && current.charAt(3) == current.charAt(2) && value > largest) {
                        largest = value;
                    }
                }
            }
        }
        printAnswer(4, largest);
    }

    private static void evenlyDivisible(){ // problem 5
        long val = 21L;
        int num = 0;
        while (num==0) {
            boolean all = true;
            for (int i = 1; i < 21; i++) {
                all = true;
                if (val % i != 0)
                {
                    all = false;
                    break;
                }
            }
            if (all) {
                num = (int)val;
            }

            val++;
        }
        printAnswer(5,num);
    }

    private static void printAnswer(int problemNumber, Object answer) {
        System.out.printf("The answer to problem %d is %s\n", problemNumber, answer);
    }
}
