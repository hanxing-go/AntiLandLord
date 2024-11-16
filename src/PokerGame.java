import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import java.util.*;

public class PokerGame {
    //准备牌
    //静态代码块
    //特点：随着类的加载而加载，并且只执行一次
    private static Map<Integer,String> pokerbox = new HashMap<>();//牌盒
    private static List<Integer> indexarr = new ArrayList<>();
    private static Map<Integer, String> playerpoker1 = new TreeMap<>();//玩家1的牌
    private static Map<Integer, String> playerpoker2 = new TreeMap<>();//玩家1的牌
    private static Map<Integer, String> playerpoker3 = new TreeMap<>();//玩家1的牌
    private static Map<Integer, String> lordpoker = new TreeMap<>();//底牌 三张牌
    static {
        //♠，♣，♥，♦
        //3, 4 , 5, 6, 7, 8, 9, 10, J, Q, K, A, 2
        //Joker-A Joker-B
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3","4","5", "6", "7", "8", "9", "10","J","Q","K","A","2"};
        //准备牌盒
        int SerialNumber = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < color.length; j++) {
//                System.out.println(number[i] + color[j]);
                pokerbox.put(SerialNumber, number[i] + color[j]);
                indexarr.add(SerialNumber);
                SerialNumber ++;
            }
        }
        //添加大王和小王
        indexarr.add(SerialNumber);
        pokerbox.put(SerialNumber++, "JOKER-A");
        indexarr.add(SerialNumber);
        pokerbox.put(SerialNumber++, "JOKER-B");

    }
    public PokerGame() {
        //洗牌阶段
        shufflePoker();
        //发牌
        dealPoker();


        //结束对局
        endGame();
    }

//    3. 结束对局
    private void endGame() {
        playerpoker1.clear();
        playerpoker2.clear();
        playerpoker3.clear();
        lordpoker.clear();
    }


//    2. 发牌
    private void dealPoker() {
        //先发三张给底牌
        int serialnumber = 0;
        for (int i = 0; i < 3; i++) {
            serialnumber = indexarr.get(i);
            lordpoker.put(serialnumber, pokerbox.get(serialnumber));
        }
        //54 - 3 = 51.51 / 3 = 17
        for (int i = 3; i < pokerbox.size(); i++) {
            serialnumber = indexarr.get(i);
            if (i % 3 == 0) {
                playerpoker1.put(serialnumber, pokerbox.get(serialnumber));
            } else if (i % 3 == 1) {
                playerpoker2.put(serialnumber, pokerbox.get(serialnumber));
            } else {
                playerpoker3.put(serialnumber, pokerbox.get(serialnumber));
            }
        }
    }

    ;

    //1. 洗牌功能
    private void shufflePoker() {
        Collections.shuffle(indexarr);
    }

    //2. 看牌功能
    private void printPoker(Map<Integer, String> poker) {

        poker.forEach((index,name) -> System.out.print(name + " "));

        System.out.println();
        System.out.println("==================");
    }

}
