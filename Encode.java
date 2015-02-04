// Dan Mahoney assignment 5
// 

public class Encode {

    static long e;
    static long n;
    static char m;
    
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

        StdOut.println("Please enter a public key pair (e, n)");
        StdOut.print("Enter e :");
        e = StdIn.readLong();
        
        StdOut.print("\nEnter n: ");
        n = StdIn.readLong();

        StdOut.print("\nPlease enter the individual character to be encoded:  ");
        StdIn.readChar();
        StdIn.readChar();
        m = StdIn.readChar();
        
        // encode m as c = m^e mod n using expomod
        long c = expomod(m, e, n);

        // c is sent to the receiver over an open channel
        StdOut.println("Transmitting encoding A as " + c);

    }
}
