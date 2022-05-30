package ThreadNumberGame;

import java.util.*;

public class GuessGame {
    private boolean run = true;
    static Player player = new Player();
    private static final int SIZE = 3; //정답 수
    Scanner scanner = new Scanner(System.in);
    static List<Integer> answerList = new ArrayList<>(3);

    public static void startGame() {
        int answerCount = 0;

        readyGame();
        System.out.println("======게임 시작=====");

        loop :
        while(true) {
            System.out.println("=======[" + Thread.currentThread().getName() + "]=======");
            loop1:
            for (int i = 0; i < SIZE; i++) {
                if (answerList.get(i) == player.guess()) {
                    System.out.println("정답입니다.");
                    answerCount++;

                    if (answerCount == 3) {
                        System.out.println("우승자가 나왔습니다.");
                        break loop;
                    }
                } else {
                    System.out.println("오답입니다.");
                    answerCount = 0; //정답 수 초기화
                    break loop1;
                }
            }
        }
    }

    public static synchronized void readyGame() {
        for (int i = 0; i < SIZE; i++) {
            int ranNum = (int)(Math.random()*10 + 1); //1부터 10까지의 수를 포장
            answerList.add(ranNum);
        }
    }
}
