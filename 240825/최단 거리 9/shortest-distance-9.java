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
        return this.value - other.value;
    }
}

public class Main {

    // 정점, 간선 개수
    public static int nodeCnt, edgeCnt;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 거리 배열
    public static int dist[];

    // 경로 배열
    public static int path[];

    // 최단 거리 구하기 메서드
    public static void solve(int startNode) {

        // 간선 관리 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 경로 배열 생성
        path = new int[nodeCnt+1];

        // 시작 지점 처리
        dist[startNode] = 0;
        queue.offer(new Edge(startNode,0));

        // 경로 탐색
        while(!queue.isEmpty()) {

            // 기준 정점
            Edge current = queue.poll();
            int curNode = current.node;
            int curDist = current.value;

            // 연결 정점 확인
            for(int i=0; i<relation.get(curNode).size(); i++) {

                // 연결 정점
                Edge connect = relation.get(curNode).get(i);
                int conNode = connect.node;
                int conDist = connect.value;

                // 거리 비교
                if(dist[conNode]>curDist+conDist) {
                    dist[conNode] = curDist+conDist;
                    queue.offer(new Edge(conNode,dist[conNode]));
                    path[conNode] = curNode;
                }
            }
        }
    }

    // 결과 저장 메서드
    public static String getResult(int endNode) {

        // 빌더 생성
        StringBuilder sb = new StringBuilder();

        // 결과 저장 리스트 생성
        ArrayList<Integer> result = new ArrayList<>();

        // 경로 역탐색
        int mock = endNode;
        while(true) {
            result.add(mock);
            mock = path[mock];
            if(mock==0) break;
        }

        // 결과 저장
        sb.append(dist[endNode]).append("\n");
        for(int i=result.size()-1; i>=0; i--)
            sb.append(result.get(i)).append(" ");

        return sb.toString();
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
        dist = new int[nodeCnt+1];
        for(int i=1; i<=nodeCnt; i++)
            dist[i] = (int)1e9;

        // 관계 정보 입력
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            relation.get(s).add(new Edge(e,d));
            relation.get(e).add(new Edge(s,d));
        }

        // 시작 지점, 도착 지점 입력
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        // 최단 거리 구하기
        solve(startNode);

        // 결과 출력
        System.out.println(getResult(endNode));
    }
}