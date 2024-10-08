//Name : Rethick Arun
//CWID : 20035348
//Program to test different complexities
//Note : Initializing all Counters to 1 for better understanding

public class Complexity {
	public static void method1(int n) {
		//Program for O(n²)
		System.out.println("Program for O(n²)");
		int counter = 1;
		if (n<=0) {
			throw new IllegalArgumentException("Given integer should have a positive value");
		}
		for (int i = 0;i<n;i++) {
			for (int j = 0; j < n ; j++) {
				System.out.println("Operation "+counter);
				counter++;
			}
		}
	}
	public static void method2(int n) {
		//Program for O(n³)
		System.out.println("Program for O(n³)");
		int counter = 1;
		if (n<=0) {
			throw new IllegalArgumentException("Given integer should have a positive value");
		}
		for (int i = 0;i<n;i++) {
			for (int j = 0; j < n ; j++) {
				for (int k = 0; k < n; k++ ) {
				System.out.println("Operation "+counter);
				counter++;
				}
			}
		}
	}
	public static void method3(int n) {
		//Program for O(log n)
		System.out.println("Program for O(log n)");
		int counter = 1;
		if (n<=0) {
			throw new IllegalArgumentException("Given integer should have a positive value");
		}
		for (int i = 1;i<n;i*=2) {
				System.out.println("Operation "+counter);
				counter++;
		}
	}
	public static void method4(int n) {
		//Program for O(n log n)
		System.out.println("Program for O(n log n)");
		int counter = 1;
		if (n<=0) {
			throw new IllegalArgumentException("Given integer should have a positive value");
		}
		for (int i = 0;i<n;i++) {
			for (int j = 1; j < n ; j*=2) {
				System.out.println("Operation "+counter);
				counter++;
			}
		}
	}
	public static void method5(int n) {
		//Program for O(log log n)
		System.out.println("Program for O(log log n)");
		int counter = 1;
		if (n<=0) {
			throw new IllegalArgumentException("Given integer should have a positive value");
		}
		for (int i = 2; i < n; i = (int) Math.pow(i, 2)) { //i initialized to 2, since 1² will always be 1
				System.out.println("Operation "+counter);
				counter++;
		}
	}
	static int counter = 0;
	public static int method6(int n) {
		//Program for O(2ⁿ)
		if (n<=0) {
			throw new IllegalArgumentException("Given integer should have a positive value");
		}
		if (n<=1) {
			counter++;
			System.out.println("Operation "+counter);
			return n;
		}
		counter++;
		System.out.println("Operation "+counter);
		return method6(n-1) + method6(n-1);
	}
	

	public static void main(String[] args) {
		Complexity.method1(4);// Expected Number of Operations : 16
		Complexity.method2(4);// Expected Number of Operations : 64
		Complexity.method3(8);// Expected Number of Operations : 3
		Complexity.method4(16);// Expected Number of Operations : 64
		Complexity.method5(1024);// Expected Number of Operations : 4
		Complexity.method6(4);// Expected Number of Operations : 15
	}


}
//Name : Rethick Arun
//CWID : 20035348
