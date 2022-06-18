import java.util.*;

public class programmers_72412 {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		String[] info = {"java backend junior pizza 150",
		                 "python frontend senior chicken 210",
		                 "python frontend senior chicken 150",
		                 "cpp backend senior pizza 260",
		                 "java backend junior chicken 80",
		                 "python backend senior chicken 50"};
		
		String[] query = {"java and backend and junior and pizza 100",
						  "python and frontend and senior and chicken 200",
						  "cpp and - and senior and pizza 250",
						  "- and backend and senior and - 150",
						  "- and - and - and chicken 100",
						  "- and - and - and - 150"};
		
		System.out.println(Arrays.toString(sol.solution(info, query)));
	}
}

class Solution {
	static Map<String,ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 1. info를 기반으로 hashmap을 만든다.
        for(int i=0; i<info.length; i++) {
        	
        	String[] in = info[i].split(" ");
        	// 모든 경우의 수 만들기
        	dfs(in, "", 0);
        	
        }
        
        // 2. 각 HashMap의 value를 오름차순으로 정렬한다.
        for(ArrayList<Integer> arr : map.values()) {
        	arr.sort(null);
        }
        
        // 3. query 조건에 맞는 지원자를 가져온다.
        for (int i = 0; i < query.length; i++) {
        	query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" "); // q[0] : key, q[1] : 점수
        	int grade = Integer.parseInt(q[1]);
        	
        	if(map.containsKey(q[0])) {
        		ArrayList<Integer> list = map.get(q[0]);
        		
        		// 4. binary search를 가져와서 lowerbound를 찾는다.
        		int left = 0;
        		int right = map.get(q[0]).size();
        		
        		while(left<right) {
        			int mid = (left+right)/2;
        			
        			if(list.get(mid) >= grade) right = mid;
        			else left = mid+1;
        		}
        		
        		// 전체 크기에서 찾고자 했던 점수가 시작하는 인덱스를 빼줘서 기준 점수 이상인 사람의 수를 셀 수 있음
        		answer[i] = list.size() - left;
        	}
        }
        return answer;
    }
    
    // 모든 경우의 수 만들기
	private void dfs(String[] info, String str, int cnt) {
		if (cnt == 4) {
            if (!map.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(info[4]));
            return;
        }
		
		dfs(info, str+"-", cnt + 1);
		dfs(info, str+info[cnt], cnt + 1);
		
	}
}

