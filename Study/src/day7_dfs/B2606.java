package day7_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2606 {
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 수 입력받기
        int n = Integer.parseInt(br.readLine());
        // 컴퓨터의 쌍의 수 입력받기
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        A = new ArrayList[n+1];

        for(int i=1; i<n+1; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer((br.readLine()));
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        DFS(1);

        int count = 0;
        for(int i=1; i<n+1; i++){
            if(visited[i] == true){
                count++;
            }
        }

        System.out.println(count-1);

    }

    private static void DFS(int v) {
        visited[v] = true;

        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
