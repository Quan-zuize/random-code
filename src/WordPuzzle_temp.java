import java.util.*;

public class WordPuzzle_temp extends MapManagement {
    Helper_temp helper = new Helper_temp();
    Map<Integer, String> words = new HashMap<>();
    int col = getCol();
    int row = getRow();

    void input() {
        int sl_tu = 0;
        int border = col * row;
        Scanner sc = new Scanner(System.in);
        while (border > 0) {
            System.out.format("Nhập từ ( %d kí tự còn lại) : %n", border);
            String new_word = sc.nextLine().trim();
            if (border - new_word.length() < 0) {
                System.out.println("Từ dài quá bro, nhập từ ngắn hơn đi.");
            } else {
                border -= new_word.length();
                sl_tu++;
                words.put(sl_tu, new_word);
            }
        }
        show_words();
        createMap(words);
    }

    void createMap(Map<Integer, String> words) {
        String temp_sollution = "";
        for (Map.Entry<Integer, String> entry : words.entrySet()) {
            char[] charArray = entry.getValue().toCharArray();
            for (char c : charArray) {
                temp_sollution = temp_sollution.concat("" + c);
            }
        }

//        addWord(words.get(1));
        addWord(temp_sollution);
    }

    void addWord(String w) {
        boolean flag = false;
        int start_col, start_row;
        do {
            start_row = helper.random(row) - 1;
            start_col = helper.random(col) - 1;

            if (used[start_col][start_row] == 0) {
                helper.checkCurrentPosition(start_col, start_row, w);
                flag = true;
            }
        } while (!flag);
    }

    public void show_words() {
        for (Map.Entry<Integer, String> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
