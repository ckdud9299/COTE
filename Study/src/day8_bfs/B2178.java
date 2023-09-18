package day8_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [][] visited;
    static int [][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int [N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        BFS(0,0);

        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            visited[i][j] = true;

            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx>=0 && nx<N && ny>=0 && ny<M ){
                    if(A[nx][ny]!=0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        A[nx][ny] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
