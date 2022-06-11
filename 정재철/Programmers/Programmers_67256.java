// Programmers_67256_2022 카카오 인턴십_키패드 누르기

public class Programmers_67256 {
    public static void main(String[] args){
         int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution sol = new Solution();
        System.out.println(sol.solution(numbers, hand));
    }
    static class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder str = new StringBuilder();
            int leftX = 3;
            int leftY = 0;
            int rightX = 3;
            int rightY = 2;
            for (int temp : numbers) {
                switch (temp) {
                    case 1, 4, 7:
                        leftX = temp / 3;
                        leftY = 0;
                        str.append("L");
                        break;
                    case 3, 6, 9:
                        rightX = temp / 3 - 1;
                        rightY = 2;
                        str.append("R");
                        break;
                    case 2, 5, 8, 0:
                        int h = temp == 0 ? 3 : temp / 3;
                        int leftDis = Math.abs(leftX - h) + Math.abs(leftY - 1);
                        int rightDis = Math.abs(rightX - h) + Math.abs(rightY - 1);
                        if (leftDis > rightDis) {
                            rightX = h;
                            rightY = 1;
                            str.append("R");
                        } else if (leftDis < rightDis) {
                            leftX = h;
                            leftY = 1;
                            str.append("L");
                        } else {
                            if (hand.equals("right")) {
                                rightX = h;
                                rightY = 1;
                                str.append("R");
                            } else {
                                leftX = h;
                                leftY = 1;
                                str.append("L");
                            }
                        }
                        break;
                }
            }
            return str.toString();
        }
    }
}

