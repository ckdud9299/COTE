// 백준 #3986 좋은 단어

/*
 * 스택이 중복 문자를 만나면 삭제 -> 반복 후에 스택이 비어있으면 좋은 단어
 * 1) 스택이 비어있을 때 -> push()
 * 2) top 과 다음 들어올 문자를 비교
 * 2-1) 다를  때 -> push()
 * 2-2) 같을 때 -> pop() 
 */

package day2_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class B3986 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack <Character> stack = new Stack<>();
		
		int cnt = 0; // 좋은 단어 갯수 0으로 선언
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) { // 입력받은 N만큼 반복
			String str = br.readLine();			
			
			for(int j=0; j<str.length(); j++){ // 각 행마다 str 길이만큼 반복
				
				if(stack.isEmpty()) { // 스택이 비어있을때
					stack.push(str.charAt(j));
					continue;
				}
				else {
					if(str.charAt(j) == stack.peek()) { // top과 다음 들어올 문자가 다를때
						stack.pop();
					}
					else {
						stack.push(str.charAt(j)); // top과 다음 들어올 문자가 다를 때
					}
				}				
			}
			
			if(stack.isEmpty()) { // 스택
				cnt++;
			}
			
			stack.clear();
			
			
		}
		System.out.println(cnt);
	}
}