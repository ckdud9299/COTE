import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003{

	public static void main(String[] args) throws IOException{
		
		
		// scan 대신 bufferdreader 사용하는 이유 = 처리속도가 scanner와 차이나기 때문임
		// bufferdreader는 문자열만 받음
		// StringTokenizer는 문자열을 여러개의 토큰으로 분리함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫번째 줄(N M) st에 저장

		int n = Integer.parseInt(st.nextToken()); // int형으로 변환하여 n에 저장
		int m = Integer.parseInt(st.nextToken()); // int형으로 변환하여 m에 저장

		int [] arr = new int[n+1]; 
		st = new StringTokenizer(br.readLine()); // 두번째 줄(배열) st에 저장

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken()); // int형을 변환하여 arr에 저장
		}

		int sum = arr[0];
		int start_index = 0, end_index = 0, count = 0;

		
		while(true){
			if(sum >= m){
				sum -= arr[start_index];
				start_index++;
			}
			else if(end_index == n){
				break;
			}
			else{
				end_index++;
				sum +=arr[end_index];
			}

			if(sum == m){
				count++;
			}
		}

		System.out.println(count);

	}
}
