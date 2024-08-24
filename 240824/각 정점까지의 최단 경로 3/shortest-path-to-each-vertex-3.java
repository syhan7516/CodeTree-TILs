import java.util.*;
import java.io.*;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int node;
    int value;

    public Edge(int node, int value) {
        this.node = node;
        this.value = value;
    }

    public int compareTo(Edge other) {
        return this.value-other.value;
    }
}


public class Main {

    // 정점 개수, 간선 개수
    public static int nodeCnt, edgeCnt;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 거리 배열
    public static int path[];

    // 거리 정보 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 최단 거리 구하기 메서드
    public static void solve(int start) {

        // 거리 정보 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 시작 지점 설정
        path[start] = 0;
        queue.offer(new Edge(start,path[start]));

        // 거리 탐색
        while(!queue.isEmpty()) {

            // 가장 최단인 간선 확인
            Edge current = queue.poll();
            int curNode = current.node;
            int curDist = current.value;

            // 해당 정점과 연결된 정점 확인
            for(int i=0; i<relation.get(curNode).size(); i++) {

                // 연결된 정점
                Edge connect = relation.get(curNode).get(i);
                int conNode = connect.node;
                int conDist = connect.value;

                // 거리 비교
                if(path[conNode]>curDist+conDist) {
                    path[conNode] = curDist+conDist;
                    queue.offer(new Edge(conNode,path[conNode]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성, 초기화
        relation = new ArrayList<>();
        for(int i=0; i<=nodeCnt; i++)
            relation.add(new ArrayList<>());

        // 거리 배열 생성, 초기화
        path = new int[nodeCnt+1];
        for(int i=1; i<=nodeCnt; i++)
            path[i] = (int)1e9;

        // 관계 정보 입력
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relation.get(start).add(new Edge(end,value));
        }

        // 최단 거리 구하기
        solve(1);

        // 결과 출력
        for(int i=2; i<=nodeCnt; i++) {
            if(path[i]==(int)1e9) System.out.println(-1);
            else System.out.println(path[i]);
        }
    }
}