import java.util.*;
//1. 누적주차시간 계산(분으로)
//2. 주차요금 계산

public class 주차요금계산 { 
	
	public static void main(String[] args) {
		int[] n = {180, 5000, 10, 600};
		String[] n2 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		System.out.println(solution(n, n2));

	}
	
	public static int[] solution(int[] fees, String[] records) {
        int[] answer; // 차량번호가 작은 자동차부터 주차요금을 정수 배열에 담아 return
        
        //입력값으로부터 주차한 차들 정보가진 리스트 parking
        HashMap<String, Integer> parking = new HashMap<>(); // Integer[]
        
        //나간 차들 요금 계산 위해 ( 한번 들어온차말고 추후에 또 들어왔을때 한꺼번에 합쳐서 요금 청구 위해) 
//        PriorityQueue<car> fee = new PriorityQueue<>();
        //pq는 자동 정렬은 되지만 있는지 확인하고 빼는게 힘들어
        //한번 들어왔었던 차인지 아닌지가 중요해 왜냐면은 값을 +해서 요금청구할지 or 입차만하고 출차 안했을 경우를 대비해야하거든
        HashMap<String, Integer> fee = new HashMap<>(); // Integer[]
        
        for (String r : records) { // "05:34 5961 IN"
			String[] record = r.split(" "); // 띄어쓰기 기준으로 항목별로 배열에 넣음
			int t = getMin(record[0]); // 시간
			String n = record[1]; // 차량번호
			String io = record[2]; //출입
			
			
			// IN 이면 
			if(io.equals("IN")) {
				//차량번호를 key로 하고, value는 들어온 시간을 분으로 바꾼 것.
				parking.put(n, t);
				
			// OUT 이면
			}else {
				if(!fee.containsKey(n)) { //이미 한번 들어왔던 차가 아니라면
					fee.put(n, t - parking.get(n)); // 요금 청구할 시간 저장
				}else { // 한번입출차하여 누적시간이 있다면
					fee.put(n, fee.get(n) + t - parking.get(n)); //기존 시간에 추가해서 더하기
				}
				parking.remove(n);
			}
		}
        
        //parking에 남아있는 출차하지 않은 차 요금 계산하기
        for (String key : parking.keySet()) { //key = 차량번호
        	if(!fee.containsKey(key)) {
        		fee.put(key, (23*60+59)-parking.get(key));
        	}else {
        		fee.put(key, (23*60+59)-parking.get(key)+fee.get(key));
        	}
		}
        
        //fee 차량번호순으로 정렬하기
        Map<String, Integer> sortedFee = new TreeMap<>(fee);
//         System.out.println("ㅇㅇ"+sortedFee);
        
        //fee에 저장되어있는 것들 요금 계산해서 출력하기
        //fees[기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)]
        answer = new int[fee.size()];
        int i = 0;
        for (String car : sortedFee.keySet()) { //key = 차량번호
			int min = sortedFee.get(car);
			//요금 = 기본요금 + ((min-기본시간)/단위시간) *단위요금
			if(min<=fees[0]) {
				answer[i++] = fees[1];
				System.out.println(i+ " "+car+ "요금 : "+ fees[1]);
			}else {
				answer[i++] = (int) (fees[1] + Math.ceil((double)(min-fees[0])/fees[2])*fees[3]) ;
				System.out.println(i+ " "+car+ "요금  : "+  (int) (fees[1] + Math.ceil((double)(min-fees[0])/fees[2])*fees[3]) );
			}
		}
        return answer;
    }
	
	public static int getMin(String time) { // "05:34" 형태의 문자열을 int형 분으로 변환.
		String[] t = time.split(":");
		return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
	}

}

