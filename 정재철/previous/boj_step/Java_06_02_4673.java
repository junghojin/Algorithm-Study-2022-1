
// Java_06_02_4673

public class Java_06_02_4673 {
	public static void main(String[] args) {
		int arr[] = new int[10001];
		int self = 0;
		for (int i = 1; i <= 10000; i++) {
			self = i;
			String str = Integer.toString(i);
			for (int j = 0; j < str.length(); j++) {

				self = self + (str.charAt(j) - '0');
			}
			if (self < 10001) {
				arr[self]++;
			}
		}
		for (int j = 1; j <= 10000; j++) {
			if (arr[j] == 0)
				System.out.println(j);
		}
	}
}
