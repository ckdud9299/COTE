package day1_array;

import java.util.Scanner;

public class B2566 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int [][] arr = new int[9][9]; // 9x9 격자판 이므로 9x9 행렬 선언
		int max = 0;
		int row = 0, column = 0;

		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				arr[i][j] = sc.nextInt(); // 입력받은 수를 행렬에 저장

				if (max < arr[i][j]){ 
					max = arr[i][j]; // 최댓값을 max에 저장
					row = i; // 최댓값의 행을 구하기
					column = j; // 최댓값의 열을 구하기
				}
			}
		}

		System.out.println(max);
		System.out.println((row+1) + " " + (column+1));
		sc.close();
	}
}