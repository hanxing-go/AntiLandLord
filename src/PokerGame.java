public class PokerGame {
    //准备牌
    //静态代码块
    //特点：随着类的加载而加载，并且只执行一次
    static {
        //♠，♣，♥，♦
        //3, 4 , 5, 6, 7, 8, 9, 10, J, Q, K, A, 2
        //Joker-A Joker-B
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3","4","5", "6", "7", "8", "9", "10","J","Q","K","A","2"};

        System.out.println(color);
    }
    public PokerGame() {

    };

}
