import java.util.*;
import java.io.*;

// 위치 클래스
class Point implements Comparable<Point> {
    int x;
    int y;
    int sum;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.sum = Math.abs(this.x) + Math.abs(this.y);
    }

    public int compareTo(Point other) {
        
        // 거리가 같은 경우
        if(this.sum==other.sum) {

            // x가 같은 경우
            if(this.x==other.x) return this.y - other.y;

            return this.x - other.x;
        }

        return this.sum - other.sum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 우선 순위 큐 생성
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // 좌표 개수와 연산 개수 입력
        st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int orderCnt = Integer.parseInt(st.nextToken());

        // 좌표 입력
        for(int i=0; i<pointCnt; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 큐 삽입
            pq.add(new Point(x,y));
        }

        // 연산 개수만큼 수행
        for(int i=0; i<orderCnt; i++) {

            // 가까운 좌표 제거
            Point point = pq.poll();

            // 2씩 더하기
            pq.add(new Point(point.x+2,point.y+2));
        }

        // 결과 출력
        System.out.println(pq.peek().x+" "+pq.peek().y);
    }
}