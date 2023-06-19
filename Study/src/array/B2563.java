import java.util.Scanner;

public class B2563 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 색종이의 수 n에 저장

		int [][] arr = new int[100][100]; // 도화지의 크기만큼 배열 선언
		int num=0;

		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 한 장의 색종이가 크기가 10x10 색종이 부분의 배열 값을 1로 저장
			for(int j=x; j<x+10; j++){ 
				for(int k=y; k<y+10; k++){
					arr[j][k]=1;
				}
			}
		}
		
		// 배열의 값이 1의 갯수 = 색종이의 넓이
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				if(arr[i][j]==1){
					num++;
				}
			}
		}

		System.out.println(num);

		sc.close();

	}
}