package day8_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963 {
    // 움직이는 X,Y 좌표 (위에서부터 시계방향)
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,1,1,1,0,-1,-1,-1};
    // 방문 기록 저장 배열
    static boolean [][] visited;
    //데이터 저장 배열
    static int [][] arr;

    static int w,h,count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while(w != 0 && h != 0){ // 마지막 입력 0 0 을 받을 때 까지 반복
            arr = new int [h][w];
            visited = new boolean[h][w];
            count=0;

            // 해당 테스트 케이스 입력받기
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // BFS를 통해서 섬의 개수 구하기
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && arr[i][j]==1){ // 방문 X 이고 1(섬)인 경우
                        count++;
                        BFS(i,j);
                    }
                }
            }
            System.out.println(count);

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        
        while(!queue.isEmpty()){ 
            int now[] = queue.poll();

            for(int k=0; k<8; k++){ // k의 범위  
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx>=0 && nx<h && ny>=0 && ny<w ){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
