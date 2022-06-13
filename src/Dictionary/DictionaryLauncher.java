package Dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Word {
    private String word;
    private String meaning;

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
}

class Dictionary {
    static int menu = 0;
    final static List<Word> wrdNote = new ArrayList<>();
    final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void start() throws IOException {
         do {
             System.out.println("1.자료 추가 | 2.자료 검색 | 3.자료 삭제 | 4.종료");
             menu = Integer.parseInt(bufferedReader.readLine());

             switch (menu) {
                case 1:
                    insertWord();
                    break;
                case 2:
                    searchWord();
                    break;
                case 3:
                    deleteWord();
                    break;
                default:
                    System.err.println("1 ~ 3 사이의 값을 입력해주세요.");
                    break;
            }
        } while (menu != 4);
    }

    public void insertWord() throws IOException {
        System.out.println("단어와 단어의 뜻을 입력하세요.");
        String str = bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(str, "/");
        String tempWord = stringTokenizer.nextToken();
        String tempMeaning = stringTokenizer.nextToken();

        wrdNote.add(new Word(tempWord, tempMeaning));
        System.out.println(wrdNote.size() - 1 + "번 인덱스에 자료를 추가합니다.");
    }

    public void searchWord() throws IOException {
        System.out.println("뜻을 검색할 단어를 입력해주세요");
        String tempWord = bufferedReader.readLine();

        boolean isSearched = false;
        for (int i = 0; i < wrdNote.size(); i++) {
            if (tempWord == wrdNote.get(i).getWord()) {
                System.out.println(wrdNote.get(i).getMeaning());
                isSearched = true;
            }
        }

        if (isSearched) {
            System.err.println("입력하신 단어를 찾을 수 없습니다.");
        }
    }

    public void deleteWord() throws IOException {
        System.out.println("삭제할 단어를 입력해주세요");
        String tempWord = bufferedReader.readLine();

        boolean isSearched = false;
        for (int i = 0; i < wrdNote.size(); i++) {
            if (tempWord == wrdNote.get(i).getWord()) {
                System.out.println("해당 단어를 삭제합니다.");
                wrdNote.remove(i);
                isSearched = true;
            }
        }

        if (isSearched) {
            System.err.println("입력하신 단어를 찾을 수 없습니다.");
        }
    }

}

public class DictionaryLauncher {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        dictionary.start();
    }
}
