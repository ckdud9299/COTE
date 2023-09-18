package day10_greedy;

import java.util.Scanner;

public class B16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        int count = 1;

       while(A != B){
           if(A > B) {
               System.out.println(-1);
               return;
           }

           if(B%2 == 0){
               B /= 2;
           } else if(B%10 == 1) {
               B /= 10;
           } else{
               System.out.println(-1);
               return;
           }

           count++;
       }

        System.out.println(count);

    }
}
