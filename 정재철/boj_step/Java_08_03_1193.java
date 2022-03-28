
// Java_08_03_1193

import java.util.*;

public class Java_08_03_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i=0;
		while(true){
			if((N)<=(i*i+i)/2){
			i++;
				break;
			}
			i++;
		}
		int seq=N-((i-2)*(i-2)+(i-2))/2;
		if(i%2==0){
			System.out.println((i-seq)+"/"+seq);
		} else{
			System.out.println(seq+"/"+(i-seq));
		}

		sc.close();
	}
}
