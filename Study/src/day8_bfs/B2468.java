package day8_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468 {
    // 움직이는 X,Y 좌표 (상우하좌 순)
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    // 방문 기록 저장 배열
    static boolean [][] visited;
    //데이터 저장 배열
    static int [][] arr;

    static int N, count;
    static int maxHeight=0;
    static int maxArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 크기 N 입력 받기  
        N = Integer.parseInt(st.nextToken()); 

        // 입력받은 크기의 2차원 배열 선언
        arr = new int [N][N];

        // 높이 정보 입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 최대 높이를 찾음 (for문 반복횟수 줄일 수 있음)
                if(arr[i][j] > maxHeight){
                    maxHeight = arr[i][j];
                }
            }
        }

        // 물 높이 0부터 최대 높이까지 증가시키면서 bfs를 이용해 최대 영역 개수 구하기
        for(int h=0; h<=maxHeight; h++){
            count = 0;

            visited = new boolean[N][N]; // 방문 배열 초기화

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && arr[i][j] > h){ // 방문 X 이고 물 높이보다 높은 경우
                        count++;
                        BFS(i,j,h);
                    }
                }
            }

            // maxArea에 안전한 영역의 최대 개수 저장
            if(count > maxArea){
                maxArea = count;
            }
        }

        System.out.println(maxArea);

    }

    private static void BFS(int i, int j, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();

            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx>=0 && nx<N && ny>=0 && ny<N ){
                    if(arr[nx][ny] > h && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
