
public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  


	public static int plus(int x1, int x2) {
		int j = 0;
		if(x1 == 0)
		{return x2;}
		if(x2 == 0 )
		{return x1;}
    if (x2 < 0) {
        while (j > x2) {
            j--;  
            x1--; 
        }
    } 
    else {
        while (j < x2) {
            j++;
            x1++; 
        }
    }

    return x1;
}
	
	public static int minus(int x1, int x2) {
    int j = 0;
    if (x2 == 0) {
        return x1;
    }
    if (x1 == 0) {
        return -x2;
    }
    if (x2 > 0) {
        while (j < x2) {
            j++;
            x1--;
        }
    } else {
        while (j > x2) {
            j--;
            x1++;
        }
    }
    return x1;
}

	public static int times(int x1, int x2) {
		int k = 0;

		if (x1 == 0 || x2 == 0)
		{return 0;}
		
		if (x1 < 0 && x2 < 0 || x1 > 0 && x2 < 0)
		{x1 = -x1; x2 = -x2;}

		for (int i = 0; i < x2; i++)
		{k = plus(k,x1);}
		return k;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n==0)
		{return 1;} 
		int k = 1;
		for (int i = 0; i < n; i++)
		{k = times(k, x);}
		return k;
	}

	public static int div(int x1, int x2) {
		if (x2 == 0){return 0;};
		
		int div = 0;
		boolean isNegative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);
		
		if (x1 < 0){x1 = -x1;};
		if (x2 < 0){x2 = -x2;};
		
		for(int i = x2; i <= x1; i = plus(i,x2)){
			div++;
		}

		if (isNegative) {
		return -div;
		}

		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int remainder = minus(x1, times(x2, div(x1, x2)));
		return remainder;
	}	

	public static double sqrt(int x) {
        double epsilon = 0.01;      
        double increment = 0.0001;  
        double g = 1.0;             
       // int stepCounter = 0;
        while (Math.abs(g * g) < x) {
            g += increment;
            //stepCounter++;
        }
		return g;
	}
}