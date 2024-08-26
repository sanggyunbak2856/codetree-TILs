import java.io.*;
import java.util.*;

public class Main {
    static int countNum(Set<Integer> set, List<Integer> list) {
        int max = 0;
        for(Integer i : set) {
            List<Integer> newList = new ArrayList<>(list);
            while(newList.contains(i)) {
                newList.remove(i);
            }
            if(newList.isEmpty()) continue;
            int count = 0;
            int curNum = newList.get(0);
            for(Integer p : newList) {
                if(p.equals(curNum)) {
                    count++;
                    max = count > max ? count : max;
                }
                else {
                    curNum = p;
                    count = 1;
                    max = count > max ? count : max;
                }
            }

        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<Integer> ();

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            numList.add(x);
        }

        Set<Integer> numSet = new HashSet<Integer>(numList);

        int result = countNum(numSet, numList);
        bw.write(result + "");
        bw.flush();

        br.close();
        bw.close();
    }
}