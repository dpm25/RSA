
public class DecodeInts {

    static long exponentD;
    static long modulusN;
    static long numberOfInts;
    static int[] allInts;

    static long expomod(long a, long n, long z) {
        long r = a % z;

        for (long i = 1; i < n; i++) {
            r = (a * r) % z;
        }
        return r;
    }

    static long findfirstnocommon(long n) {

        long j;
        for (j = 2; j < n; j++) {
            if (euclid(n, j) == 1) {
                return j;
            }
        }
        return 0;
    }

    static long findinverse(long n, long phi) {

        long i = 2;
        while (((i * n) % phi) != 1) {
            i++;
        }
        return i;
    }

    static long euclid(long m, long n) {

        // pre: m and n are two positive integers (not both 0)
        // post: returns the largest integer that divides both
        // m and n exactly
        while (m > 0) {
            long t = m;
            m = n % m;
            n = t;
        }
        return n;
    }

    public static void main(String args[]) {

        StdOut.print("Enter the decoding exponent d: ");
        exponentD = StdIn.readLong();

        StdOut.print("\nENter the modulus n :");
        modulusN = StdIn.readLong();

        StdOut.print("\nEnter the number of integers to decode: ");
        
        int length = StdIn.readInt();
        
        for (int i = 0; i < length; i++) {
            int m = StdIn.readInt();
            char c = (char) expomod(m, exponentD, modulusN);
            StdOut.print(c);
        }
        StdOut.println();
    }
}
