package Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class LoginApplication {
    public final static User[] users = new User[10];
    public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int selectMenu = 0;
    static int userCount = 0;
    static boolean loginState = false;
    static int withdrawIndex = 0;
//    static State state;

    public static void main(String[] args) throws IOException {
        initialize();

        do {
            showMenu(); //selectMenu를 입력받는 부분

            if (selectMenu == 1) {
//                state = new SignUp();
//                state.doWork();
                signUp();
            } else if (selectMenu == 2) {
//                state = new Login();
//                state.doWork();
                logIn();
            } else if (selectMenu == 3) {
//                state = new Lookup();
//                state.doWork();
                lookUp();
            } else if (selectMenu == 4) {
//                state = new Withdraw();
//                state.doWork();
                withdraw();
            } else {
                break;
            }
        } while (selectMenu != 5);
    }

    private final static void initialize() {
        for (int i = 0; i < users.length; i++) {
            users[i] = new User(null, null, null);
        }
    }

    private final static void showMenu() throws IOException {
        System.out.println("===== 1.회원가입 2.로그인 3.사용자 조회 4.탈퇴 5.종료 =====");
        System.out.print("입력 > ");
        selectMenu = Integer.parseInt(br.readLine());
    }

    private final static void signUp() throws IOException {
        System.out.println("=====회원가입 화면입니다.=====");
        System.out.println("아이디, 패스워드, 닉네임을 한 줄에 입력해주세요.");
        StringTokenizer st = new StringTokenizer(br.readLine());

        String inputId = st.nextToken(); String inputPassword = st.nextToken(); String inputNickname = st.nextToken();
        try {
            if (doubleCheck(inputId)) {
                System.out.println("[회원가입 실패 - Id 중복]");
                return;
            }
            users[userCount++] = new User(inputId, inputPassword, inputNickname);

            System.out.println("[회원가입 성공]");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[회원가입 실패 - User 배열 범위 초과]");
        } catch (NoSuchElementException e) {
            System.out.println("입력 인자가 부족합니다. 다시 입력해주세요.");
        }
    }

    private final static boolean doubleCheck(String id) {
        for (User user : users) {
            if (user.getId() != null && user.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    private final static void logIn() throws IOException {
        try {
            System.out.println("=====로그인 화면입니다.=====");
            System.out.println("아이디, 패스워드를 한 줄에 입력해주세요.");
            StringTokenizer st = new StringTokenizer(br.readLine());

            String inputId = st.nextToken();
            String inputPassword = st.nextToken();

            for (User user : users) {
                if (user.getId().equals(inputId) && user.getPassword().equals(inputPassword)) {
                    System.out.println("[로그인 성공]");
                    loginState = true;
                    return;
                }
            }

            System.out.println("[로그인 실패]");
        } catch (NullPointerException e) {
            System.out.println("회원 수를 초과하였습니다.");
        } catch (NoSuchElementException e) {
            System.out.println("입력 인자가 부족합니다. 다시 입력해주세요.");
        }
    }

    private final static void lookUp() {
        System.out.println("=====조회 화면입니다.=====");
        if (loginState) {
            for (User user : users) {
                if (user.getNickname() != null)
                    System.out.println(user.getNickname());
            }
        }
    }

    private final static void withdraw() throws IOException {
        try {
            if (!loginState) {
                System.out.println("[로그인 상태에서만 조회 가능합니다.]");
                return;
            }

            System.out.println("=====탈퇴 화면입니다.=====");
            System.out.println("아이디, 패스워드를 한 줄에 입력해주세요.");
            StringTokenizer st = new StringTokenizer(br.readLine());

            String inputId = st.nextToken();
            String inputPassword = st.nextToken();

            for (User user : users) {
                if (user.getId().equals(inputId) && user.getPassword().equals(inputPassword)) {
                    System.out.println("[탈퇴 성공]");

                    shiftUser();
                    return;
                }
                withdrawIndex++;
            }

            System.out.println("[탈퇴 실패 - id or password is not same]");
        } catch (NoSuchElementException e) {
            System.out.println("입력 인자가 부족합니다. 다시 입력해주세요.");
        }
    }

    private final static void shiftUser() {
        for (int i = withdrawIndex; i < users.length - 1; i++) {
            if (withdrawIndex == userCount) { //탈퇴할 회원이 가입한 회원 중 마지막 회원이라면
                users[i] = new User(null, null, null);
            } else                            //마지막 회원이 아니면 쉬프트 연산
                users[i] = new User(users[i + 1].getId(), users[i + 1].getPassword(), users[i + 1].getNickname());
        }
    }
}
