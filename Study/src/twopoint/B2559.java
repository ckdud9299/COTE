import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫번째 줄(N M) st에 저장

		int n = Integer.parseInt(st.nextToken()); // int형으로 변환하여 n에 저장
		int k = Integer.parseInt(st.nextToken()); // int형으로 변환하여 k에 저장

		long [] arr = new long[n+1];
		st = new StringTokenizer(br.readLine());  // 두번째 줄(배열) st에 저장

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken()); // int형을 변환하여 arr에 저장
		}

		int max = Integer.MAX_VALUE;

		// 10 2 -> 9번, 10 3 -> 8번, 10 4 ->7번, 10 5 -> 6번 => n-k+1
		for(int i=0; i<n-k+1; i++){
			int sum = 0;
			for(int j=i; j<i+k; j++){
				sum += arr[j];
			}
			if(sum>max){
				max = sum;
			}
		}

		System.out.println(max);

	}
}
