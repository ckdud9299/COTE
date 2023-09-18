package day5_insertsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B24053 {
 public static void main(String[] args) throws IOException {
	 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열의 크기 입력 받기
        int n = Integer.parseInt(st.nextToken());

        // 입력 받은 원소 A 배열에 저장
        st = new StringTokenizer(br.readLine());
        int A [] = new int [n];
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 입력 받은 원소 B 배열에 저장
        st = new StringTokenizer(br.readLine());
        int B [] = new int [n];
        for(int i=0; i<n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        


        // 삽입정렬
        for(int i=1; i<n; i++){
            int j = i-1;
            int temp = A[i];

            while (j>=0 && A[j]>temp){
                A[j+1] = A[j];
                j--;
               
            }
            if(j+1 != i){
                A[j+1] = temp;
        	}
        }
        
        System.out.print(Arrays.toString(A));

    }

        
}
