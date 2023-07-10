package day3_queue;
  
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] bulbs = new int[N];
        for (int i = 0; i < N; i++) {
            bulbs[i] = scanner.nextInt();
        }

        int result = turnOffBulbs(N, K, bulbs);
        System.out.println(result);
    }

    public static int turnOffBulbs(int N, int K, int[] bulbs) {
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!queue.isEmpty() && queue.peek() == i - K) {
                queue.poll();
            }

            if ((bulbs[i] + count) % 2 == 1) {
                if (i + K > N) {
                    return -1;
                }
                queue.offer(i);
                count++;
            }
        }

        return queue.isEmpty() ? count : -1;
    }
}