import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by wangshuyang on 2017/4/7.
 */
public class MaxScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        while ((line = reader.readLine()) != null) {
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] score = new int[N + 1];
            if ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line);
                for (int i = 1; i <= N; i ++) {
                    score[i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < M; i++) {
                if ((line = reader.readLine()) != null) {
                    st = new StringTokenizer(line);
                    String method = st.nextToken();
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (method.equals("Q")) {
                        int max = max(a, b, score);
                        System.out.println(max);
                    } else {
                        score[a] = b;
                    }
                }
            }
        }
    }

    public static int max(int start, int end, int[] student) {
        if (start > end) {
            return max(end, start, student);
        } else {
            int max = student[start];
            for (int i = start + 1; i <= end; i++) {
                if (student[i] > max) {
                    max = student[i];
                }
            }
            return max;
        }
    }
}
