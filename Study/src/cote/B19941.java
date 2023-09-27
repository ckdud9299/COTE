package cote;

import java.util.Scanner;

public class B19941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        String str = sc.next();

        char arr [] = new char [N];

        for(int i=0; i<N; i++){
            arr[i] = str.charAt(i);
        }

        int count = 0;

        for(int i=0; i<N; i++){
            if(arr[i] == 'P'){
                for(int j=i-K; j<=i+K; j++){
                    if(j >=0 && j < N && arr[j] == 'H'){
                        arr[j] = 'X';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}


