// 백준 #23969 알고리즘 수업 - 버블 정렬2

package day4_bubblesort;

import java.io.*;
import java.util.*;

public class B23969 {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		
		//int n = sc.nextInt();
		//int k = sc.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		int arr [] = new int [n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i && cnt<k; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					cnt++;
				}
			}
		}
		
		if(cnt<k) {
			System.out.print("-1");
		}
		else {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}

}
