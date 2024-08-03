import java.util.*;
import java.io.*;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 트리 맵 생성
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // 명령 수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령 확인
        for(int i=0; i<orderCnt; i++) {

            // 명령 입력
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 명령 수행
            switch(order) {

                // add
                case "add":
                treeMap.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                break;

                // remove
                case "remove":
                treeMap.remove(Integer.parseInt(st.nextToken()));
                break;

                // find
                case "find":
                int key = Integer.parseInt(st.nextToken());
                if(treeMap.containsKey(key)) System.out.println(treeMap.get(key));
                else System.out.println("None");
                break;

                // print
                case "print_list":
                if(treeMap.isEmpty()) System.out.println("None");
                else {
                    Iterator<Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
                    while(iterator.hasNext()) {
                        Entry<Integer, Integer> entry = iterator.next();
                        System.out.print(entry.getValue()+" ");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }
}