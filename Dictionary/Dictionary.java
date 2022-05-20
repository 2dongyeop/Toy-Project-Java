package newCode.major.Dictionary;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    static List<Word> wrdNote = new ArrayList<>();
    static Word word = new Word();

    static void start() {
        System.out.println("1.자료 추가 | 2.자료 삭제 | 3.자료 조회 | 4.자료 검색");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();

        String input;
        int inputNum;
        switch (menu) {
            case 1:
                input = inputString();
                insert(input);
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
    static void inputString() {
        System.out.print("단어를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.next();
        word.setWord(inputWord);

        System.out.print("뜻을 입력해주세요 : ");
        String inputMeaning = scanner.next();
        word.setMeaning(inputMeaning);
    }
    static void insert(String input){
        wrdNote.add(input);
    }
    static void delete(int inputNum) {
        wrdNote.remove(inputNum);
    }
    static void printList() {

    }
    static void search(int inputNum) {
        //String str = wrdNote.get(inputNum);
        System.out.println("");
    }
}
