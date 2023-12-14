import java.util.*;

public class WordPuzzle extends MapManagement {
    Helper helper = new Helper();
    Map<Integer, String> words = new HashMap<>();
    int col = getCol();
    int row = getRow();

    void input() {
        int sl_tu = 0, sl_kitu = 0;
        int border = col * row;
        Scanner sc = new Scanner(System.in);
        while (sl_kitu < 16) {
            System.out.format("Nhập từ ( %d kí tự còn lại) : %n", border - sl_kitu);
            String new_word = sc.nextLine();
            if (border - new_word.length() < 0) {
                System.out.println("Từ dài quá bro, nhập từ ngắn hơn đi.");
            } else {
                sl_tu++;
                words.put(sl_tu, new_word);
                sl_kitu += new_word.length();
            }
        }
        createMap(words);
    }

    void createMap(Map<Integer, String> words) {
        addWord(words.get(1));
//        for (Map.Entry<Integer, String> entry : words.entrySet()) {
//            try {
//                addWord(entry.getValue());
//            }catch (Exception e){
//            }
//        }
    }

    void addWord(String w) {
        boolean flag = false;
        int start_col, start_row;
        int[] nextMove = new int[]{};
        do {
            start_row = helper.random(row) - 1;
            start_col = helper.random(col) - 1;

            if (used[start_col][start_row] == 0) {
                nextMove = helper.checkCurrentPosition(start_col, start_row, w.charAt(0));
                if(nextMove != null){
                    flag = true;
                }
            }
        } while (!flag);

        for (int i = 1; i < w.length(); i++) {
            start_col = nextMove[0];
            start_row = nextMove[1];
            Character c = w.charAt(i);
            nextMove = helper.checkCurrentPosition(start_col, start_row, c);
        }
    }

    public void show_map() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.format("%-5c", map[i][j]);
            }
            System.out.println();
        }
    }

    public void show_words() {
        for (Map.Entry<Integer, String> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
