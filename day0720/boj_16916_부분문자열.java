import java.util.*;
import java.io.*;

//day0322 오후 강의 다시 듣기
//주의해야할점 idx++ 하지말기; (lis 같은 이유)

public class boj_16916_부분문자열 {

    public static void main(String[] args) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int result = KMP(S, P);
        System.out.println(result);
    }

    static int[] makeFail(String pattern) {
        int[] fail = new int[pattern.length()];

        int idx = 0;
        for (int i = 1; i < fail.length; i++) {
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = fail[idx - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                fail[i] = idx;
            }

        }
        return fail;
    }

    static int KMP(String sequence, String pattern) {
        int[] fail = makeFail(pattern);

        int idx = 0;

        for (int i = 0; i < sequence.length(); i++) {
            while (idx > 0 && sequence.charAt(i) != pattern.charAt(idx)) {
                idx = fail[idx - 1];
            }

            if (sequence.charAt(i) == pattern.charAt(idx)) {
                if (idx == pattern.length() - 1) {
                    return 1;
                } else {
                    idx += 1;
                }
            }

        }

        return 0;
    }

}
