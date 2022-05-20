package LogInProject;
import java.util.Scanner;

public class LoginApplication {
    public static void main(String[] args) {
        User[] users = new User[10];//User 배열 크기 : 10
        for (int j=0;j<10;j++){
            users[j] = new User();  //NullpointerException방지 배열 초기화
        }
        int menu=0;
        String whoId=null;
        String whoPswd=null;
        String whoNick=null;
        boolean run = true;

        int i=0;
        while(run) {                    //무한루프 생성
            System.out.println("1.회원가입 | 2.로그인 | 3.사용자 조회 | 4.탈퇴 | 종료는 나머지 키 입력 ");
            System.out.print("선택: ");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            if (menu == 1) {           //1.회원가입을 택한 경우
                if (i>=10) {           //1.크기 10을 초과하면 회원가입 불가
                    System.out.println("용량 초과 : 회원가입 실패");
                    break;
                }else {
                    System.out.printf("아이디를 입력하세요: ");
                    whoId = scanner.next();
                    users[i].setId(whoId);
                    System.out.printf("패스워드를 입력하세요: ");
                    whoPswd = scanner.next();
                    users[i].setPswd(whoPswd);
                    System.out.printf("닉네임를 입력하세요: ");
                    whoNick = scanner.next();
                    users[i].setNickName(whoNick);

                    i++;
                    System.out.println("회원가입 성공");
                }
            } else if (menu == 2) { //2.로그인을 택한 경우
                System.out.print("아이디: ");
                whoId = scanner.next();

                System.out.print("패스워드: ");
                whoPswd = scanner.next();
                for (i=0;i<10;i++){
                    if (whoId.equals(users[i].getId()) && whoPswd.equals(users[i].getPswd())){
                        System.out.println("로그인 성공");
                        System.out.println(users[i].getId() + " " + users[i].getNickName());
                        break;
                    }
                    /*else{
                        System.out.println("로그인 실패");
                        break;
                    }*/
                }
            } else if (menu ==3){                            //3.사용자 조회를 택한 경우
                for (User user : users){
                    if (user.getNickName()!=null)            //목록 출력시 null은 출력안함
                        System.out.println(user.getNickName());
                }
            } else if (menu ==4){ //4.탈퇴를 택한 경우
                System.out.print("탈퇴하실 계정 아이디: ");
                whoId = scanner.next();
                System.out.print("탈퇴하실 계정 패스워드: ");
                whoPswd = scanner.next();
                for (i=0;i<10;i++){
                    if (whoId.equals(users[i].getId()) && whoPswd.equals(users[i].getPswd())){
                        System.out.println("탈퇴 완료");
                        users[i].setId(null);
                        users[i].setPswd(null);
                        users[i].setNickName(null);
                        break;
                    }
                    /*else{
                        System.out.println("탈퇴 실패");
                        break;
                    }*/
                }
            } else {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}