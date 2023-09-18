package day7_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
    static int m, n, k;
    static int arr [][];
    static boolean visited[][];
    static int dirX[] = {0, 0, -1, 1};
    static int diry[] = {-1, 1, 0, 0};
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            visited = new boolean[m][n];
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            count = 0;
            for(int a=0; a<m; a++){
                for(int b=0; b<n; b++){
                    if(!visited[a][b] && arr[a][b]==1){
                        count++;
                        DFS(a,b);
                    }
                }
            }

            System.out.println(count);
        }

    }
    private static void DFS(int x, int y){
        visited[x][y] = true;

        for (int i=0; i<4; i++){
            int nx = x + dirX[i];
            int ny = y + diry[i];

            if(nx>=0 && nx<m && ny>=0 && ny<n){
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    DFS(nx,ny);
                }
            }
        }
    }
}
