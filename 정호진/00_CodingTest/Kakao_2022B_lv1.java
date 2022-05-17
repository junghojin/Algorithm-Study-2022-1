import java.util.*;

// 22. 05. 17 - 2022 Kakao Blind - Lv1. 신고 결과 받기

class Kakao_2022B_lv1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];

        // id_list에 존재하는 이용자의 이름을 key로 이용한다.
        // 신고 기록을 위한 HashMap: key(신고된 유저), value(신고한 유저)
        HashMap<String, HashSet<String>> hm = new HashMap<>(); 
        HashMap<String, Integer> mail_count = new HashMap<>(); // 메일 받은 횟수를 세기 위한 HashMap
        for (int i = 0, length = id_list.length; i < length; i++) {
            hm.put(id_list[i], new HashSet<String>());
            mail_count.put(id_list[i], 0);
        }

        // report에서 이용자 id와 신고자 id 분리
        // key에 해당하는 value의 형태가 set이기 때문에 중복 값 존재 X
        // 이용자가 같은 이용자를 계속 신고해도 신고 횟수는 1번
        for (int i = 0, length = report.length; i < length; i++) {
            String each_report[] = report[i].split(" "); // [1]: 신고된 유저, [0]: 신고한 유저 
            hm.get(each_report[1]).add(each_report[0]);
        }

        // k번 이상 신고당하여 이용 정지되면, 신고자에게 메일을 발송한다. 유저가 메일을 받은 횟수 
        for (String key : hm.keySet()) {
            if (hm.get(key).size() >= k) {
                for (String value : hm.get(key)) {
                    mail_count.put(value, mail_count.get(value) + 1);
                }
            }
        }

        // id_list의 순서대로 유저가 메일 받은 횟수를 넣기 위한 과정 
        int idx = 0;
        for(String user: id_list) {
            answer[idx++] = mail_count.get(user);
        }

        return answer;
    }
}
