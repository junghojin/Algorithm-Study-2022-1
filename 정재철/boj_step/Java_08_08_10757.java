
// Java_08_08_10757

import java.util.*;

public class Java_08_08_10757 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int len;
		if (a.length() > b.length()) {
			len = a.length();
		} else {
			len = b.length();
		}

		int[] arrA = new int[len + 1];
		int[] arrB = new int[len + 1];
		for (int i = 0; i < a.length(); i++) {
			arrA[i] = a.charAt(a.length() - 1 - i) - '0';
		}
		for (int i = 0; i < b.length(); i++) {
			arrB[i] = b.charAt(b.length() - 1 - i) - '0';
		}
		int carry = 0;
		for (int i = 0; i < len; i++) {
			if ((arrA[i] + arrB[i] + carry) >= 10) {
				arrA[i] = (arrA[i] + arrB[i] + carry) % 10;
				carry = 1;
			} else {
				arrA[i] = arrA[i] + arrB[i] + carry;
				carry = 0;
			}
		}
		if (carry == 1) {
			arrA[len] = 1;
			for (int i = 0; i < len + 1; i++) {
				arrB[i] = arrA[len - i];
			}
			for (int i = 0; i < len + 1; i++) {
				System.out.print(arrB[i]);
			}

		} else {
			for (int i = 0; i < len; i++) {
				arrB[i] = arrA[len-1 - i];
			}
			for (int i = 0; i < len; i++) {
				System.out.print(arrB[i]);
			}
		}


		sc.close();
	}
}
