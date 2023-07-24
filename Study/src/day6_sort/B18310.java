/* 안테나 */ 
package day6_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18310 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        // 배열의 크기 입력 받기
	        int N = Integer.parseInt(st.nextToken());
	        
	        // 배열에 원소 저장하기
	        st = new StringTokenizer(br.readLine());
	        int arr [] = new int [N];
	        for(int i=0; i<N; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        // 배열 오름차순 정렬
	        Arrays.sort(arr);
	        
	        
	        if(N%2 == 0) { // 배열의 갯수가 짝수일 때
	        	System.out.print(arr[N/2-1]);
	        }
	        else { // 배열의 갯수가 홀수일 때
	        	System.out.print(arr[N/2]);
	        }
	        
    }

}
