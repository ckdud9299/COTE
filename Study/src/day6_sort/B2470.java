/* 두 용액 */ 
package day6_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
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
	        
	        /*
	         * 1) 배열 오름차순 정렬
	         * 2) 가장 왼쪽 배열의 값과 가장 오른쪽 배열의 값의 합이 1에 가까운지 확인
	         * 3) 두 수의 합이 0보다 작으면 음수쪽이 크다는 뜻 -> 왼쪽 인덱스를 이동
	         * 4) 두 수의 합이 0보다 크면 양수쪽이 크다는 뜻 -> 오른쪽 인덱스를 이동
	         * 5) 두 인덱스가 교차할때까지 반복
	        */
	        
	        int start = 0;
	        int end = N-1;
	        int min = 2000000000;
	        int result1=0, result2=0;
	        
	        Arrays.sort(arr);
	        
	        while(start < end) {
	        	int sum = arr[start]+ arr[end];
	        	
	        	if(Math.abs(sum) < min) {
	        		result1 = arr[start];
	        		result2 = arr[end];
	        		min = Math.abs(sum);
	        	}
	        	
	        	if(sum<0) {
	        		start++;
	        	}
	        	else if(sum>0) {
	        		end--;
	        	}
	        	else {
	        		break;
	        	}
	        }
	        
	        System.out.print(result1+" "+ result2);
	 }

}
