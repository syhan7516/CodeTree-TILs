import java.util.*;
import java.io.*;

public class Main {

    // 최대 값 구하기 메서드
    public static int getMaxPrefixSum(int size, int range, int map[][], int prefixSum[][]) {

        // 최대 값
        int max = 0;

        // 누적합 순회
        for(int i=range; i<=size; i++) {
            for(int j=range; j<=size; j++) {
                int sum = prefixSum[i][j]-prefixSum[i-1][j]-prefixSum[i][j-1]+prefixSum[i-1][j-1];
                max = Math.max(max,sum);
            }
        }

        return max;
    }

    // 누적합 구하기 메서드
    public static void getPrefixSum(int size, int map[][], int prefixSum[][]) {

        // 격자 순회
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                prefixSum[i][j] 
                    = prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1]+map[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 격자 크기, 확인 범위 입력
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        // 격자 배열, 누적합 배열 생성
        int map[][] = new int[size+1][size+1];
        int prefixSum[][] = new int[size+1][size+1];

        // 격자 정보 입력
        for(int i=1; i<=size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } 

        // 누적합 구하기
        getPrefixSum(size,map,prefixSum);

        // 최대 값 구하기
        answer = getMaxPrefixSum(size,range,map,prefixSum);

        // 결과 출력
        System.out.println(answer);
    }
}