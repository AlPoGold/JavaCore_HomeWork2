package org.example.tic_tac_toe;


import java.util.Random;



public class AI {
    private final char DOT;
    private Random random;

    private Lines lines = new Lines();

    public AI(char ch){
        DOT = ch;
        random = new Random();
    }


    //TODO improve turn with
    void turn(Field field) {

            int x, y;
            do {
                x = random.nextInt(field.getSize());
                y = random.nextInt(field.getSize());
            } while (!field.isCellValid(x, y));
            field.setDot(x, y, DOT);
    }
//        if (Field.getAiDots().size() == 0) {
//            int x, y;
//            do {
//                x = random.nextInt(field.getSize());
//                y = random.nextInt(field.getSize());
//            } while (!field.isCellValid(x, y));
//            field.setDot(x, y, DOT);
//        }else{
//
//            HashMap<int[], Integer> dotsIndex = Field.getDotsIndex();
//
//            int x = 0, y = 0;
//            do{
//
//            for (Line line: lines
//                 ) {
//                int[] array = line.getArray();
//                for (int i = 0; i < array.length; i++) {
//                    for (int j = 0; j < Field.getAiDots().size(); j++) {
//                        if(array[i]==Field.getAiDots().get(j)){
//                            int iTemp;
//                            do{
//                                 iTemp = random.nextInt(0,3);
//                            }while(iTemp!=i);
//
//                            for(int[] coord: dotsIndex.keySet()){
//                                if(dotsIndex.get(coord)==iTemp){
//                                    x = coord[0];
//                                    y = coord[1];
//                                }
//                            }
//                        }
//                    }
//
//                }
//
//            }
//
//                field.setDot(x, y, DOT);
//            }while(!field.isCellValid(x, y));
//
//        }
//    }


}
