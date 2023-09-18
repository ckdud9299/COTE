package day5_quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24091 {
static int cnt=0;
	
	public static void quick_sort(int[] a, int p, int r, int k) {
		
		if(p < r) {
			int q = partition(a,p,r,k);
			quick_sort(a,p,q-1,k);
			quick_sort(a,q+1,r,k);
		}
	}
	public static int partition(int a[], int p, int r, int k) {
		int x = a[r];
		int i = p-1;
		
		for(int j=p; j<r; j++) {
			if(a[j] <= x) {
				int temp = a[++i];
				a[i] = a[j];
				a[j] = temp;
				
				cnt ++;
				if(cnt == k) {
					for(int z=0; z<a.length; z++) {
						System.out.print(a[z]+" ");
					}
					System.out.println();
				}
			}
		}
		
		if(i+1 != r) {
			int temp = a[i+1];
			a[i+1] = a[r];
			a[r] = temp;
			
			cnt ++;
			if(cnt == k) {
				for(int z=0; z<a.length; z++) {
					System.out.print(a[z]+" ");
				}
				System.out.println();
			}
		}
		
		return i+1;
		
	}
	
	
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
        
        quick_sort(arr, 0, arr.length-1,k);
        
        if(cnt<k) {
        	System.out.println("-1");
        }
        
	}

}
