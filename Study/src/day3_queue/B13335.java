// 백준 #13335 트럭 

/*
 * 1) 트럭 큐에 트럭의 무게를 저장, 다리 큐에 길이만큼 0을 저장
 * 2) 다리 큐에 아무것도 없을때까지 반복
 * 3) sum - 다리에서 나갈 트럭의 무게
 * 4) 트럭 큐에 아무것도 없을때까지 반복
 * 4-1) 다리 위의 무게 + 들어올 트럭의 무게가 <=L 일 경우 -> sum + 다리에 들어올 트럭의 무게 , 다리 큐에 트럭 add
 * 4-2) 다리 위의 무게 + 들어올 트럭의 무게가 > L 일 경우 -> 다리 큐에 0 add
 */
 
package day3_queue;

import java.io.*;
import java.util.*;

public class B13335 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		int time = 0; // 시간
		int sum = 0; // 다리 위의 트럭의 무게 합
		
		Queue<Integer> truck = new ArrayDeque<>(); // 트럭 무게 큐
		Queue<Integer> bridge = new ArrayDeque<>(); // 다리 큐
		
		st = new StringTokenizer(br.readLine());
		

		for(int i=0; i<n; i++) {
			truck.add(Integer.parseInt(st.nextToken())); 
		}
        
        for(int i=0; i<w; i++){
            bridge.add(0);
        }
		
		while(!bridge.isEmpty()) {
			sum -= bridge.poll();
            if(!truck.isEmpty()){
                if(sum + truck.peek()<=L){
                    sum += truck.peek();
                    bridge.add(truck.poll());
                }else{
                    bridge.add(0);
                }
            }
            time++;
		}
		
		System.out.println(time);
			
				
	}
}