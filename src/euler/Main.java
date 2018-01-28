package euler;


public class Main {

    public static void main(String[] args) {
        prime();
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
        System.out.println(num);
    }
}
