// 백준 #17608 막대기

/*
 * 1) top을 기준 막대기로 설정
 * 2) 기준 막대기와 pop() 비교
 * 2-1) pop()이 크면 -> cnt 1 증가, 기준막대기를 pop으로 변경
 * 2-2) 기준 막대기가 크면 다시 반복문 실행 
 */

package day2_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 막대기의 갯수 저장
		int N = Integer.parseInt(br.readLine());
		
		// 스택 선언
		Stack <Integer> stack = new Stack<>();
		
		// 입력받은 막대기의 높이를 스택에 저장
		for(int i=0; i<N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 1; // 맨 마지막 막대기는 무조건 보이므로 1로 선언		
		int tall = stack.pop(); // 기준 막대기 설정
		
		while(!stack.isEmpty()) { // 스택에 데이터가 없을 때까지 반복
			int x = stack.pop();
			
			if(x > tall) { // 기준 막대기와 pop 막대기 길이 비교
				cnt++;
				tall = x;
			}
		}
		
		System.out.print(cnt);		
		
		
	}

}
