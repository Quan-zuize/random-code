import java.util.*;

public class Helper_temp extends MapManagement {
    int col = getCol();
    int row = getRow();
    Random rand = new Random();
    //Direction for every block
    //middle
    int[] dx_middle = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy_middle = {-1, -1, 0, 1, 1, 1, 0, -1};

    //up-side
    int[] dx_up = {1, 1, 0, -1, -1};
    int[] dy_up = {0, 1, 1, 1, 0};

    //right_side
    int[] dx_right = {0, 0, -1, -1, -1};
    int[] dy_right = {-1, 1, 1, 0, -1};

    //down-side
    int[] dx_down = {0, 1, 1, -1, -1};
    int[] dy_down = {-1, -1, 0, 0, -1};

    //left-side
    int[] dx_left = {0, 1, 1, 1, 0};
    int[] dy_left = {-1, -1, 0, 1, 1};

    //up-left corner
    int[] dx_ul = {1, 1, 0};
    int[] dy_ul = {0, 1, 1};

    //up-right corner
    int[] dx_ur = {0, -1, -1};
    int[] dy_ur = {1, 1, 0};

    //down-left corner
    int[] dx_dl = {0, 1, 1};
    int[] dy_dl = {-1, -1, 0};

    //down-right corner
    int[] dx_dr = {0, -1, -1};
    int[] dy_dr = {-1, 0, -1};

    String[] possibleDirection = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    int random(int range) {
        return rand.nextInt(range) + 1;
    }

    void checkCurrentPosition(int posX, int posY, String c) {
        if (posX == 0) {
            switch (posY) {
                case 0 -> checkPossibleMove(dx_ul, dy_ul, posX, posY, c);
                case 3 -> checkPossibleMove(dx_dl, dy_dl, posX, posY, c);
                default -> checkPossibleMove(dx_left, dy_left, posX, posY, c);
            }
        } else if (posX == col - 1) {
            switch (posY) {
                case 0 -> checkPossibleMove(dx_ur, dy_ur, posX, posY, c);
                case 3 -> checkPossibleMove(dx_dr, dy_dr, posX, posY, c);
                default -> checkPossibleMove(dx_right, dy_right, posX, posY, c);
            }
        } else {
            switch (posY) {
                case 0 -> checkPossibleMove(dx_up, dy_up, posX, posY, c);
                case 3 -> checkPossibleMove(dx_down, dy_down, posX, posY, c);
                default -> checkPossibleMove(dx_middle, dy_middle, posX, posY, c);
            }
        }
    }

    int x1, y1;

    void checkPossibleMove(int[] dx, int[] dy, int x, int y, String word) {
        Vector<Integer> dx_list = new Vector<>();
        for (int i : dx) {
            dx_list.add(i);
        }

        Vector<Integer> dy_list = new Vector<>();
        for (int i : dy) {
            dy_list.add(i);
        }
        int pos;
//        outerLoop:
        Stack<Integer> tracks_x = new Stack<>();
        Stack<Integer> tracks_y = new Stack<>();

        for (int i = 0; i < dx_list.size(); i++) {
            pos = random(dx_list.size()) - 1;
            x1 = x + dx_list.get(pos);
            y1 = y + dy_list.get(pos);
            if (used[y1][x1] == 0) {
                used[y1][x1] = 1;
                map[y1][x1] = word.charAt(0);
                tracks_x.push(x1);
                tracks_y.push(y1);
                dx_list.remove(pos);
                dy_list.remove(pos);
                if (word.length() == 1) {
                    show_map();
                    System.exit(0);
//                    break outerLoop;
                } else {
                    checkCurrentPosition(x1, y1, word.substring(1));
                }
                used[tracks_y.peek()][tracks_x.peek()] = 0;
                map[tracks_y.peek()][tracks_x.peek()] = '\0';
                tracks_x.pop();
                tracks_y.pop();
            } else {
                dx_list.remove(pos);
                dy_list.remove(pos);
            }
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
}
