package day8_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    static boolean [][] visited;
    static int [][] A;
    static int N, M, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int [M][N];
        visited = new boolean [M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(A[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
                if(A[i][j] > max){
                    max = A[i][j];
                }

            }
        }

        System.out.println(max-1);


    }
    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();

        for(int a=0; a<M; a++){
            for(int b=0; b<N; b++){
                if(A[a][b] == 1){
                    visited[a][b] = true;
                    queue.offer(new int[] {a,b});
                }
            }
        }

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx>=0 && nx<M && ny>=0 && ny<N ){
                    if(A[nx][ny] == 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        A[nx][ny] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
