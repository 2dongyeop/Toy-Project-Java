package ThreadNumberGame;

public class Player {
    private int number;

    public int guess() {
        System.out.print("예상 값을 입력 > ");
        int number = (int)(Math.random()*10 + 1);
        System.out.println(number);

        return number;
    }
}
