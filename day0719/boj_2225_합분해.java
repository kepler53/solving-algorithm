import java.util.Scanner;

public class boj_2225_합분해 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[201][201];

        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
        }
        // for (int i = 1; i <= N; i++) {
        // dp[1][i] = 1;
        // }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
                // dp[i][N] += dp[i - 1][j];
                // dp[i][N] = dp[i][N] % 1000000000;
            }
        }

        // for (int i = 0; i < 201; i++) {
        // for (int j = 0; j < 201; j++) {
        // System.out.printf("%2d", dp[i][j]);
        // }
        // System.out.println();
        // }

        System.out.println(dp[K][N]);
    }
}