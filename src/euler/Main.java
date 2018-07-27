public class Euler {
	public static void main(String[] args) {
		one();
		two();
		three();
		four();
		// five();
		six();
		seven();
		eight();
		nine();
		ten();
	}
	
	public static void one() { // Multiples of 3 and 5
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		printAnswer(1, sum);
	}
	
	public static void two() { // Even fibonacci numbers
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
	
	private static void three(){ // Largest prime factor
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

    private static void four() { // Largest palindrome product of two three digit numbers
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

    // private static void five(){ // smallest multiple of 1-20
        // long val = 21L;
        // int num = 0;
        // while (num==0) {
            // boolean all = true;
            // for (int i = 1; i < 21; i++) {
                // all = true;
                // if (val % i != 0)
                // {
                    // all = false;
                    // break;
                // }
            // }
            // if (all) {
                // num = (int)val;
            // }

            // val++;
        // }
        // printAnswer(5,num);
    // }
    
    private static void six(){ // Difference between sum of squares and square of sums from numbers 1-100
    	int sumOfSquares = 0;
    	int sum = 0;
    	int diff = 0;
    	
    	for (int i = 1; i <= 100; i++){
    		sumOfSquares += i * i;
    	}
    	
    	for (int i = 1; i <= 100; i++){
    		sum += i;
    	}
    	
    	diff = sum * sum - sumOfSquares;
    	
    	printAnswer(6, diff);
    }
	
	private static void seven() { // 10001st prime
		int numPrimes = 0;
		int num = 0;
		while (numPrimes < 10001) {
			num++;
			if (isPrime(num)) {
				numPrimes++;
			}
		}
		
		printAnswer(7, num);
	}

		private static boolean isPrime(int num) { // Problem 7 10 helper method
			if (num < 2) return false;
			if (num == 2) return true;
			if (num % 2 == 0) return false;
			for (int i = 3; i * i <= num; i += 2)
				if (num % i == 0) return false;
			return true;
		}
		
	private static void eight() { // Largest product of thirteen consecutive digits in thousand digit number below
		String thousand = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        long biggestProduct = 0;

        for (int i = 0; i < thousand.length() - 13; i ++) {
            long product = 1;

            for (int j = i; j < i + 13; j++) {
                product *= Integer.parseInt(thousand.substring(j, j + 1));
            }
            if (product > biggestProduct) biggestProduct = product;
        }
		
		printAnswer(8, biggestProduct);
	}
	
	public static void nine() { // product of a, b, c in pythagorean triple whose sum is 1000
		int answer = 0;
		outerLoop:
		for (int a = 1; a < 1000; a++) {
			
			for (int b = a + 1; b < 1000; b++) {
				
				double cSquared = a * a + b * b;
				double c = Math.sqrt(cSquared);
				if (a + b + c == 1000) {
					answer = a * b * (int)c;
					break outerLoop;
				}
			}
		}
		printAnswer(9, answer);
	}
	
	public static void ten() {
		long sum = 0;
		for (long i = 1L; i < 2000000L; i++) {
			if (isPrime10(i)) {
				sum += i;
			}
		}
		
		printAnswer(10, sum);
	}
	
		private static boolean isPrime10(long num) { // Problem 7 10 helper method
				if (num < 2L) return false;
				if (num == 2L) return true;
				if (num % 2L == 0) return false;
				for (long i = 3L; i * i <= num; i += 2L)
					if (num % i == 0L) return false;
				return true;
		}
	
	private static void printAnswer(int problemNumber, Object answer) {
        System.out.printf("The answer to problem %d is %s\n", problemNumber, answer);
    }
}
