/**
 * 일곱 난쟁이 / 브론즈 1 / 
 */
import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {
	
	static int[] arr; // 완성된 일곱 난쟁이를 담을 배열
	static int[] visited; // 배열의 완성하기 위해 선택됬는지 확인하기 위한 배열
	static int[] nums; // 9명의 난쟁이를 받을 배열
	static StringBuilder sb = new StringBuilder(); // 답을 출력하기 위한 StringBuilder
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[7];
		visited = new int[9];
		nums = new int[9];
		int count = 0;
		int tmp1=-1;
		int tmp2=-1;
		int sum = 0;
		
		for(int i=0;i<9;i++) { // 9명의 난쟁이의 키를 입력 받음
			nums[i] = parseInt(br.readLine());
			sum += nums[i];
		}
		
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(sum-nums[i]-nums[j]==100) {
					tmp1 = nums[i];
					tmp2 = nums[j];
				}
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=tmp1 && nums[i]!=tmp2) {
				arr[count++] = nums[i];
			}
		}
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
