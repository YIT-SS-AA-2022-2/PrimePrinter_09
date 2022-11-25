package com.cleancode;

public class PrimePrinter {
    static int P[] = new int[1001];
    static int PAGENUMBER  = 1;
    static int PAGEOFFSET  = 1;
    static int M = 1;
    static int K = 1;
    static  boolean  JPRIME=true;
    static int ORD = 2;
    static int SQUARE  = 9;
    static int N=2;
    static int MULT[] = new int[31];
    //선언 시에 초기화 해주기, 대체 가능한 변수는 선언하지 않기
    public static void main(String[] args) {
        P[1] = 2;
        whileKto1000();
        paging();

    }
//페이지 부분을 메소드 추출하여 따로 분리했다.
    private static void paging() {
        while (PAGEOFFSET <= 1000) {
            printPages();
            PAGENUMBER++;
            PAGEOFFSET += 50*4;

        }
    }
//반복문을 작은 함수로 따로 추출해낸다.
    private static void printPages() {
        System.out.print("The First 1000  Prime Numbers === Page " + Integer.toString(PAGENUMBER));
        System.out.println("\n");
        for (int i =PAGEOFFSET; i <= PAGEOFFSET+50-1; i++) {
            for (int j = 0; j <= 4 - 1; j++)
                if (i + j * 50 <= 1000)
                    System.out.printf("%10d", P[i + j* 50]);
            System.out.println();
        }
        System.out.println("\f");
    }

    private static void whileKto1000() {
        while (K < 1000) {
            doWhile();
            K++;
            P[K]=M;
        }
    }

    //반복문을 하나의 덩어리로 취급하여 해당 부분을 함수로 빼내기
    private static void doWhile() {
        do {
            M += 2;
            if( M == SQUARE) {
                ORD++;
                SQUARE=P[ORD]*P[ORD];
                MULT[ORD-1]=M;
            }
            isJprime();
        } while (!JPRIME);
    }

    //반복문 작은 함수로 빼내기
    private static void isJprime() {
        while (N < ORD && JPRIME) {
            while (MULT[N]<M)
                MULT[N] += P[N] + P[N];
            if (MULT[N] == M)
                JPRIME=false;
            N++;
        }
    }
}