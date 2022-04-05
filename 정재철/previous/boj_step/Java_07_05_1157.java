
// Java_07_05_1157

import java.util.*;

public class Java_07_05_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next().toUpperCase();
		int arr[] = new int[26];
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			arr[c - 'A']++;
		}
		int max = 0;
		int index = -1;
		char result;
		for (int i = 0; i < 26; i++) {
			if(arr[i]>max){
				index=i;
				max = arr[index];
			}
		}
		result = (char)(index+'A');
		for (int i = 0; i < 26; i++) {
			if(i !=index&&arr[i]==arr[index]){
				result='?';
				break;
			}
		}
		System.out.println(result);

		sc.close();
	}
}
