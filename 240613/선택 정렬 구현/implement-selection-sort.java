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

        // 선택 정렬 수행
        for(int i=0; i<cnt-1; i++) {

            // 숫자 하나 선택
            int min = i;

            // 비교
            for(int j=i+1; j<cnt; j++) {

                // 기준 수가 더 큰 경우
                if(nums[min]>nums[j])
                    min = j;
            }

            // 배치
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }

        // 출력
        for(int i=0; i<cnt; i++)
            System.out.print(nums[i]+" ");
    }
}