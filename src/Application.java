import java.util.Scanner;

public class Application {
    static int N;
    static int[] x = new int[100];
    static int[] used = new int[100];

    static void inkq() {
        for (int i = 1; i <= N; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
    }

    static void Try(int i) {
        for (int j = 1; j <= N; j++) {
            if (used[j] == 0) {
                x[i] = j;
                used[j] = 1;
                if (i == N) {
                    inkq();
                } else {
                    Try(i + 1);
                }
                used[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        WordPuzzle_temp wordPuzzle = new WordPuzzle_temp();
        wordPuzzle.input();
//        Try(1);
    }
}
