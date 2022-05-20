package Dictionary;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    static List<Word> wrdNote = new ArrayList<>();
    static Word word = new Word();
    static Scanner scanner = new Scanner(System.in);

    static void start() {
        System.out.println("1.자료 추가 | 2.자료 삭제 | 3.자료 조회 | 4.자료 검색");
        int menu = scanner.nextInt();

        String input;
        int inputNum;
        switch (menu) {
            case 1:
                insertWord();
                break;
            case 2:
                System.out.print("지울 자료의 인덱스 번호를 입력해주세요:");
                inputNum = scanner.nextInt();
                delete(inputNum);
                break;
            case 3:
                printList();
                break;
            case 4:
                System.out.print("검색할 자료의 인덱스 번호를 입력해주세요:");
                inputNum = scanner.nextInt();
                search(inputNum);
                break;
            default:
                System.err.println("1 ~ 4 사이의 값을 입력해주세요.");
                break;
        }
    }
    static void insertWord() {
        System.out.print("추가할 자료 단어를 입력하세요 :");
        String inputWord = scanner.next();
        word.setWord(inputWord);
        System.out.print("추가할 자료 뜻을 입력하세요 :");
        String inputMeaning = scanner.next();
        word.setMeaning(inputMeaning);

        wrdNote.add(word);
        System.out.println(wrdNote.size() - 1 + "번 인덱스에 자료를 추가합니다.");
    }
    static void delete(int inputNum) {
        wrdNote.remove(inputNum);
        System.out.println(wrdNote.size() + "번 인덱스의 자료가 삭제되었습니다.");
    }
    static void printList() {

    }
    static void search(int inputNum) {
        Word searchWord = wrdNote.get(inputNum);
        System.out.println("입력한 인덱스의 단어는 " + searchWord.getWord() + "입니다.");
        System.out.println("입력한 인덱스의 뜻은 " + searchWord.getMeaning() + "입니다.");
    }
}
