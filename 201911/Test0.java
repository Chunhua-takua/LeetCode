import java.util.ArrayList;

class Solution {
	public int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			return null;
		}
		if (digits[0] == 0) { 
			int[] result = {1};
			return result; }

		// Convert array to integer
		BigInteger n = 0;
		for (int i = 0; i < digits.length; ++i) {
			n = digits[i] + n * 10;
			System.out.println("i = " + i + ", n = " + n);
		}

		++n;
		// System.out.println("n = " + n);
		// Convert integer to array
		ArrayList<Integer> l = new ArrayList<>();
		while (n > 0) {
			int temp = n % 10;
			n /= 10;
			l.add(temp);
		}
		System.out.println("l=" + l);

		int[] result = new int[l.size()];
		int index = 0;
		for (Integer e : l) {
			result[index] = e;
			++index;
		}

		return result;


	}

}

class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		// int[] digits = {1,1,1,1};
		// int[] digits = {9};
		// int[] digits = {1,9,9};
		int[] digits = {9,8,7,6,5,4,3,2,1,0};

		int[] r = s.plusOne(digits);

		for (int i = 0; i < r.length; ++i) {
			System.out.print(r[i] + " ");
		}

		// int n = 9876543210;
		// System.out.println("nnn = " + n);
	}
}
