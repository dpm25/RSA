// Dan Mahoney
// assignment 5
//

public class Decode {

    static char m;
    static long d;
    static long n;
    static long e;

    // Let a and n be two long integers with n > 0. We wish to
    // compute x = a^n mod z.
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

        StdOut.print("Please enter a private key pair (d, n) ");
        StdOut.print("\n Enter d: ");
        d = StdIn.readLong();

        StdOut.print("\nEnter n: ");
        n = StdIn.readLong();

        StdOut.print("\nPlease enter the integer to be decoded: ");
        //StdIn.readLong();
        e = StdIn.readLong();

        // decode c to m = c^d mod n
        m = (char) expomod(e, d, n);

        // c is sent to the receiver over an open channel
        System.out.println("Decoding " + e + " to " + m);
    }
}
