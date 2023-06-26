// 백준 #1876 스택 수열

/*
 * 1) 수열과 num 비교
 * 2) 수열>=num 일 경우 -> 수열=num까지 push(num++) 후 pop()
 * 3) 수열 < num 일 경우 -> pop()과 수열 비교
 * 3-1) 다를 때 -> NO
 * 3-2) 같을 때 -> pop()
 */

package day2_stack;

import java.util.*;

public class B1874 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		int [] arr = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		
		boolean result = true;
		
		StringBuffer bf = new StringBuffer();
		
		for(int i=0; i<arr.length; i++) {
			int su = arr[i];
			
			if(su >= num) {
				while(su >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}
			else {
				if(stack.peek() != su) {
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					stack.pop();
					bf.append("-\n");
				}
			}
		}
		
		if(result) {
			System.out.println(bf.toString());
		}
	}
}
