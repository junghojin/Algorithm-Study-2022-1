import java.util.*;

// 22.06.18 - 2021 KAKAO BLIND RECRUITMENT - 순위 검색

class Kakao_2021B_lv2 {
    
    HashMap<String, ArrayList<Integer>> hm;
    
    public int[] solution(String[] info, String[] query) {
       int[] answer = new int[query.length];

        // info 기반 키 생성
        hm = new HashMap<>();
        for (int i = 0, size = info.length; i < size; i++) {
            dfs(0, "", info[i].split(" "));
        }

        // 각 key별 value 오름차순 정렬
        for (String key : hm.keySet()) {
            Collections.sort(hm.get(key));
        }

        // 조건을 만족하는 지원자가 몇 명인지 찾기
        for (int i = 0, size = query.length; i < size; i++) {
            String[] each = query[i].replace(" and ", "").split(" ");
            int criteria = Integer.parseInt(each[1].trim());
            String key = each[0];
            
            // 런타임에러 발생지점
            // info 기반으로 hashmap의 key가 만들어지기 때문에,
            // query에서 찾고자 하는 조건이 hashmap의 key로 존재하지 않을 수 있습니다. 
            if(hm.containsKey(key)){
                ArrayList<Integer> scores = hm.get(key);
                int search_point = search(scores, criteria);
                answer[i] = hm.get(key.toString()).size() - search_point;
            }
        }
        return answer;
    }
    
    // 지원자 정보 기반 가능한 모든 키 생성
    private void dfs(int d, String str, String[] info) {
        if(d == 4) {
            if (!hm.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<>();
                hm.put(str, list);
            } 
            hm.get(str).add(Integer.parseInt(info[4]));
            
            return;
        }

        dfs(d + 1, str + info[d], info);
        dfs(d + 1, str + "-", info);
    }

    // binary search 를 이용한 시작점 찾기
    private int search(ArrayList<Integer> scores, int criteria) {

        int left = 0, right = scores.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (criteria > scores.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
