package cote;

import java.util.Scanner;

public class B2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 지방의 수

        int arr [] = new int[N]; // 지방의 예산요청 배열

        int start = 1; // 이분 탐색 시작 값
        int end = 1; // 이분 탐색 종료 값
        int sum = 0; // 예산 요청의 합계

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();

            // if(arr[i]<start) start = arr[i];

            // 입력받은 예산요청 중 가장 큰 값을 end로 설정
            if(arr[i]>end) end = arr[i];
            // 입력 받은 값의 합을 구하기
            sum += arr[i];
        }

        int M = sc.nextInt(); // 국가 예산의 총액

        // 1번 규칙이 '모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.' 이므로
        // 국가 예산의 총액이 더 클 경우 입력받은 지방의 예산 요청 중 가장 큰 값을 출력
        if(M >= sum) {
            System.out.println(end);
            return;
        }
        // 2번 규칙인 '모든 요청이 배정될 수 없는 경우' -> 이분 탐색
        else{
            while(start <= end ){
                sum = 0;
                int mid = (start+end) / 2;

                // mid 값을 기준으로 예산 요청의 합을 계산
                for(int i=0; i<N; i++){
                    if(arr[i] <= mid){ //
                        sum += arr[i];
                    }
                    else{
                        sum += mid;
                    }
                }

                if(sum <= M){ // 예산 요청의 합이 국가 예산을 초과하지 않으면 start를 증가
                    start = mid + 1;
                }
                else{ // 예산 요청의 합이 국가 예산을 초과하면 end를 감소
                    end = mid - 1;
                }
            }
            System.out.println(end);
        }
    }
}