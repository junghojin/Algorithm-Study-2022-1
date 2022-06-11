class Solution {
	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int leftIndex = 10;	 
		int rightIndex = 12; 

		for(int number : numbers) {
			if(number == 1 || number == 4 || number == 7) { // Left
				sb.append("L");
				leftIndex = number;
			} else if(number == 3 || number == 6 || number == 9) {	// Right
				sb.append("R");
				rightIndex = number;
			} else { // Center
				int leftLength = getLength(leftIndex, number);
				int rightLength = getLength(rightIndex, number);

				if(leftLength > rightLength) {
					sb.append("R");
					rightIndex = number;
				} else if(leftLength < rightLength) {
					sb.append("L");
					leftIndex = number;
				} else {
					if(hand.equals("right")) {
						sb.append("R");
						rightIndex = number;
					} else {
						sb.append("L");
						leftIndex = number;
					}
				}
			}
		}
		return sb.toString();
	}

	public static int getLength(int index, int number) {

		index = (index == 0) ? 11 : index;	
		number = (number == 0) ? 11 : number;

		int x = (index - 1) / 3;
		int y = (index - 1) % 3;
		int numberX = number / 3;
		int numberY = 1;

		return Math.abs(x-numberX) + Math.abs(y-numberY);
	}
}