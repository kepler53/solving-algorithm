import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_3005_크로스워드퍼즐쳐다보기 {

    static int R, C;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = { 0, 1 };
    static int[] dy = { 1, 0 };
    // static String[] words;
    // static int cnt;
    static ArrayList<String> words;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C][2];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // for (int i = 0; i < R; i++) {
        // for (int j = 0; j < C; j++) {
        // System.out.print(map[i][j] + " ");
        // }
        // System.out.println();
        // }

        // cnt = 0;
        // words = new String[R * C];
        words = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#') {
                    for (int k = 0; k < 2; k++) {
                        if (!visited[i][j][k]) {
                            makeWord(i, j, k);
                        }
                    }
                }
            }
        }

        // Arrays.sort(words);
        Collections.sort(words);
        System.out.println(words.get(0));

    }

    static void makeWord(int row, int col, int dir) {
        visited[row][col][dir] = true;
        String word = "" + map[row][col];

        // System.out.println(row + " " + col);

        int nextX = row + dx[dir];
        int nextY = col + dy[dir];
        // 왜 row를 col이라고 했을까 그래서 index bound error 계속 남

        // System.out.println(word + " " + nextX + " " + nextY);

        while (nextX < R && nextY < C && map[nextX][nextY] != '#') {
            // if (nextX >= R - 1 || nextY >= C - 1 || map[nextX][nextY] == '#') {
            // break;
            // }
            visited[nextX][nextY][dir] = true;
            word += map[nextX][nextY];
            nextX += dx[dir];
            nextY += dy[dir];
            // System.out.println(nextX + " " + nextY);

            // System.out.println(word);
        }

        // word의 길이가 2 이상이면 어디다가 저장하지? String 배열? 이런게 있나? ArrayList?
        if (word.length() >= 2) {
            words.add(word);
        }
    }

}

// 풀면서 느낀 점 : 설계 잘하고 풀자, 눈으로 풀지 말자..... => 더 오래걸린다.
