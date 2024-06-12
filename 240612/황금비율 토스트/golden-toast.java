import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 식빵의 개수, 암호문 수 입력
        st = new StringTokenizer(br.readLine());
        int breadCnt = Integer.parseInt(st.nextToken());
        int orderCnt = Integer.parseInt(st.nextToken());

        // 식빵의 상태 입력
        String bread = br.readLine();

        // 연결 리스트 생성
        LinkedList<Character> l = new LinkedList<>();
        
        // 입력
        for(int i=0; i<bread.length(); i++)
            l.offer(bread.charAt(i));

        // 연결 리스트 반복자 생성
        ListIterator<Character> iterator = l.listIterator(l.size());

        // 암호문 수행
        for(int i=0; i<orderCnt; i++) {

            // 명령 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 수행
            switch(order) {

                case "L":
                if(iterator.hasPrevious()) iterator.previous();
                break;

                case "P":
                iterator.add(st.nextToken().charAt(0));
                break;

                case "R":
                if(iterator.hasNext()) iterator.next();
                break;

                case "D":
                if(iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                break;
            }
        }

        // 출력
        ListIterator<Character> print = l.listIterator();
        while(print.hasNext())
            System.out.print(print.next());
    }
}