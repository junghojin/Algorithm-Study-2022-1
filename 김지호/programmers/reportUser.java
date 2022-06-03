import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
 * k번 이상 신고를 받은 유저를 신고한 모든 유저에게 정지 처리 결과를 메일로 보냄.
 * 신고 횟수의 제한은 없으며, 서로 다른 유저를 신고할 수 있음.
 * 단, 한 유저를 여러번 신고할 수 있지만, 신고횟수는 1회로 처리됨.
 * ==> 중복 신고 처리를 위해서 HashMap, HashSet을 사용함.
 * 
 * HashSet : HashSet은 Set 인터페이스를 구현한 것으로 들어오는 객체 중, 중복된 객체를 허용하지 않는다.
 * HashMap : Map 인터페이스를 구현. key-value 형식의 데이터를 저장. 중복된 key값을 허용하지 않는다.
 * 
 * set은 순서가 없기 떄문에 iterater 방식으로 객체를 순회함.
 * 
 * */

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        // <신고된 ID, 받을 메일수>
        Map<String, Integer> ans = new HashMap<>();
        
        // <신고된 ID, HashSet<신고한 ID>>
        Map<String, HashSet<String>> map = new HashMap<>();
        
        // id 리스트 받기
        for(int i=0; i<id_list.length; i++) {
			HashSet<String> reportId = new HashSet<>(); // 신고한 ID 넣을 hash set 초기화
			map.put(id_list[i], reportId); // 신고된 ID, 신고한ID 초기화
			ans.put(id_list[i], 0); // 신고된 ID, 메일 수 초기화
		}
        
        // 신고 받기
        for(int i=0; i<report.length; i++){
            
            String[] str = report[i].split(" ");
			String reporting = str[0]; // 신고한ID
			String reported = str[1]; // 신고된ID
            
            // 신고된ID 를 key값으로 신고한ID 배열을 value로
			map.get(reported).add(reporting); 
        }
        
        // 게시판 불량 이용자 정지 처리 결과 메일을 받을 유저
        for(String user : map.keySet()){
        	
            // user를 신고한 유저 HashSet
            HashSet<String> reportSet = map.get(user);
            
            // 신고된 횟수가 K번 이상일 경우
			if (reportSet.size() >= k) {
				for (String userid : reportSet) {
                    // ans 에 신고된 Id별 메일 수 넣기
					ans.put(userid, ans.get(userid) + 1); 
				}
			}
        }
        
        // id별 메일 받을 개수 저장
        for (int i = 0; i < id_list.length; i++) {
			answer[i] = ans.get(id_list[i]);
		}
        
        return answer;
    }
}