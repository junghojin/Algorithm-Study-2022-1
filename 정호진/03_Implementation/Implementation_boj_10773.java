//package week;

/*
 * 2022.02.01.화요일  
 * 구현 - 백준 10773번 - 제로 - JHJ
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Implementation_boj_10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Integer> nums = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			if (temp != 0) {
				nums.add(temp);
			} else {
				nums.remove(nums.size()-1);
			}
		}

		int sum = 0;
		for (Integer each : nums) {
			sum += each;
		}
		System.out.println(sum);
		sc.close();
	}

}
