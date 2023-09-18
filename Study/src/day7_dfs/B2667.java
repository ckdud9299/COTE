package day7_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2667 {
    static int n;
    static int arr [][];
    static boolean visited[][];
    static ArrayList<Integer> A = new ArrayList<>();
    static int dirX[] = {0, 0, -1, 1};
    static int diry[] = {-1, 1, 0, 0};
    static int count, total=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int [n][n];
        visited = new boolean [n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = str.charAt(j) -'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count=0;
                if(!visited[i][j] && arr[i][j] == 1){
                    total++;
                    count++;
                    DFS(i,j);
                    A.add(count);

                }
            }
        }

        System.out.println(total);
        Collections.sort(A);
        for(int i=0; i<A.size(); i++){
            System.out.println(A.get(i));
        }

    }

    private static void DFS(int x, int y){
        visited[x][y] = true;

        for (int i=0; i<4; i++){
            int nx = x + dirX[i];
            int ny = y + diry[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    DFS(nx,ny);
                    count++;
                }
            }
        }
    }
}

