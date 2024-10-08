import java.io.*;

public class Main {
    static int max = 1;
    static boolean[] visited;
    static boolean isCarry(int base, int num) {
        while(base > 0 && num > 0) {
            int baselast = base % 10;
            int numlast = num % 10;
            if(baselast + numlast >= 10) return true;
            else {
                base /= 10;
                num /= 10;
            }
        }
        return false;
    }
    static void backtracking(int depth, int count, int value, int[] arr) {
        max = count > max ? count : max;

        if(depth == arr.length) return;
        if(max > arr.length - depth + count) return;

        for(int i = depth; i < visited.length; i++) {
            if(!isCarry(value, arr[i])) {
                backtracking(i + 1, count + 1, value + arr[i], arr);
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
        backtracking(0, 0, 0, arr);
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}