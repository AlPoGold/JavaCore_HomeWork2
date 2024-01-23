package org.example.tic_tac_toe;




import java.awt.*;
import java.util.*;

public class Field {

    private final int FIELD_SIZE;
    private final int CELL_SIZE;

    //symbols for steps
    private final char HUMAN_DOT = 'x';
    private final char AI_DOT = 'o';
    private final char EMPTY_DOT = '.';

    private final Lines lines = new Lines();
    private static ArrayList<Integer> humanDots = new ArrayList<>();

    public static ArrayList<Integer> getAiDots() {
        return aiDots;
    }

    private static ArrayList<Integer> aiDots = new ArrayList<>();



    public static HashMap<int[], Integer> dotsIndex;

    {
        dotsIndex = new HashMap<>();
        dotsIndex.put(new int[]{0, 0}, 0);
        dotsIndex.put(new int[]{0, 1}, 1);
        dotsIndex.put(new int[]{0, 2}, 2);
        dotsIndex.put(new int[]{1, 0}, 3);
        dotsIndex.put(new int[]{1, 1}, 4);
        dotsIndex.put(new int[]{1, 2}, 5);
        dotsIndex.put(new int[]{2, 0}, 6);
        dotsIndex.put(new int[]{2, 1}, 7);
        dotsIndex.put(new int[]{2, 2}, 8);
    }
    public static HashMap<int[], Integer> getDotsIndex() {
        return dotsIndex;
    }

    //messages
    private final String MSG_DRAW = "Draw, sorry...";
    private final String MSG_HUMAN_WON = "YOU WON!";
    private final String MSG_AI_WON = "AI WON!";

    private char[][] map;
    private String gameOverMsg;

    public Field(int field_size, int cell_size){
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;

        map = new char[field_size][field_size];
        init();
    }

    public void init(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++)
                map[i][j] = EMPTY_DOT;
        }
        gameOverMsg = null;
        aiDots.clear();
        humanDots.clear();
    }

    int getSize() { return FIELD_SIZE; }

    char getHumanDot() { return HUMAN_DOT; }

    char getAIDot() { return AI_DOT; }

    boolean isGameOver() { return gameOverMsg != null; }

    String getGameOverMsg() { return gameOverMsg; }

    void setDot(int x, int y, char dot) { // set dot and check fill and win
        map[x][y] = dot;
        if(dot==HUMAN_DOT) {
            int[] point = new int[] {x, y};
            for (int[] key: dotsIndex.keySet()
                 ) {
                if(Arrays.equals(key, point)) humanDots.add(dotsIndex.get(key));
            }

            Collections.sort(humanDots);
        }
        else if (dot==AI_DOT) {
            int[] point = new int[] {x, y};
            for (int[] key: dotsIndex.keySet()
            ) {
                if(Arrays.equals(key, point)) aiDots.add(dotsIndex.get(key));
            }

            Collections.sort(aiDots);
        }
        if (checkWin(HUMAN_DOT, humanDots))
            gameOverMsg = MSG_HUMAN_WON;
        else if (checkWin(AI_DOT, aiDots))
            gameOverMsg = MSG_AI_WON;
        else if (isMapFull())
            gameOverMsg = MSG_DRAW;
    }

    boolean isMapFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (map[i][j] == EMPTY_DOT)
                    return false;
        return true;
    }

    boolean checkWin(char dot, ArrayList<Integer> checkList) {

        //TODO improve this method
        // checking horizontals / verticals
//        for (int i = 0; i < FIELD_SIZE; i++)
//            if ((map[i][0] == dot && map[i][1] == dot && map[i][2] == dot) ||
//                    (map[0][i] == dot && map[1][i] == dot && map[2][i] == dot))
//                return true;
//        // checking diagonals
//        if ((map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) ||
//                (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot))
//            return true;
//        return false;
        boolean isWin = false;
        if (checkList.size() < 3) return false;
        int count = 0;
        for (Line line : lines
        ) {
            count = 0;
            int[] array = line.getArray();
            for (int num : checkList
            ) {
                if(count< array.length) {
                    if (num == array[count]) count++;
                }
            }
            if(count==3) isWin=true;

        }
        return isWin;

    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1)
            return false;
        if (map[x][y] == EMPTY_DOT)
            return true;
        return false;
    }

    public void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.lightGray);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i * CELL_SIZE, FIELD_SIZE * CELL_SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, FIELD_SIZE * CELL_SIZE);
        }

        g.setStroke(new BasicStroke(5));

        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (map[x][y] == HUMAN_DOT) {
                    g.setColor(Color.blue);
                    g.drawLine(x * CELL_SIZE + CELL_SIZE / 4, y * CELL_SIZE + CELL_SIZE / 4,
                            (x + 1) * CELL_SIZE - CELL_SIZE / 4, (y + 1) * CELL_SIZE - CELL_SIZE / 4);
                    g.drawLine(x * CELL_SIZE + CELL_SIZE / 4, (y + 1) * CELL_SIZE - CELL_SIZE / 4,
                            (x + 1) * CELL_SIZE - CELL_SIZE / 4, y * CELL_SIZE + CELL_SIZE / 4);
                }
                if (map[x][y] == AI_DOT) {
                    g.setColor(Color.red);
                    g.drawOval(x * CELL_SIZE + CELL_SIZE / 4, y * CELL_SIZE + CELL_SIZE / 4,
                            CELL_SIZE / 2,
                            CELL_SIZE / 2);
                }
            }
        }
    }
}


