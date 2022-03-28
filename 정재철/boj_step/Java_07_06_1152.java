
// Java_07_06_1152

import java.util.*;

public class Java_07_06_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine().trim();
		String[] arr = S.split(" ");
		if(arr[0]==""){
			System.out.println("0");
		}else{
			System.out.println(arr.length);
		}

		sc.close();
	}
}
