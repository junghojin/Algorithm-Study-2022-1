import java.util.*;
import java.util.Map.Entry;

public class 실패율 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(solution(N, stages));
	}

	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        //N만큼 배열을 만들어야 하나? 
        int [] challenger = new int[N+1];
        int [] fail = new int[N+1];
        
    
        HashMap<Integer, Double> failRate = new HashMap<>();
        
        //stages의 각 사람들마다 그사람의 숫자만큼 for문을 돌기 -> 이중 포문 500 X 200000 = 100000000 ( 1억)
        for (int i = 0; i < stages.length; i++) {
//        	System.out.println(stages[i]);
        	if(stages[i]<=N) {
        		fail[stages[i]]++; // 실패자 값 더하기
        	}
			
			for (int j = 1; j <= stages[i]; j++) {
//				System.out.println("J: "+j);
				if(j!=N+1) {
					challenger[j]++; // 도전자 값 구하기
				}
				
			}
		}
        
        // 각 스테이지를 내림차순으로 어떻게 구하지?
        for (int i = 1; i < N+1; i++) {
        	if(fail[i] != 0) {
//        		System.out.println(fail[i]+" "+ challenger[i]+" "+ ((double)fail[i]/challenger[i]));
        		failRate.put(i, ((double)fail[i]/challenger[i]));
        	}else {
        		failRate.put(i, (double) 0);
        	}
        	
        	
		}
        
        List<Entry<Integer, Double>> list_entries = new ArrayList<Entry<Integer, Double>>(failRate.entrySet());

	     // 비교함수 Comparator를 사용하여 오름차순으로 정렬
	     Collections.sort(list_entries, new Comparator<Entry<Integer, Double>>() {
	     	// compare로 값을 비교
	     	public int compare(Entry<Integer, Double> obj1, Entry<Integer, Double> obj2) {
	     		// 내림 차순으로 정렬
	     		return obj2.getValue().compareTo(obj1.getValue());
	     	}
	     });
	
	     for (int i = 0; i < N; i++) {
//	    	 System.out.println(i+" "+list_entries.get(i).getKey());
	    	 answer[i]= list_entries.get(i).getKey();
		}
	     
        return answer;
    }
}
