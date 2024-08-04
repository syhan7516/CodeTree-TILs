import java.util.*;
import java.io.*;

// 위치 클래스
class Point implements Comparable<Point> {
    int y;
    int x;

    public Point(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int compareTo(Point other) {
        if(this.x==other.x)
            return this.y-other.y;
        return this.x-other.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // TreeSet 생성
        TreeSet<Point> treeSet = new TreeSet<>();

        // 점의 개수, 질의 개수 입력
        st = new StringTokenizer(br.readLine());
        int dotCnt = Integer.parseInt(st.nextToken());
        int orderCnt = Integer.parseInt(st.nextToken());

        // 점 정보 입력
        for(int i=0; i<dotCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            treeSet.add(new Point(x,y));
        }

        // 질의 입력
        for(int i=0; i<orderCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 질의 결과
            Point point = new Point(x,y);
            if(treeSet.ceiling(point)==null) sb.append(-1).append(" ").append(-1);
            else {
                point = treeSet.ceiling(point);
                sb.append(point.x).append(" ").append(point.y);
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}