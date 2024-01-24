package org.example.tic_tac_toe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;



public class AI {
    private final char DOT;
    private Random random;

    private Lines lines = new Lines();
    private ArrayList<Integer> moves = new ArrayList<>();
    ArrayList<Integer> winSteps = new ArrayList<>();
    public static HashMap<Integer, int[]> dotsIndex;

    {
        dotsIndex = new HashMap<>();
        dotsIndex.put(0, new int[]{0, 0});
        dotsIndex.put(1, new int[]{0, 1});
        dotsIndex.put(2, new int[]{0, 2});
        dotsIndex.put(3, new int[]{1, 0});
        dotsIndex.put(4, new int[]{1, 1});
        dotsIndex.put(5, new int[]{1, 2});
        dotsIndex.put(6, new int[]{2, 0});
        dotsIndex.put(7, new int[]{2, 1});
        dotsIndex.put(8, new int[]{2, 2});
    }

    public AI(char ch){
        DOT = ch;
        random = new Random();
    }


    //TODO improve turn with
//    void turn(Field field) {
//
//            int x, y;
//            do {
//                x = random.nextInt(field.getSize());
//                y = random.nextInt(field.getSize());
//            } while (!field.isCellValid(x, y));
//            field.setDot(x, y, DOT);
//    }

    void turn(Field field){
        if(moves.size()==0){
            int x, y;
            do {
                x = random.nextInt(field.getSize());
                y = random.nextInt(field.getSize());
            } while (!field.isCellValid(x, y));
            field.setDot(x, y, DOT);
            int[] point = new int[] {x, y};
            for(Integer key: dotsIndex.keySet()){
                if(Arrays.equals(dotsIndex.get(key), point)) {
                    moves.add(key);
                    break;
                }
            }

            }else {
            int checkNum = moves.get(0);
            for (Line line: lines
                 ) {


                boolean isWinLine = false;
                int[] arrayPossibleMoves = line.getArray();
                for (Integer num: arrayPossibleMoves
                     ) {
                    if(num == checkNum) isWinLine = true;
                }
                if(isWinLine) {
                    winSteps.add(arrayPossibleMoves[0]);
                    winSteps.add(arrayPossibleMoves[1]);
                    winSteps.add(arrayPossibleMoves[2]);
                    break;
                }

            }

            winSteps.remove((Object)checkNum);
            int[] newPoint = dotsIndex.get(winSteps.get(0));
            if(field.isCellValid(newPoint[0], newPoint[1])) {
                field.setDot(newPoint[0], newPoint[1], DOT);
                int[] point = new int[] {newPoint[0], newPoint[1]};
                for(Integer key: dotsIndex.keySet()){
                    if(Arrays.equals(dotsIndex.get(key), point)) moves.add(key);
                }
            }else{
                newPoint = dotsIndex.get(winSteps.get(1));
                if(field.isCellValid(newPoint[0], newPoint[1])) {
                    field.setDot(newPoint[0], newPoint[1], DOT);
                    int[] point = new int[] {newPoint[0], newPoint[1]};
                    for(Integer key: dotsIndex.keySet()){
                        if(Arrays.equals(dotsIndex.get(key), point)) moves.add(key);
                    }

                }else {
                    winSteps.clear();
                    moves.clear();
                    int x, y;
                    do {
                        x = random.nextInt(field.getSize());
                        y = random.nextInt(field.getSize());
                    } while (!field.isCellValid(x, y));
                    field.setDot(x, y, DOT);
                    int[] point = new int[] {x, y};
                    for(Integer key: dotsIndex.keySet()){
                        if(Arrays.equals(dotsIndex.get(key), point)) moves.add(key);
                    }

                }

            }

            }
        }


        }




