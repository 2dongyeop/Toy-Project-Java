package ThreadNumberGame;

public class GameLauncher implements Runnable {
    public void run() {
        GuessGame.startGame();
    }

    public static void main(String[] args) {
        Runnable r = new GameLauncher();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}