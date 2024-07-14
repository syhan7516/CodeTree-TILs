import java.util.*;
import java.io.*;

public class Main {

    // 블록 정보 배열
    public static int block[][][] = {
        {{0,0},{1,0},{1,1}},{{1,0},{1,1},{0,1}},
        {{0,0},{0,1},{1,1}},{{0,0},{0,1},{1,0}},
        {{0,0},{0,1},{0,2}},{{0,0},{1,0},{2,0}}};

    // 블록 확인 메서드
    public static int solve(int map[][], int rowSize, int colSize) {
        
        // 최대값
        int maxValue = 0;

        // 격자에 블록 넣기
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {

                // 블록 차례대로 확인
                for(int k=0; k<block.length; k++) {

                    // 범위 내 넣기 성공 여부
                    boolean flag = false;
                    
                    // 블록 값
                    int value = 0;

                    for(int l=0; l<3; l++) {

                        // 블록 위치
                        int ny = i+block[k][l][0];
                        int nx = j+block[k][l][1];

                        // 범위 확인
                        if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) {
                            flag = true;
                            break;
                        }

                        // 해당 위치 값 더하기
                        value += map[ny][nx];
                    }

                    // 최대값 갱신
                    if(!flag) maxValue = Math.max(maxValue,value);
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        // 격자 생성
        int map[][] = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 블록 확인
        int answer = solve(map,rowSize,colSize);

        // 결과 출력
        System.out.println(answer);
    }
}