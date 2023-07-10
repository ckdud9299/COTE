// 백준 #23970 알고리즘 수업 - 버블 정렬3

package day4_bubblesort;

import java.io.*;
import java.util.*;

public class B23970 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int A [] = new int [n];
		int B [] = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean check = false;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i ; j++) {
				if(A[j]>A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					
					if(Arrays.equals(A, B)) {
						check = true;
						break;
					}
				}
				
			}
			
		}
		
		
		if(check) {
			System.out.print("1");
		}
		else {
			System.out.print("0");
		}
	}
}
