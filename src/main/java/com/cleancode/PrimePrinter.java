package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int MnumberOfPrimes = 1000,linesPerPage = 50,columns = 4,ORDMAX = 30;
        int primes[] = new int[MnumberOfPrimes+1];
        int pagenumber, pageoffset, rowoffset, column, candidate, primeIndex, ord, square;
        boolean possiblyPrime;
        int n=0;
        int multiples[] = new int[ORDMAX+1];
        candidate=1;
        primeIndex=1;
        primes[1] = 2;
        ord = 2;
        square = 9;
        primeIndexCompareMnumberOfPrimes(MnumberOfPrimes, primes, candidate, primeIndex, ord, square, multiples);
        pagenumber = 1;
        pageoffset = 1;
        whilepageoffsetMnumberOfPrimes(MnumberOfPrimes, linesPerPage, columns, primes, pagenumber, pageoffset);
    }

    private static void primeIndexCompareMnumberOfPrimes(int MnumberOfPrimes, int[] primes, int candidate, int primeIndex, int ord, int square, int[] multiples) {
        int n;
        boolean possiblyPrime;
        while (primeIndex < MnumberOfPrimes) {
            do {
                candidate += 2;
                if( candidate == square) {
                    ord++;
                    square = primes[ord]* primes[ord];
                    multiples[ord -1]= candidate;
                }
                n=2;
                possiblyPrime=true;
                possiblyPrime = isPossiblyPrime(primes, candidate, possiblyPrime, ord, n, multiples);
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex]= candidate;
        }
    }

    private static boolean isPossiblyPrime(int[] primes, int candidate, boolean possiblyPrime, int ord, int n, int[] multiples) {
        while (n < ord && possiblyPrime) {
            multiplescomparecandidate(primes, candidate, n, multiples);
            possiblyPrime = isPossiblyPrime(candidate, possiblyPrime, n, multiples);
            n++;
        }
        return possiblyPrime;
    }

    private static void multiplescomparecandidate(int[] primes, int candidate, int n, int[] multiples) {
        while (multiples[n]< candidate)
            multiples[n] += primes[n] + primes[n];
    }

    private static boolean isPossiblyPrime(int candidate, boolean possiblyPrime, int n, int[] multiples) {
        if (multiples[n] == candidate)
            possiblyPrime =false;
        return possiblyPrime;
    }

    private static void whilepageoffsetMnumberOfPrimes(int MnumberOfPrimes, int linesPerPage, int columns, int[] primes, int pagenumber, int pageoffset) {
        while (pageoffset <= MnumberOfPrimes) {
            System.out.print("The First "+Integer.toString(MnumberOfPrimes)+
                    " Prime Numbers === Page "+Integer.toString(pagenumber)+"\n");
            forRowoffset(MnumberOfPrimes, linesPerPage, columns, primes, pageoffset);
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;

        }
    }

    private static void forRowoffset(int MnumberOfPrimes, int linesPerPage, int columns, int[] primes, int pageoffset) {
        int rowoffset;
        for (rowoffset= pageoffset; rowoffset <= pageoffset + linesPerPage -1; rowoffset++) {
            forcolumn(MnumberOfPrimes, linesPerPage, columns, primes, rowoffset);
            System.out.println();
        }
    }

    private static void forcolumn(int MnumberOfPrimes, int linesPerPage, int columns, int[] primes, int rowoffset) {
        int column;
        for (column = 0; column <= columns - 1; column++)
            rowoffsetcolumnlinesPerPageMnumberOfPrimes(MnumberOfPrimes, linesPerPage, primes, rowoffset, column);
    }

    private static void rowoffsetcolumnlinesPerPageMnumberOfPrimes(int MnumberOfPrimes, int linesPerPage, int[] primes, int rowoffset, int column) {
        if (rowoffset + column * linesPerPage <= MnumberOfPrimes)
            System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
    }
}