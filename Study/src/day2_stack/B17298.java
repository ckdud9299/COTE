// 백준 #17298 오큰수

/*
 * 1) 입력받은 값 배열에 저장 후 뒤에서부터 비교
 * 2) 스택이 비어있을 때 -> 오큰수=-1, push()
 * 3) top > 배열값 -> 오큰수=top, push()
 * 4) top < 배열값 -> top>arr까지 pop() 후에 다시 2번으로
 */

package day2_stack;

import java.util.*;

public class B17298 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 수열의 크기 N에 저장
		int N = sc.nextInt(); 
		
		// 입력받은 수열의 원소 arr에 저장
		int [] arr = new int[N]; 
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 스택 선언
		Stack<Integer> stack = new Stack<>();
		
		// 오큰수 저장할 배열 선언
		int [] NGE = new int [N];
		
		
		for(int i=N-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				NGE[i] = -1;
				stack.push(arr[i]);
			}
			else {
				NGE[i] = stack.peek();
				stack.push(arr[i]);
			}
		}
		
		// NGE 배열 출력
		StringBuffer bf = new StringBuffer();

		for(int i=0; i<NGE.length; i++) {
			bf.append(NGE[i]+" ");
		}
		
		System.out.println(bf.toString());
		
		
		
	}
}