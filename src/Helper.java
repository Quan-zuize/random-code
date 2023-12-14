import java.util.*;

public class Helper extends MapManagement {
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
    int[] dx_dr = {-1, -1, 0};
    int[] dy_dr = {0, -1, -1};

    String[] possibleDirection = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
    List<String> DirectionList;

    int random(int range) {
//        return min + (int)(Math.random() * ((max - min) + 1));
        return rand.nextInt(range) + 1;
    }

    int[] checkCurrentPosition(int posX, int posY, Character c) {
//        DirectionList = Arrays.asList(possibleDirection);
        if (posX == 0) {
            switch (posY) {
                case 0 -> {
                    return checkPossibleMove(dx_ul, dy_ul, posX, posY, c); //DirectionList.subList(3, 5),
                }
                case 3 -> {
                    return checkPossibleMove(dx_dl, dy_dl, posX, posY, c); // DirectionList.subList(1, 3)
                }
                default -> {
                    return checkPossibleMove(dx_left, dy_left, posX, posY, c); //DirectionList.subList(1, 5)
                }
            }
        } else if (posX == col - 1) {
            switch (posY) {
                case 0 -> {
                    return checkPossibleMove(dx_ur, dy_ur, posX, posY, c); // DirectionList.subList(5, 7)
                }
                case 3 -> {
//                    List<String> temp = DirectionList.subList(7, 8);
//                    temp.add(DirectionList.get(1));
//                    DirectionList.subList(6, 8).clear();
                    return checkPossibleMove(dx_dr, dy_dr, posX, posY, c);//DirectionList
                }
                default -> {
//                    List<String> temp = DirectionList.subList(5,8);
//                    temp.add(DirectionList.get(1));
//                    DirectionList.subList(1, 4).clear();
                    return checkPossibleMove(dx_right, dy_right, posX, posY, c); //DirectionList
                }
            }
        } else {
            switch (posY) {
                case 0 -> {
                    return checkPossibleMove(dx_up, dy_up, posX, posY, c); // DirectionList.subList(3, 7)
                }
                case 3 -> {
//                    DirectionList.subList(3, 6).clear();
                    return checkPossibleMove(dx_down, dy_down, posX, posY, c); //DirectionList
                }
                default -> {
                    return checkPossibleMove(dx_middle, dy_middle, posX, posY, c); //DirectionList
                }
            }
        }
    }

    int[] checkPossibleMove(int[] dx, int[] dy, int x, int y, Character c) {
//        if (String.valueOf(x).length() == 0) {
//            return null;
//        }
        boolean flag = false;

        Vector<Integer> dx_list = new Vector<>();
        for (int i : dx) {
            dx_list.add(i);
        }

        Vector<Integer> dy_list = new Vector<>();
        for (int i : dy) {
            dy_list.add(i);
        }

        int i1, y1;
        do {
            int pos = random(dx.length) - 1;
            i1 = x + dx_list.get(pos);
            y1 = y + dy_list.get(pos);
            if (used[y1][i1] == 0) {
                used[y1][i1] = 1;
                map[y1][i1] = c;
                flag = true;
            } else {
                dx_list.remove(pos);
                dy_list.remove(pos);
            }
        } while (!flag);
        return new int[]{i1, y1};
    }
}
