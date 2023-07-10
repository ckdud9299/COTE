// 백준 #23882 알고리즘 수업 - 선택 정렬2

package day4_selectionsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B23882 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 배열의 크기 입력 받기
		int n = Integer.parseInt(st.nextToken());
		// 교환 횟수 입력 받기
		int k = Integer.parseInt(st.nextToken()); 
		
		// 입력 받은 원소 배열에 저장
		st = new StringTokenizer(br.readLine());		
		int arr [] = new int [n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 
		 * 1) 배열의 마지막 요소부터 시작하여 역순으로 반복문을 실행
		 * 2) 배열의 마지막 요소 인덱스를 max에 저장
		 * 3) max 인덱스를 가지는 배열의 값보다 큰 값이 있으면 max에 해당 인덱스로 변경
		 * 4) 변경된 인덱스를 기반으로 swap , cnt 증가
		 * 5) cnt == K 이면 배열 출력
		 * 6) cnt < K 이면 -1 출력
		 */
		
		int cnt = 0; 
		
		for(int i=n-1; i>=0; i--) { 
			int Max = i;
			
			for(int j=0; j<i; j++) {
				if(arr[j]> arr[Max]) {
					Max = j;
				}
			}
			
			if(arr[i] < arr[Max]) {
				int temp = arr[i];
				arr[i] = arr[Max];
				arr[Max] = temp;
				cnt++; // 교환이 일어나면 cnt를 1증가
				
			}
			
			// cnt가 입력받은 k 와 같으면 반복문 종료
			if(cnt == k) { 
				break;
			}
		}
		
		if(cnt<k) { // 교환 횟수가 k 보다 작을 경우
			System.out.print("-1");
		}
		else {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}

}
