/* 문제
 	N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
 */
import java.util.*;

public class B2738 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt(); // N과 M을 입력받음

		int[][] arr1 = new int[n][m]; // 행렬 A 선언
		int[][] arr2 = new int[n][m]; // 행렬 B 선언

		// 입력 받은 첫번째 행렬을 arr1에 저장
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				arr1[i][j] = sc.nextInt();
			}
		}
		
		// 입력 받은 두번째 행렬을 arr2에 저장
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				arr2[i][j] = sc.nextInt();
			}
		}
		
		// 행렬의 합을 구하여 출력
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(arr1[i][j]+arr2[i][j]+" ");
			}
			System.out.println();
		}

	}
}