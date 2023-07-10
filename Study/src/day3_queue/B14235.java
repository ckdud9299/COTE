// 백준 #14235 크리스마스 선물
  
package day3_queue;

import java.io.*;
import java.util.*;

public class B14235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1,o2)->{
			return o2 - o1;
		}); // 큰 수가 우선으로 정렬

		for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a==0){ // 0 입력받았을 때
                if(myQueue.isEmpty()){ // 큐가 비어있으면 -1 출력
                    System.out.println("-1");
                } else{ // 큐에 저장된 가장 큰 수 출력
                    System.out.println(myQueue.poll());
                }
            } else{ // 0이 아닌 수를 입력받았을 때
                for (int j=0; j<a; j++){ // 큐에 입력받은 수 저장
                    myQueue.add(Integer.parseInt(st.nextToken()));
                }
            }

		}
		
	}	
	
}
