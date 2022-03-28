package implementation;

import java.util.Scanner;

public class Imple_boj_2564_HSH {
	
	static final int Nor=1, Sou=2, Wes=3, Eas=4;		// 동서남북 방위를 상수로 설정함
	static int N,M;			// N : 가로  M: 세로
	static int shops_n;		// 상점의 개수
	static int start;		// 동근이의 위치
	static int Mins=0;		// 최단거리의 합을 저장.
	static boolean maps[];	// 상점 위치를 표시
	
	
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		shops_n = sc.nextInt();
				
		int totalDist = 2*(N+M);
		
		maps = new boolean[totalDist];
		
		//================sol===============
		/*
		 * 박스를 북-> 동 -> 남 -> 서  순으로 한줄로 길게 늘어뜨리는 배열로 생각.
		 * 동근이와 상점 간의 거리를 구하고(x) 전체거리에서 x를 뺀 만큼 길이를 y로 하여 
		 * x와 y를 비교하여 그 중 작은 거리를 합하는 방식
		 * 
		 * */
		
		for(int i=0; i<=shops_n ; i++) {
			int temp = 0;
			
			if(i==shops_n) {
			switch(sc.nextInt()) {
				case Nor:
					start = sc.nextInt();
					break;
				case Eas:
					start = sc.nextInt()+N;	
					break;
				case Sou:
					start = totalDist-M-sc.nextInt();
					break;
				case Wes:
					start = totalDist- sc.nextInt();
					break;
				default:
					break;
				}
			}
			else {
				switch(sc.nextInt()) {
				case Nor:
					temp = sc.nextInt();
					maps[temp] = true;		
					break;
				case Eas:
					temp = sc.nextInt()+N;		
					maps[temp] = true;
					break;
				case Sou:
					temp = totalDist-M-sc.nextInt();	
					maps[temp] = true;
					break;
				case Wes:
					temp = totalDist- sc.nextInt();	
					maps[temp] =true;
					break;
				default:
					break;
				}
			}
		}
		
		for(int i=0;i<totalDist;i++) {
			int dist=0;
			if(maps[i]==true) {
				dist = Math.abs(start-i);
				Mins += Math.min(dist, totalDist-dist);
			}
			
		}
		
		System.out.println(Mins);
		
		sc.close();
	}

}
