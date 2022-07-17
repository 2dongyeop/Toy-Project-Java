package BroadcastSchedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final ArrayList<Program> programs = new ArrayList<>();
    private static String station;
    private static String menu;
    private static int index = 0;
    private static boolean is_exit = false;


    public static void main(String[] args) throws IOException {
        while (!is_exit) {
            selectStation();

            while (!station.equals("4")) {
                selectMenu();

                if (menu.equals("1")) addProgram();
                else if (menu.equals("2")) printProgram();
                else if (menu.equals("3")) searchProgram();
                else if (menu.equals("4")) updateProgram();
                else if (menu.equals("5")) deleteProgram();
                else if (menu.equals("6")) break;
            }
        }
    }

    private static final void selectStation() throws IOException {
        //프로그램이 시작되면 방송사를 선택해야 한다.
        System.out.println("=================================");
        System.out.println("방송사 선택");
        System.out.println("1. KBS | 2. MBC | 3.SBS | 4.종료");
        System.out.println("=================================");
        System.out.print("방송사를 선택하시오 : ");

        station = br.readLine();
        System.out.println();

        if (station.equals("4")) is_exit = true;
    }

    private static final void selectMenu() throws IOException {
        //선택된 방송사에 대한 메뉴 출력
        System.out.println("=============================================================");
        System.out.println("1. 추가 | 2. 출력 | 3. 검색 | 4. 수정 | 5. 삭제 | 6. 이전으로");
        System.out.println("=============================================================");
        System.out.print("메뉴를 선택하시오 : ");

        menu = br.readLine();
        System.out.println();
    }

    private static final void addProgram() throws IOException {
        // 방송에 대한 제목, 분야, 제작진, 방송하는 요일, 방송 시간 입력
        System.out.print("제목 : ");
        String title = br.readLine();
        System.out.print("분야 : ");
        String field = br.readLine();
        System.out.print("제작진 : ");
        String producer = br.readLine();
        System.out.print("방송 요일 : ");
        String broadcastDay = br.readLine();
        System.out.print("방송 시간 : ");
        String broadcastTime = br.readLine();

        programs.add(new Program(title, field, producer, broadcastDay, broadcastTime));

    }

    private static final void printProgram() {
        // 현재 추가된 전체 프로그램 정보 호출
        for (Program program : programs) {
            System.out.println("제목 : " + program.title);
            System.out.println("분야 : " + program.field);
            System.out.println("제작진 : " + program.producer);
            System.out.println("방송 요일 : " + program.broadcastDay);
            System.out.println("방송 시간 : " + program.broadcastTime);

            System.out.println();
        }
    }

    private static final void printProgram(Program program) {
        //해당 프로그램 정보 호출
        System.out.println("제목 : " + program.title);
        System.out.println("분야 : " + program.field);
        System.out.println("제작진 : " + program.producer);
        System.out.println("방송 요일 : " + program.broadcastDay);
        System.out.println("방송 시간 : " + program.broadcastTime);

        System.out.println();
    }

    private static final void searchProgram() throws IOException {
        //검색할 방송의 이름을 입력
        System.out.print("검색하실 방송 이름을 입력하세요 : ");
        final String title = br.readLine();
        System.out.println();

        // 제목이 일치하는 프로그램이 있으면 해당 프로그램 정보 출력
        for (Program program : programs) {
            if (title.equals(program.title)) printProgram(program);
        }
    }

    private static final void updateProgram() throws IOException {
        //방송 수정 메뉴
        index = 0; //초기화
        System.out.print("수정하실 방송 이름을 입력하세요 : ");
        final String title = br.readLine();
        System.out.println();

        //프로그램명이 동일한 프로그램이 있으면 수정할 부분 입력
        for (Program program : programs) {
            if (title.equals(program.title)) {
                printProgram(program);
                updatePart();
            } else index++;
        }
    }

    private static final void updatePart() throws IOException {
        final Program tempProgram = programs.get(index);

        System.out.println("제목 (1), 분야(2), 제작진(3), 요일(4), 방송시간(5)");
        System.out.print("수정하실 부분을 선택하세요 : ");
        final String updatePart = br.readLine();
        System.out.println();

        System.out.print("바꾸실 내용을 입력하세요 : ");
        final String newInput = br.readLine();
        System.out.println();

        if (updatePart.equals("1"))
            programs.set(index, new Program(newInput, tempProgram.field,
                    tempProgram.producer, tempProgram.broadcastDay, tempProgram.broadcastTime));
        if (updatePart.equals("2"))
            programs.set(index, new Program(tempProgram.title, newInput,
                    tempProgram.producer, tempProgram.broadcastDay, tempProgram.broadcastTime));
        if (updatePart.equals("3"))
            programs.set(index, new Program(tempProgram.title, tempProgram.field,
                    newInput, tempProgram.broadcastDay, tempProgram.broadcastTime));
        if (updatePart.equals("4"))
            programs.set(index, new Program(tempProgram.title, tempProgram.field,
                    tempProgram.producer, newInput, tempProgram.broadcastTime));
        if (updatePart.equals("5"))
            programs.set(index, new Program(tempProgram.title, tempProgram.field,
                    tempProgram.producer, tempProgram.broadcastDay, newInput));

    }

    private static final void deleteProgram() throws IOException {
        //삭제 메뉴 선택
        index = 0; //초기화
        System.out.print("삭제하실 방송 이름을 입력하세요 : ");
        final String title = br.readLine();
        System.out.println();

        //프로그램명이 일치하는게 있는지 확인
        for (Program program : programs) {
            if (title.equals(program.title)) {
                //삭제하기 전 해당 프로그램 정보 출력
                printProgram(program);
                programs.remove(index);  //지우기

                System.out.println("삭제되었습니다.");
            }
            index++;
        }
    }
}

class Program {
    String title;
    String field;
    String producer;
    String broadcastDay;
    String broadcastTime;

    Program(String title, String field, String producer, String broadcastDay, String broadcastTime) {
        this.title = title;
        this.field = field;
        this.producer = producer;
        this.broadcastDay = broadcastDay;
        this.broadcastTime = broadcastTime;
    }
}
