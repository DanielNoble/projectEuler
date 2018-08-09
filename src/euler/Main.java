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
		//ten();
		eleven();
		twelve();
		thirteen();
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
	
	private static void eleven() { // largest product of 4 adjacent numbers in fat grid
		int grid [][] = {
		        {8,02,22,97,38,15,00,40,00,75,04,05,07,78,52,12,50,77,91,8},
		        {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,04,56,62,00},
		        {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,03,49,13,36,65},
		        {52,70,95,23,04,60,11,42,69,24,68,56,01,32,56,71,37,02,36,91},
		        {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
		        {24,47,32,60,99,03,45,02,44,75,33,53,78,36,84,20,35,17,12,50},
		        {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
		        {67,26,20,68,02,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
		        {24,55,58,05,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
		        {21,36,23,9,75,00,76,44,20,45,35,14,00,61,33,97,34,31,33,95},
		        {78,17,53,28,22,75,31,67,15,94,03,80,04,62,16,14,9,53,56,92},
		        {16,39,05,42,96,35,31,47,55,58,88,24,00,17,54,24,36,29,85,57},
		        {86,56,00,48,35,71,89,07,05,44,44,37,44,60,21,58,51,54,17,58},
		        {19,80,81,68,05,94,47,69,28,73,92,13,86,52,17,77,04,89,55,40},
		        {04,52,8,83,97,35,99,16,07,97,57,32,16,26,26,79,33,27,98,66},
		        {88,36,68,87,57,62,20,72,03,46,33,67,46,55,12,32,63,93,53,69},
		        {04,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
		        {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,04,36,16},
		        {20,73,35,29,78,31,90,01,74,31,49,71,48,86,81,16,23,57,05,54},
		        {01,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48}};
		int biggest = 0;
		for (int i = 0; i < 17; i++) { // outer for loop for all vertical possibilities
			for (int j = 0; j < 20; j++) {
				int current = grid[i][j];
				for (int k = 1; k < 4; k++) {
					current *= grid[i + k][j];
				}
				if (current > biggest)
					biggest = current;
			}
		}
		
		for (int i = 0; i < 20; i++) { // outer for loop for all horizontal possibilities
			for (int j = 0; j < 17; j++) {
				int current = grid[i][j];
				for (int k = 1; k < 4; k++) {
					current *= grid[i][j + k];
				}
				if (current > biggest)
					biggest = current;
			}
		}
		
		for (int i = 0; i < 17; i++) { // outer for loop for all diagonal possibilities descending southeast
			for (int j = 0; j < 17; j++) {
				int current = grid[i][j];
				for (int k = 1; k < 4; k++) {
					current *= grid[i + k][j + k];
				}
				if (current > biggest)
					biggest = current;
			}
		}
		
		for (int i = 0; i < 17; i++) { // outer for loop for all horizontal possibilities
			for (int j = 19; j > 2; j--) {
				int current = grid[i][j];
				for (int k = 1; k < 4; k++) {
					current *= grid[i + k][j - k];
				}
				if (current > biggest)
					biggest = current;
			}
		}
		
		printAnswer(11, biggest);
	}
	
//	private static void twelve() { // first triangle number with over 500 divisors, commented because took 27 minutes to run
//		Long triangleNum = 0L;
//		Long fnal = 0L;
//		int numDivs = 0;
//		
//		for (Long nat = 1L; fnal == 0L; nat++) {
//			numDivs = 0;
//			triangleNum += nat;
//			for (Long div = 1L; div < triangleNum / 2; div++) {
//				if (triangleNum % div == 0 && numDivs <= 500)
//					numDivs++;
//			}
//			if (numDivs > 500)
//				fnal = triangleNum;
//		}
//		
//		printAnswer(12, fnal);
//	}
	
	private static void thirteen() { // sum of first ten digits of 100 50-digit numbers
		String[] arr = { "37107287533902102798797998220837590246510135740250",
				"46376937677490009712648124896970078050417018260538",
				"74324986199524741059474233309513058123726617309629",
				"91942213363574161572522430563301811072406154908250",
				"23067588207539346171171980310421047513778063246676",
				"89261670696623633820136378418383684178734361726757",
				"28112879812849979408065481931592621691275889832738",
				"44274228917432520321923589422876796487670272189318",
				"47451445736001306439091167216856844588711603153276",
				"70386486105843025439939619828917593665686757934951",
				"62176457141856560629502157223196586755079324193331",
				"64906352462741904929101432445813822663347944758178",
				"92575867718337217661963751590579239728245598838407",
				"58203565325359399008402633568948830189458628227828",
				"80181199384826282014278194139940567587151170094390",
				"35398664372827112653829987240784473053190104293586",
				"86515506006295864861532075273371959191420517255829",
				"71693888707715466499115593487603532921714970056938",
				"54370070576826684624621495650076471787294438377604",
				"53282654108756828443191190634694037855217779295145",
				"36123272525000296071075082563815656710885258350721",
				"45876576172410976447339110607218265236877223636045",
				"17423706905851860660448207621209813287860733969412",
				"81142660418086830619328460811191061556940512689692",
				"51934325451728388641918047049293215058642563049483",
				"62467221648435076201727918039944693004732956340691",
				"15732444386908125794514089057706229429197107928209",
				"55037687525678773091862540744969844508330393682126",
				"18336384825330154686196124348767681297534375946515",
				"80386287592878490201521685554828717201219257766954",
				"78182833757993103614740356856449095527097864797581",
				"16726320100436897842553539920931837441497806860984",
				"48403098129077791799088218795327364475675590848030",
				"87086987551392711854517078544161852424320693150332",
				"59959406895756536782107074926966537676326235447210",
				"69793950679652694742597709739166693763042633987085",
				"41052684708299085211399427365734116182760315001271",
				"65378607361501080857009149939512557028198746004375",
				"35829035317434717326932123578154982629742552737307",
				"94953759765105305946966067683156574377167401875275",
				"88902802571733229619176668713819931811048770190271",
				"25267680276078003013678680992525463401061632866526",
				"36270218540497705585629946580636237993140746255962",
				"24074486908231174977792365466257246923322810917141",
				"91430288197103288597806669760892938638285025333403",
				"34413065578016127815921815005561868836468420090470",
				"23053081172816430487623791969842487255036638784583",
				"11487696932154902810424020138335124462181441773470",
				"63783299490636259666498587618221225225512486764533",
				"67720186971698544312419572409913959008952310058822",
				"95548255300263520781532296796249481641953868218774",
				"76085327132285723110424803456124867697064507995236",
				"37774242535411291684276865538926205024910326572967",
				"23701913275725675285653248258265463092207058596522",
				"29798860272258331913126375147341994889534765745501",
				"18495701454879288984856827726077713721403798879715",
				"38298203783031473527721580348144513491373226651381",
				"34829543829199918180278916522431027392251122869539",
				"40957953066405232632538044100059654939159879593635",
				"29746152185502371307642255121183693803580388584903",
				"41698116222072977186158236678424689157993532961922",
				"62467957194401269043877107275048102390895523597457",
				"23189706772547915061505504953922979530901129967519",
				"86188088225875314529584099251203829009407770775672",
				"11306739708304724483816533873502340845647058077308",
				"82959174767140363198008187129011875491310547126581",
				"97623331044818386269515456334926366572897563400500",
				"42846280183517070527831839425882145521227251250327",
				"55121603546981200581762165212827652751691296897789",
				"32238195734329339946437501907836945765883352399886",
				"75506164965184775180738168837861091527357929701337",
				"62177842752192623401942399639168044983993173312731",
				"32924185707147349566916674687634660915035914677504",
				"99518671430235219628894890102423325116913619626622",
				"73267460800591547471830798392868535206946944540724",
				"76841822524674417161514036427982273348055556214818",
				"97142617910342598647204516893989422179826088076852",
				"87783646182799346313767754307809363333018982642090",
				"10848802521674670883215120185883543223812876952786",
				"71329612474782464538636993009049310363619763878039",
				"62184073572399794223406235393808339651327408011116",
				"66627891981488087797941876876144230030984490851411",
				"60661826293682836764744779239180335110989069790714",
				"85786944089552990653640447425576083659976645795096",
				"66024396409905389607120198219976047599490197230297",
				"64913982680032973156037120041377903785566085089252",
				"16730939319872750275468906903707539413042652315011",
				"94809377245048795150954100921645863754710598436791",
				"78639167021187492431995700641917969777599028300699",
				"15368713711936614952811305876380278410754449733078",
				"40789923115535562561142322423255033685442488917353",
				"44889911501440648020369068063960672322193204149535",
				"41503128880339536053299340368006977710650566631954",
				"81234880673210146739058568557934581403627822703280",
				"82616570773948327592232845941706525094512325230608",
				"22918802058777319719839450180888072429661980811197",
				"77158542502016545090413245809786882778948721859617",
				"72107838435069186155435662884062257473692284509516",
				"20849603980134001723930671666823555245252804609722",
				"53503534226472524250874054075591789781264330331690" };
		Long sum = 0L;
		for (int i = 0; i < arr.length; i++) {
			sum += Long.parseLong(arr[i].substring(0,  10));
		}
		printAnswer(13, sum);
	}
	
	private static void printAnswer(int problemNumber, Object answer) {
        System.out.printf("The answer to problem %d is %s\n", problemNumber, answer);
    }
}
