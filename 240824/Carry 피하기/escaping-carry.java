import java.util.*;
import java.io.*;


public class Main {
    static int max = 1;
    static boolean[] visited;
    static ArrayList<Integer> makeNumList(int num) { // 수를 한자리수씩 뺌
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int tmpNum = num;
        while(true) {
            if(tmpNum > 10) {
                int r = tmpNum % 10;
                numList.add(r);
                tmpNum /= 10;
            }
            else {
                numList.add(tmpNum);
                break;
            }
        }
        return numList;
    }
    static boolean isCarry(int base, int num) {
        ArrayList<Integer> baseList = makeNumList(base);
        ArrayList<Integer> numList = makeNumList(num);

        int smaller = baseList.size() < numList.size() ? baseList.size() : numList.size();

        for(int i = 0; i < smaller; i++) {
            int sum = baseList.get(i) + numList.get(i);

            if(sum >= 10) return true;
        }
        return false;
    }
    static void dfs(int[] arr, int currentValue, int currentCount) {
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            if(isCarry(arr[i], currentValue)) continue;
            else {
                visited[i] = true;
                currentCount+=1;
                currentValue+=arr[i];
                max = currentCount > max ? currentCount : max;
                dfs(arr, currentValue, currentCount);
                currentCount-=1;
                currentValue-=arr[i];
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(arr, 0, 0);
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}