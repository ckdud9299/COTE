// 백준 #1715 카드 정렬하기 
 
/*
 * 크기가 작은 순으로 정렬 -> 작은 수 두개를 더해서 다시 큐에 저장
 * 다시 반복 => 큐에 1개 남을때 까지 반복
 */

package day3_queue;

import java.io.*;
import java.util.*;

public class B1715 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> myQueue = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			myQueue.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		
		while(myQueue.size() > 1) {
			int a = myQueue.poll();
			int b = myQueue.poll();
			
			int sum = a+b;
			result += sum;
			
			myQueue.add(sum);
			
		}
		
		System.out.println(result);
	}
}
