import java.util.*;
import java.io.*;

// 바람 클래스
class Windy {
    int rowNum;
    int dir;

    public Windy(int rowNum, int dir) {
        this.rowNum = rowNum;
        this.dir = dir;
    }
}

public class Main {

    // 가로, 세로 크기, 바람부는 횟수
    public static int rowSize, colSize, windyCnt;

    // 격자
    public static int map[][];

    // 바람 저장 큐
    public static Queue<Windy> queue;

    // 바람 방문 여부 배열
    public static boolean visited[];

    // 바람 전파 방향
    public static int nextRow[] = {1,-1};

    // 전파 가능성 확인 메서드
    public static void spread(int point, int dir) {

        // 동일 숫자 여부
        boolean flag = false;

        // 바람 전파 방향 확인
        for(int d=0; d<2; d++) {
            
            flag = false;
            int nr = point+nextRow[d];

            // 범위 확인
            if(nr<0 || nr>rowSize-1) continue;

            // 이미 방문한 경우
            if(visited[nr]) continue;

            // 동일한 숫자가 있는지 확인
            for(int i=0; i<colSize; i++) {
                if(map[point][i]==map[nr][i]) {
                    flag = true;
                    break;
                }
            }

            // 동일한 숫자가 있는 경우
            if(flag) {
                queue.offer(new Windy(nr,dir*-1));
                visited[nr] = true;
            }
        }   
    }

    // 왼쪽 바람
    public static void left(int point ,int dir) {

        // 임시 변수
        int mock = map[point][colSize-1];

        // 숫자 이동
        for(int i=colSize-1; i>0; i--)
            map[point][i] = map[point][i-1];
        map[point][0] = mock;

        // 전파 가능성 확인
        spread(point,dir);
    }

    // 오른쪽 바람
    public static void right(int point, int dir) {

        // 임시 변수
        int mock = map[point][0];

        // 숫자 이동
        for(int i=0; i<colSize-1; i++)
            map[point][i] = map[point][i+1];
        map[point][colSize-1] = mock;

        // 전파 가능성 확인
        spread(point,dir);
    }

    // 바람 불기
    public static void solve() {

       // 바람, 전파가 멈출 때까지 수행
       while(!queue.isEmpty()) {

            // 현재 바람
            Windy current = queue.poll();

            // 왼쪽 바람인 경우
            if(current.dir==-1) left(current.rowNum,current.dir);

            // 오른쪽 바람인 경우
            else right(current.rowNum,current.dir);
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기, 바람부는 횟수 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        windyCnt = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 바람 저장 큐 생성
        queue = new LinkedList<>();
        
        // 바람 정보 입력
        for(int i=0; i<windyCnt; i++) {

            st = new StringTokenizer(br.readLine());
            int rowNum = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().charAt(0)=='L' ? -1 : 1;

            // 입력된 바람 처리
            visited = new boolean[rowSize];
            visited[rowNum-1] = true;
            queue.offer(new Windy(rowNum-1,dir));
            solve();
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}