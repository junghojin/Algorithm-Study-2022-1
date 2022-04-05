
// Java_08_02_2292

import java.util.*;

public class Java_08_02_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i=0;

		while(true){
			if((N-1)<=(3*i*i+3*i)){
			i++;
				break;
			}
			i++;
		}
		System.out.println(i);
		sc.close();
	}
}
