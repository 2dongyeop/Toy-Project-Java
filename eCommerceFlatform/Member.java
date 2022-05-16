package newCode.blog.eCommerceFlatform;

public class Member {
    private String id;
    private String password;
    private String nickname;
    private int balance = 100000; //신규회원의 기본 자산은 10만원이다.

    Member(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
    void minusBalance(int num) {  //상품 구매시 잔액 차감
        if (this.balance - num < 0) { //상품 금액이 잔고보다 많으면 오류
            Page.errorMessage();
            Page.common();
        } else if (num < 0) {  //매개 변수로 받는 상품 금액이 음수일 경우 오류
            Page.errorMessage();
            Page.common();
        } else {
            this.balance -= num;
        }
    }

    void plusBalance(int num) {   //상품 환불시 잔액 증감
        this.balance += num;
    }

    void setId(String id) {
        this.id = id;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }

    int getBalance() {
        return this.balance;
    }

    String getId() {
        return this.id;
    }

    String getPassword() {
        return this.password;
    }

    String getNickname() {
        return this.nickname;
    }
}