package array;


import java.util.Scanner;

public class B10798 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char [][] arr = new char[5][15]; // 5줄 입력 & 최대 15개 입력 이므로 5X15 크기의 배열 선언

		for(int i=0; i<5; i++){
			String str = sc.nextLine(); // 한 줄 전체를 가져오기

			for(int j=0; j<str.length(); j++){
				arr[i][j] = str.charAt(j); // 가져온 str을 나눠서 배열에 저장
			}
		}

		// (0,0) (1,0) (2,0) (3,0) (4,0) (0,1) ... 순으로 출력하기
		for(int i=0; i<15; i++){
			for(int j=0; j<5; j++){
				if(arr[j][i] == 0){ // 아스키코드에서 null이 0
					continue;
				} 
				System.out.print(arr[j][i]);
			}
		}

		sc.close();

	}
}