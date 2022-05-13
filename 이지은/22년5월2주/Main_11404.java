import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404 { //플로이드
	
	static int N,M,fare[][];
	static final int INF = 10000000; //MAX_VALUE로 하게되면 가중치를 더해보는 과정에서 오버플로우가 날 수 있기 때문에!
	//100,000*100 = 10,000,000
	public static void main(String[] args) throws NumberFormatException, IOException {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		fare = new int[N+1][N+1];
		
		for (int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 비용
			if(fare[a][b]==0 || fare[a][b]>c) { // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
				fare[a][b]=c;
			}
		}
		
		//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
		//최소값을 갱신하는 것인데 0으로 되어있으면 문제가 될 수 있으니!
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j && fare[i][j]==0) {
					fare[i][j]=INF;
				}
			}
		}

		//플로이드 워셜 수행 모든 쌍에 대해 경유지를 거치는것과 직접가는 것중에 최단 경로 저장 - 경 출 도
		for (int k = 1; k <= N; k++) {                                  // 경유지
			for (int i = 1; i <= N; i++) { // 경유지와 출발지가 같다면 다음
				if(i==k) continue;                                      // 출발지
				for (int j = 1; j <= N; j++) {                          // 도착지
					if(i==j || k==j) continue; // 목적지가 출발지와 같거나 경유지와 같다면 다음
					
					int indirect = fare[i][k] + fare[k][j]; // 경유지를 거칠 때 비용
					int direct = fare[i][j];                // 안거칠 때의 비용
					fare[i][j] = Math.min(indirect, direct);
				}
			}
		}
		
		//출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(fare[i][j]==INF) fare[i][j]=0; // 경유지를 거쳐서도 i->j로의 길이 없는 경우 다시 0으로 돌려줌
				System.out.print(fare[i][j]+" ");
			}
			System.out.println();
		}
	}

}

