package com.cleancode;

public class PrimePrinter {
    static final int M = 1000;
    static final int RR = 50;
    static final int CC = 4;
    static final int ORDMAX = 30;
    static int P[] = new int[M+1];
    static int J = 1;
    static int K = 1;
    static int ORD = 2;
    static int SQUARE = 9;
    static boolean JPRIME = true;
    static int MULT[] = new int[ORDMAX+1];
    static int N = 0;
    static int ROWOFFSET = 1;
    static int PAGENUMBER = 1;
    static int PAGEOFFSET = 1;

    public static void main(String[] args) {

        P[1] = 2;

        whileKtoM();
        PAGENUMBER = 1;
        while (PAGEOFFSET <= M) {
            printPage();
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
    }

    private static void printPage() {
        System.out.print("The First " + Integer.toString(M) + " Prime Numbers === Page " + Integer.toString(PAGENUMBER) + "\n");
        for (ROWOFFSET= PAGEOFFSET; ROWOFFSET <= PAGEOFFSET +RR-1; ROWOFFSET++) {
            for (int C = 0; C <= CC - 1; C++)
                if (ROWOFFSET + C * RR <= M)
                    System.out.printf("%10d", P[ROWOFFSET + C * RR]);
            System.out.println();
        }
        System.out.println("\f");
    }

    private static void whileKtoM() {
        while (K < M) {
            do {
                J += 2;
                if( J == SQUARE) {
                    ORD++;
                    SQUARE=P[ORD]*P[ORD];
                    MULT[ORD-1]=J;
                }
                N=2;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]=J;
        }
    }
}