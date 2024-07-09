import java.util.*;
import java.io.*;

public class Main {

    // swap
    static void swap(int nodes[], int a, int b) {

        // 교환 수행
        int mock = nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = mock;
    }

    // heapify
    static void heapify(int nodes[], int n, int idx) {
        
        // 현재 노드 가장 큰 값으로 설정
        int largest = idx;

        // 왼쪽, 오른쪽 자식 노드 설정
        int left = idx*2;
        int right = idx*2+1;

        // 왼쪽 노드가 범위 내이면서 현재 노드보다 더 큰 경우비교
        if(left<=n && nodes[left]>nodes[largest])
            largest = left;

        // 오른쪽 노드가 범위 내이면서 현재 노드보다 더 큰 경우
        if(right<=n && nodes[right]>nodes[largest])
            largest = right;

        // 큰 값이 현재 노드가 아닌 경우
        if(largest!=idx) {
            
            // 현재 노드와 큰 값으로 설정된 노드 교환
            swap(nodes,idx,largest);

            // 큰 값으로 설정된 위치 대상으로 heapify
            heapify(nodes,n,largest);
        }
    }

    // 힙 정렬 수행 메서드
    static void heapSort(int nodes[], int n) {

        // n/2 ~ 1번째까지 heapify 수행
        for(int i=n/2; i>0; i--) {
            heapify(nodes,n,i);
        }

        // n ~ 2까지 정렬 수행 (마지막에 남은 1은 교환 필요성X)
        for(int i=n; i>1; i--) {

            // 최댓값 정렬
            swap(nodes,1,i);

            // 1번째 대상 heapify 수행 (최댓값을 정렬한 상태이므로, n-1 상태로 수행)
            heapify(nodes,i-1,1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 노드 배열 생성
        int nodes[] = new int[n+1];

        // 노드 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        // 힙 정렬 수행
        heapSort(nodes,n);

        // 결과 출력
        for(int i=1; i<nodes.length; i++)
            System.out.print(nodes[i]+" ");
    }
}