
// Java_07_03_10809

import java.util.*;

public class Java_07_03_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int arr[]= new int[26];
		for(int i=0;i<26;i++){
			arr[i]=-1;
		}
		for(int i=0;i<S.length();i++){
			char c = S.charAt(i);
			if(arr[c-'a']==-1){
				arr[c-'a']=i;
			}
		}
		for(int i=0;i<26;i++){
			System.out.print(arr[i]+ " ");
		}

		sc.close();
	}
}
