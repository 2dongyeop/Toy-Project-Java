package eCommerceFlatform;
import java.util.Scanner;
import java.util.*;
import static newCode.blog.eCommerceFlatform.Page.member;
import static newCode.blog.eCommerceFlatform.Page.memberNum;

public class Category {
    private static Scanner scanner;
    public static boolean run;
    static List<Product.books> booksArrayList = new ArrayList<Product.books>();
    static List<Product.devices> devicesArrayList = new ArrayList<Product.devices>();
    static List<Product.clothes> clothesArrayList = new ArrayList<Product.clothes>();
    static List<Product.clothes> clothesCart = new ArrayList<Product.clothes>();
    static List<Product.devices> devicesCart = new ArrayList<Product.devices>();
    static List<Product.books> booksCart = new ArrayList<Product.books>();
    public static int buyCategoryNum;  //구매시 카테고리 구별을 위한 상수

    public Category() {
    }

    //메인 카테고리
    public static void goToCategory() {
        run = true;

        do {
            System.out.println("상품 관련 페이지입니다. 원하시는 작업의 번호를 입력하세요.");
            System.out.println("1.상품 조회 | 2.상품 등록 | 3.장바구니 및 구매 | 4.상품 환불");
            System.out.print("선택 > ");
            int select = scanner.nextInt();
            if (select == 1) {              //상품 조회 선택시
                lookUpProduct();
            } else if (select == 2) {       //상품 등록 선택시
                registerProduct();
            } else if (select == 3) {       //장바구니 및 구매 선택시
                additionalWork();
            } else if (select == 4) {       //상품 환불 선택시
                refundProduct();
            } else {
                Page.errorMessage();
                Page.common();
            }
        } while (run);

    }

    //상품 조회
    public static void lookUpProduct() {
        System.out.println("조회하려는 카테고리 번호를 입력해주세요.");
        System.out.println("1.의류 | 2.전자기기 | 3.도서");
        System.out.print("입력> ");
        int inputExample = scanner.nextInt();
        if (inputExample == 1) {                            //의류 카테고리 조회
            for (int i = 0; i < clothesArrayList.size(); i++) {
                Product.clothes clo = clothesArrayList.get(i);
                System.out.println( (i+1) + " 번째 상품 이름 : " + clothesArrayList.get(i).getClothesName());
                System.out.println( (i+1) + " 번째 상품 가격 : " + clothesArrayList.get(i).getClothesPrice());
                System.out.println( (i+1) + " 번째 상품 소개 : " + clothesArrayList.get(i).getClothesIntroduction());
                System.out.println();
            }
        } else if (inputExample == 2) {                     //전자기기 카테고리 조회
            for (int i = 0; i < devicesArrayList.size(); i++) {
                Product.devices dev = devicesArrayList.get(i);
                System.out.println( (i+1) + " 번째 상품 이름 : " + dev.getDevicesName());
                System.out.println( (i+1) + " 번째 상품 가격 : " + dev.getDevicesPrice());
                System.out.println( (i+1) + " 번째 상품 소개 : " + dev.getDevicesIntroduction());
                System.out.println();
            }
        } else if (inputExample == 3) {                     //책 카테고리 조회
            for (int i = 0; i < booksArrayList.size(); i++) { //Product.books books : booksArrayList
                Product.books boo = booksArrayList.get(i);
                System.out.println( (i+1) + " 번째 상품 이름 : " + boo.getBooksName());
                System.out.println( (i+1) + " 번째 상품 가격 : " + boo.getBooksPrice());
                System.out.println( (i+1) + " 번째 상품 소개 : " + boo.getBooksIntroduction());
                System.out.println();
            }
        } else {
            System.out.println("해당 카테고리는 존재하지 않습니다.");
            Page.errorMessage();
        }
    }

    //상품 등록 선택
    public static void registerProduct() {
        System.out.println("등록할 상품의 카테고리 번호를 입력하세요");
        System.out.println("1.의류 | 2.전자기기 | 3.도서");
        System.out.print("선택 > ");
        int inputExample = scanner.nextInt();
        run = true;

        do {
            String inputName;
            String inputIntroduce;
            int inputPrice;
            try {
                if (inputExample == 1) {                    //의류 카테고리 상품 등록
                    System.out.println("상품의 이름을 입력하세요");
                    System.out.print("입력 > ");
                    inputName = scanner.next();
                    System.out.println("상품의 가격을 입력하세요");
                    System.out.print("입력 > ");
                    inputPrice = scanner.nextInt();
                    System.out.println("상품의 소개를 입력하세요");
                    System.out.print("입력 > ");
                    inputIntroduce = scanner.next();

                    clothesArrayList.add(new Product.clothes(inputName, inputPrice, inputIntroduce));
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("입력 받고자 하는 자료형이 다릅니다.");
            }
            try {
                if (inputExample == 2) {                    //전자기기 카테고리 상품 등록
                    System.out.println("상품의 이름을 입력하세요");
                    System.out.print("입력 > ");
                    inputName = scanner.next();
                    System.out.println("상품의 가격을 입력하세요");
                    System.out.print("입력 > ");
                    inputPrice = scanner.nextInt();
                    System.out.println("상품의 소개를 입력하세요");
                    System.out.print("입력 > ");
                    inputIntroduce = scanner.next();

                    devicesArrayList.add(new Product.devices(inputName, inputPrice, inputIntroduce));
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("입력 받고자 하는 자료형이 다릅니다.");
            }
            try {
                if (inputExample == 3) {                    //책 카테고리 상품 등록
                    System.out.println("상품의 이름을 입력하세요");
                    System.out.print("입력 > ");
                    inputName = scanner.next();
                    System.out.println("상품의 가격을 입력하세요");
                    System.out.print("입력 > ");
                    inputPrice = scanner.nextInt();
                    System.out.println("상품의 소개를 입력하세요");
                    System.out.print("입력 > ");
                    inputIntroduce = scanner.next();

                    booksArrayList.add(new Product.books(inputName, inputPrice, inputIntroduce));
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("입력 받고자 하는 자료형이 다릅니다.");
            }
        } while (run);

    }

    //장바구니 담기 선택
    public static void registerShoppingCart() {
        run = true;

        do {
            System.out.println("조회한 상품 중 장바구니에 추가하실 상품의 번호를 입력하세요.");
            System.out.println("1.의류 | 2.전자기기 | 3.도서");
            System.out.print("입력 > ");
            int cartExample = scanner.nextInt(); //장바구니에 넣을 상품 카테고리 선택

            if (cartExample == 1) {
                System.out.println("장바구니에 추가 할 품목의 번호를 입력하세요.");
                System.out.print("입력 > ");
                int inPut = (scanner.nextInt() - 1); //카테고리 내에서 장바구니에 넣을 상품 선택

                Product.clothes clo = clothesArrayList.get(inPut); //옷 상품 중 해당 인덱스를 가져옴
                clothesCart.add(clo);                              //가져온 품목을 장바구니에 추가
                System.out.println("장바구니에 추가되었습니다.");
                                                    //장바구니에 상품 추가 후 구매 여부 묻기
                System.out.println("장바구니에 추가한 항목을 구매하시려면 숫자 1을 입력해주세요.");
                System.out.print("입력 > ");
                int buyYesOrNo = scanner.nextInt();

                if (buyYesOrNo == 1) {
                    buyCategoryNum = 1; //옷 구매 페이지로 이동
                    buyingProduct();
                } else {
                    Page.common();
                }
            } else if (cartExample == 2) {
                System.out.println("장바구니에 추가 할 품목의 번호를 입력하세요.");
                System.out.print("입력 > ");
                int inPut = (scanner.nextInt() - 1); //카테고리 내에서 장바구니에 넣을 상품 선택

                Product.devices dev = devicesArrayList.get(inPut); //기기 상품 중 해당 인덱스를 가져옴
                devicesCart.add(dev);                              //가져온 품목을 장바구니에 추가
                System.out.println("장바구니에 추가되었습니다.");
                                                    //장바구니에 상품 추가 후 구매 여부 묻기
                System.out.println("장바구니에 추가한 항목을 구매하시려면 숫자 1을 입력해주세요.");
                System.out.print("입력 > ");
                int buyYesOrNo = scanner.nextInt();

                if (buyYesOrNo == 1) {
                    buyCategoryNum = 2; //전자기기 구매 페이지로 이동
                    buyingProduct();
                } else {
                    Page.common();
                }
            } else if (cartExample == 3) {
                System.out.println("장바구니에 추가 할 품목의 번호를 입력하세요.");
                System.out.print("입력 > ");
                int inPut = (scanner.nextInt() - 1); //카테고리 내에서 장바구니에 넣을 상품 선택

                Product.books boo = booksArrayList.get(inPut);     //책 상품 중 해당 인덱스르 가져옴
                booksCart.add(boo);                                //가져온 품목을 장바구니에 추가
                System.out.println("장바구니에 추가되었습니다.");
                                                    //장바구니에 상품 추가 후 구매 여부 묻기
                System.out.println("장바구니에 추가한 항목을 구매하시려면 숫자 1을 입력해주세요.");
                System.out.print("입력 > ");
                int buyYesOrNo = scanner.nextInt();

                if (buyYesOrNo == 1) {
                    buyCategoryNum = 3; //책 구매 페이지로 이동
                    buyingProduct();
                } else {
                    Page.common();
                }
            } else {
                Page.errorMessage();
                Page.common();
            }
        } while (run);

    }

    //상품 구매 선택
    public static void buyingProduct() {
        run = true;
        do {
            if (buyCategoryNum == 1) {
                System.out.println("옷 구매 페이지로 이동합니다.");
                for (int i = 0; i < clothesCart.size(); i++) {
                    Product.clothes clo = clothesCart.get(i);
                    System.out.println( (i+1) + " 번째 상품 이름 : " + clo.getClothesName());
                }
                System.out.println("조회한 품목 중 구매할 품목의 번호를 입력하세요.");
                System.out.print("입력 > ");
                int inPut = (scanner.nextInt() - 1); //조회한 상품들 중 구매할 상품 선택

                Product.clothes clo = clothesCart.get(inPut);
                if (clo.getClothesPrice() > member[inPut].getBalance()) { //상품 금액이 사용자의 잔액보다 클 경우
                    System.out.println("잔액 부족");
                    Page.errorMessage();
                    Page.common();
                } else {
                    member[inPut].minusBalance(clo.getClothesPrice());    //상품 금액만큼 잔액에서 차감
                    System.out.println("상품 금액 " + clo.getClothesPrice() + "만큼 잔액에서 차감되었습니다.");
                    clothesCart.remove(inPut);
                    System.out.println("장바구니 목록에서 해당 상품을 삭제합니다."); //장바구니에서 구매 상품 제외
                    Page.common();
                }

            } else if (buyCategoryNum == 2) {
                System.out.println("전자기기 구매 페이지로 이동합니다.");
                for (int i = 0; i < devicesCart.size(); i++) {
                    Product.devices dev = devicesCart.get(i);
                    System.out.println( (i+1) + " 번째 상품 이름 : " + dev.getDevicesName());
                }
                System.out.println("조회한 품목 중 구매할 품목의 번호를 입력하세요.");
                System.out.print("입력 > ");
                int inPut = (scanner.nextInt() - 1); //조회한 상품들 중 구매할 상품 선택

                Product.devices dev = devicesCart.get(inPut);
                if (dev.getDevicesPrice() > member[inPut].getBalance()) { //상품 금액이 사용자의 잔액보다 클 경우
                    System.out.println("잔액 부족");
                    Page.errorMessage();
                    Page.common();
                } else {
                    member[inPut].minusBalance(dev.getDevicesPrice());    //상품 금액만큼 잔액에서 차감
                    System.out.println("상품 금액 " + dev.getDevicesPrice() + "만큼 잔액에서 차감되었습니다.");
                    devicesCart.remove(inPut);
                    System.out.println("장바구니 목록에서 해당 상품을 삭제합니다."); //장바구니에서 구매 상품 제외
                    Page.common();
                }
            } else if (buyCategoryNum == 3) {
                System.out.println("책 구매 페이지로 이동합니다.");
                for (int i = 0; i < booksCart.size(); i++) {
                    Product.books boo = booksCart.get(i);
                    System.out.println( (i+1) + " 번째 상품 이름 : " + boo.getBooksName());
                }
                System.out.println("조회한 품목 중 구매할 품목의 번호를 입력하세요.");
                System.out.print("입력 > ");
                int inPut = (scanner.nextInt() - 1); //조회한 상품들 중 구매할 상품 선택

                Product.books boo = booksCart.get(inPut);
                if (boo.getBooksPrice() > member[inPut].getBalance()) { //상품 금액이 사용자의 잔액보다 클 경우
                    System.out.println("잔액 부족");
                    Page.errorMessage();
                    Page.common();
                } else {
                    member[inPut].minusBalance(boo.getBooksPrice());    //상품 금액만큼 잔액에서 차감
                    System.out.println("상품 금액 " + boo.getBooksPrice() + "만큼 잔액에서 차감되었습니다.");
                    booksCart.remove(inPut);
                    System.out.println("장바구니 목록에서 해당 상품을 삭제합니다."); //장바구니에서 구매 상품 제외
                    Page.common();
                }
            } else {
                Page.errorMessage();
                //Page.common();
                System.out.println("홈으로 이동");
                run = false;
            }
        } while (run);
    }

    //상품 환불 선택
    public static void refundProduct() {
        //환불을 하려면 회원 별 구매목록을 통해 확인이 필요
        //but 시간 관계상, 확인 작업 없이 환불 (사실상 상품 등록이랑 비슷)
        //^^..아쉽지만 이건 추후에 보강하겠음
        System.out.println("상품 환불 페이지 입니다.");
        System.out.println("상품 환불 사유는 생략합니다.");

        System.out.println("환불할 상품의 카테고리 번호를 입력하세요");
        System.out.println("1.의류 | 2.전자기기 | 3.도서");
        System.out.print("선택 > ");
        int inputExample = scanner.nextInt();
        run = true;

        do {
            String inputName;
            String inputIntroduce;
            int inputPrice;
            try {
                if (inputExample == 1) {                    //의류 카테고리 상품 등록
                    System.out.println("환불할 상품의 이름을 입력하세요");
                    System.out.print("입력 > ");
                    inputName = scanner.next();
                    System.out.println("환불할 상품의 가격을 입력하세요");
                    System.out.print("입력 > ");
                    inputPrice = scanner.nextInt();
                    System.out.println("환불할 상품의 소개를 입력하세요");
                    System.out.print("입력 > ");
                    inputIntroduce = scanner.next();

                    clothesArrayList.add(new Product.clothes(inputName, inputPrice, inputIntroduce));
                    System.out.println("상품이 목록에 다시 업로드되었습니다.");
                    member[memberNum].plusBalance(inputPrice);
                    System.out.println("상품 금액만큼 잔액이 증감되었습니다.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("입력 받고자 하는 자료형이 다릅니다.");
            }
            try {
                if (inputExample == 2) {                    //전자기기 카테고리 상품 등록
                    System.out.println("환불할 상품의 이름을 입력하세요");
                    System.out.print("입력 > ");
                    inputName = scanner.next();
                    System.out.println("환불할 상품의 가격을 입력하세요");
                    System.out.print("입력 > ");
                    inputPrice = scanner.nextInt();
                    System.out.println("환불할 상품의 소개를 입력하세요");
                    System.out.print("입력 > ");
                    inputIntroduce = scanner.next();

                    devicesArrayList.add(new Product.devices(inputName, inputPrice, inputIntroduce));
                    System.out.println("상품이 목록에 다시 업로드되었습니다.");
                    member[memberNum].plusBalance(inputPrice);
                    System.out.println("상품 금액만큼 잔액이 증감되었습니다.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("입력 받고자 하는 자료형이 다릅니다.");
            }
            try {
                if (inputExample == 3) {                    //책 카테고리 상품 등록
                    System.out.println("환불할 상품의 이름을 입력하세요");
                    System.out.print("입력 > ");
                    inputName = scanner.next();
                    System.out.println("환불할 상품의 가격을 입력하세요");
                    System.out.print("입력 > ");
                    inputPrice = scanner.nextInt();
                    System.out.println("환불할 상품의 소개를 입력하세요");
                    System.out.print("입력 > ");
                    inputIntroduce = scanner.next();

                    booksArrayList.add(new Product.books(inputName, inputPrice, inputIntroduce));
                    System.out.println("상품이 목록에 다시 업로드되었습니다.");
                    member[memberNum].plusBalance(inputPrice);
                    System.out.println("상품 금액만큼 잔액이 증감되었습니다.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("입력 받고자 하는 자료형이 다릅니다.");
            }
        } while (run);
    }

    //추가 작업
    public static void additionalWork() {
        run = true;
        do {
            System.out.println("추가로 원하시는 작업이 있으시면 번호를 입력하세요.");
            System.out.println("1.장바구니 담기 | 2.상품 구매 | 3.나가기");
            int addSelect = scanner.nextInt();
            if (addSelect == 1) {             //장바구니 담기 선택
                registerShoppingCart();
            } else if (addSelect == 2) {      //상품 구매 선택
                buyingProduct();
            } else {                          //나가기 선택
                if (addSelect != 3) {
                    Page.errorMessage();
                    Page.common();
                }
                Page.common();
            }
        } while (run);
    }

    static {
        scanner = new Scanner(System.in);
    }
}