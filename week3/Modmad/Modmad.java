/* 
 *	Generate a sequence of numbers using the modulus operation
 *
 *	Each method returns an array of n numbers
 *	if n < 0 return null
 *  if n == 0 return array of size zero
 */
public class Modmad
{
	// practice (no modulus needed)
	// Sequence: 13, 13, 13, 13, 13, 13, ...
	public static int[] practice1(int n) {
		// YOUR CODE BE HERE

		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = 13;
		}
		return res;
	}	
	
	// practice (no modulus needed)
	// Sequence: 0, 1, 2, 3, 4, 5, 6, 7...
	public static int[] practice2(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		for (int i = 0; i < n; i++){
			res[i] = i;
		}
		return res;
	}

	// Sequence: 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3...
	public static int[] generateA(int n) {
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = i%4;
		}
		return res;
	}

	// Sequence: 3, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 0...
	public static int[] generateB(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] m = {3, 2, 1, 0};
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = m[i%4];
		}
		return res;
	}

	// Sequence: 0, 3, 6, 0, 3, 6, 0, 3, 6...
	public static int[] generateC(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		int[] m = {0,3,6};
		for (int i = 0; i < n; i++) {
			res[i] = m[i%3];
		}
		return res;
	}

	// Sequence: 0, 2, 4, 6, 0, 2, 4, 6, 0, 2, 4, 6...
	public static int[] generateD(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		int a = 0;
		for (int i = 0; i < n; i++) {
			res[i] = a%8;
			a += 2;
		}
		return res;
	}

	// Sequence: -3, -2, -1, 0, 1, 2, 3, -3, -2, -1, 0, 1, 2, 3...
	public static int[] generateE(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		int[] m = {-3, -2, -1, 0, 1, 2, 3};
		for (int i = 0; i < n; i++) {
			res[i] = m[i%7];
		}
		return res;
	}

	// Sequence: 100, 105, 110, 115, 120, 100, 105, 110, 115, 120, 100...
	public static int[] generateF(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];

		int[] res = new int[n];
		int[] m = {0,5,10,15,20};
		for (int i = 0; i < n; i++) {
			res[i] = m[i%5]+100;
		}
		return res;
	}
	
	// Sequence: -1, 1, 3, 5, -1, 1, 3, 5, -1, 1, 3, 5...
	public static int[] generateG(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];
		int[] m = {-1, 1, 3, 5};
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = m[i%4];
		}
		return res;
	}
	
	// Sequence: 0, 50, 100, 0, 50, 100...
	public static int[] generateH(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new int[0];
		int[] m = {0, 50, 100};
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = m[i%3];
		}
		return res;
	}
	
	// Sequence: -0.5, 0, 0.5, 0, -0.5, 0, 0.5...
	public static double[] generateI(int n) {
		// YOUR CODE BE HERE
		if (n < 0) return null;
		if (n == 0) return new double[0];
		double[] m = {-0.5, 0, 0.5, 0};
		double[] res = new double[n];
		for (int i = 0; i < n; i++) {
			res[i] = m[i%4];
		}
		return res;
	}
	
	// Sequence: 0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 5, 3, 4, 5, 6...
	public static int[] generateJ(int n) {
		// YOUR CODE BE HERE
		// 0, 1, 2, 3
		// 1, 2, 3, 4
		// 2, 3, 4, 5
		// 3, 4, 5, 6

		if (n < 0) return null;
		if (n == 0) return new int[0];
		int[] res = new int[n];
		int[] m = {0, 1, 2, 3};
		for (int i = 0; i < n; i++) {
			res[i] = m[i%4];
			m[i%4]++;
		}
		return res;
	}

	// oh being cheeky with the if statements?
	// return the exact number appearing in the sequence for the given i
	// if (i < 0) return i;
	// Sequence: -0.5, 0, 0.5, 0, -0.5, 0, 0.5...
	public static double generateI2(int i) {
		// YOUR CODE BE HERE
		if (i < 0) return i;
		double[] m = {-0.5, 0, 0.5, 0};
		return m[i%4];
	}	

	
	// oh being cheeky with the if statements?
	// return the exact number appearing in the sequence for the given i
	// if (i <= 0) return i;
	// Sequence: 0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 5, 3, 4, 5, 6...
	public static int generateJ2(int i) {
		// YOUR CODE BE HERE
		if (i <= 0) return i;
		int[] m = {0, 1, 2, 3};
		int add = i/4;
		return m[i%4] + add;
	}

}


