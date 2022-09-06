package Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Login.LoginApplication.users;

public class SignUp implements State {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void doWork() throws IOException {
        System.out.println("=====회원가입 코너입니다.=====");
        System.out.println("아이디, 패스워드, 닉네임을 한 줄에 입력해주세요.");
        StringTokenizer st = new StringTokenizer(br.readLine());

//        users.
    }
}
