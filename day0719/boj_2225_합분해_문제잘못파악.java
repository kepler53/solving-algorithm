import java.util.Scanner;

public class boj_2225_합분해_문제잘못파악 {

    static int N, K;
    static long p = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 아이디어 스케치한 내용 nHr = n+r-1 C n-1이므로 이렇게 치환하고 페르마 소정리 이용해서 풀기 !!
        N = sc.nextInt();
        K = sc.nextInt();

        long a = 1;
        long b = 1;

        // (n+r-1)! / (n-1)!*r!
        // K+N-1 C K-1
        long t = Math.min(K - 1, N);

        for (int i = 0; i < t; i++) {
            a = a * (N + K - 1 - i) % p;
            b = b * (t - i) % p;
        }
        long ans = (a % p * div(b, p - 2) % p) % p;
        System.out.println(ans);
    }

    static long div(long a, long b) {
        if (b == 1)
            return a;
        long tmp = div(a, b / 2);
        if (b % 2 == 1)
            return tmp * tmp % p * a % p;
        else
            return tmp * tmp % p;
    }

}
