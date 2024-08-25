import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n + 2];
        for(int i = 0; i < k; i++) {
            String[] inputNum = br.readLine().split(" ");
            int start = Integer.parseInt(inputNum[0]);
            int end = (Integer.parseInt(inputNum[1]));

            arr[start]++;
            arr[end + 1]--;
        }

        for(int i = 0; i < n ; i++) {
            arr[i + 1] += arr[i];
        }

        int[] newArr = new int[n];
        for(int i = 0; i < n; i++) {
            newArr[i] = arr[i + 1];
        }

        Arrays.sort(newArr);

        bw.write(newArr[newArr.length / 2] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}