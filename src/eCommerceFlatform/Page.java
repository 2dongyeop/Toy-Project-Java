//package eCommerceFlatform;
//
//import java.util.Scanner;
//
//public class Page {
//    public static boolean run;
//    public static int memberNum = 0;
//    private static Scanner scanner;
//    private static String inputId;
//    private static String inputPassword;
//    private static String inputNickname;
//    public static Member[] member;
//
//    public Page() {
//    }
//
//    public static void common() {
//        System.out.println("홈으로 돌아갑니다.");
//        run = false;
//    }
//
//    public static void errorMessage() {
//        System.out.println("잘못된 접근입니다. 다시 시도해주세요.");
//    }
//
//    public static void main(String[] args) {
//        run = true;
//        //NullPointerException 방지 초기화 - 모든 필드값에 공백 대입
//        for(int i = 0; i < 10; ++i) {
//            member[i] = new Member("", "", "");
//        }
//        do {
//            System.out.println("미니 e커머스 플랫폼입니다. 원하시는 서비스를 이용하시려면 숫자를 입력해주세요.");
//            System.out.println("1.로그인 | 2.회원가입 | 3.로그아웃 | 4.상품 관련 서비스");
//            System.out.print("선택 > ");
//            int select = scanner.nextInt();
//
//            if (select == 1) {                          //로그인 선택
//                if (Page.User.loginStatus) {            //이미 로그인 상태면 오류 출력
//                    errorMessage();
//                    common();
//                } else {
//                    goToLogin();                        //로그인 메소드 호출
//                    Page.User.loginStatus = true;       //로그인 상태임을 기억
//                }
//            } else if (select == 2) {                   //회원가입 선택
//                if (memberNum > 10) {                   //회원 수를 10명으로 제한했기 때문에 조건 설정
//                    System.out.println("회원 수용 가능 숫자를 초과");
//                    errorMessage();
//                    common();
//                } else {
//                    goToSignUp();                       //회원가입 메소드 출력
//                }
//            } else if (select == 3) {                   //로그아웃 선택
//                if (Page.User.loginStatus) {            //로그인 상태일 경우에만 로그아웃 가능
//                    System.out.println("로그아웃 되었습니다.");
//                    Page.User.loginStatus = false;      //비로그인 상태로 됨을 기억
//                } else {
//                    System.out.println("비로그인 상태입니다.");
//                    errorMessage();
//                    common();
//                }
//            } else if (select == 4) {                   //상품 관련 페이지 이동 선택
//                if (!Page.User.loginStatus) {           //비로그인 상태시 접근 불가능한 기능
//                    System.out.println("비로그인으로 접근할 수 없는 기능입니다.");
//                    errorMessage();
//                    common();
//                } else {
//                    Category.goToCategory();            //상품 관련 페이지로 이동하는 메소드 호출
//                }
//            }
//        } while(run);
//
//    }
//    //로그인
//    private static void goToLogin() {
//        System.out.print("아이디를 입력하세요 : ");
//        inputId = scanner.next();
//        System.out.print("비밀번호를 입력하세요 : ");
//        inputPassword = scanner.next();
//
//        for(int i = 0; i < member.length; ++i) { //아이디는 일치, 비밀번호만 불일치
//            if (inputId.equals(member[i].getId()) && !inputPassword.equals(member[i].getPassword())) {
//                System.out.println("비밀번호 불일치");
//                errorMessage();
//                break;
//            }
//        }
//
//        for(int i = 0; i < member.length; ++i) { //아이디와 비밀번호 모두 일치 -> 로그인 성공
//            if (inputId.equals(member[i].getId()) && inputPassword.equals(member[i].getPassword())) {
//                Member var10001 = member[i];
//                System.out.println(var10001.getNickname() + "님 로그인");
//                System.out.println("미니 e커머스 플랫폼에 오신걸 환영합니다.");
//                Page.User.loginStatus = true;
//                User.whoAmI = i; //가입된 회원 중 로그인한 아이디가 인덱스 몇번인지 구분
//                break;
//            }
//        }
//    }
//
//    //회원가입
//    private static void goToSignUp() {
//        System.out.print("아이디를 입력하세요 : ");
//        inputId = scanner.next();
//
//        for(int i = 0; i < memberNum; ++i) {             //아이디가 동일한 경우를 방지
//            if (inputId.equals(member[i].getId())) {
//                System.out.println("동일한 id가 있습니다.");
//                errorMessage();
//                break;
//            }
//        }
//
//        member[memberNum].setId(inputId);
//        System.out.print("비밀번호를 입력하세요 : ");
//        inputPassword = scanner.next();
//        member[memberNum].setPassword(inputPassword);
//        System.out.print("닉네임을 입력하세요 : ");
//        inputNickname = scanner.next();
//        member[memberNum].setNickname(inputNickname);
//        ++memberNum;                                    //현재 회원 수++
//                                                        //초기 설정을 배열로 한 탓에 크기에 제한
//                                                        //List를 이용해 다시 구현해 볼 것
//   }
//
//    static {                                            //정적 블록으로 한번에 초기화
//        scanner = new Scanner(System.in);
//        member = new Member[10];
//    }
//
//    //로그인 상태 유지를 위한 중첩 클래스
//    public static class User {
//        public static boolean loginStatus = false;
//        public static int whoAmI;
//
//        public User() {
//        }
//    }
//}