import java.util.Scanner;

public class B1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람의 수

        int arr [] = new int [N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int result [] = new int[N];

        for(int i=0; i<N; i++){
            int check = 0; // result 배열의 0인 값의 갯수

            for(int j=0; i<N; j++){
                if(result[j] == 0) {
                    check++;

                    if (check == arr[i] + 1) {
                        result[j] = i + 1;
                        break;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.print(result[i]+" ");
        }
    }
}
