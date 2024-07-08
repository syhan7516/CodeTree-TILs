import java.util.*;
import java.io.*;

public class Main {

    // 위치 변경 메서드
    static void swap(int nums[], int a, int b) {

        int mock = nums[a];
        nums[a] = nums[b];
        nums[b] = mock;
    }

    // 퀵 정렬 수행 메서드
    static void quickSort(int nums[], int low, int high) {

        // 원소가 두 개 이상일 경우
        if(low<high) {
            
            // 기준점 찾기
            int point = partition(nums,low,high);

            // 좌, 우 분할 및 정렬
            quickSort(nums,low,point-1);
            quickSort(nums,point+1,high);
        }
    }

    // 기준점 찾기 메서드
    static int partition(int nums[], int low, int high) {

        // 기준점 설정
        int pivot = high;

        // 시작점 설정
        int i = low-1;

        // 비교 값 차례로 확인
        for(int j=low; j<high; j++) {

            // 비교 원소가 기준점보다 작은 경우
            if(nums[j]<nums[pivot]) {

                // 큰 값 설정
                i+=1;

                // 큰 값, 작은 값 위치 변경
                swap(nums,i,j);
            }
        }

        // 큰 값과 기준점 값 위치 변경
        swap(nums,i+1,high);
        return i+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 숫자 정보 배열 생성
        int nums[] = new int[n];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 퀵 정렬 수행
        quickSort(nums,0,nums.length-1);

        // 결과 출력
        for(int i: nums) {
            System.out.print(i+" ");
        }
    }
}