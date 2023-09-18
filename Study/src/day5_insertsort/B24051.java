package day5_insertsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열의 크기 입력 받기
        int n = Integer.parseInt(st.nextToken());
        // 저장 횟수 입력 받기
        int k = Integer.parseInt(st.nextToken());

        // 입력 받은 원소 배열에 저장
        st = new StringTokenizer(br.readLine());
        int arr [] = new int [n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        // 삽입정렬
        for(int i=1; i<n; i++){
            int j = i-1;
            int temp = arr[i];

            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                cnt++;
                if(cnt == k){
                    System.out.println(arr[j]);
                    return;
                }
                j--;
            }
            if(j+1 != i){
                arr[j+1] = temp;
                cnt++;
                if(cnt == k){
                    System.out.println(temp);
                    return;
                }
            }

        }

        System.out.println("-1");
    }

}
