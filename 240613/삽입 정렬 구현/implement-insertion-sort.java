import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 개수 입력
        int cnt = Integer.parseInt(st.nextToken());

        // 숫자 저장 배열 생성
        int nums[] = new int[cnt];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬 수행
        for(int i=1; i<cnt; i++) {
            
            // 비교 시작 인덱스, 삽입 값 설정
            int index = i-1;
            int key = nums[i];

            // 다른 요소 확인
            while(index>=0 && nums[index]>key) {
                nums[index+1] = nums[index];
                index--;
            }

            nums[index+1] = key;
        }

        // 출력
        for(int i=0; i<cnt; i++)
            System.out.print(nums[i]+" ");

    }
}