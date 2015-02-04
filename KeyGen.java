//
////import static SimpleCrypto.euclid;
//import static SimpleCrypto.findfirstnocommon;

// Dan Mahoney
// Assignement 5
public class KeyGen {

    static long p;
    static long q;

    static long findfirstnocommon(long n) {

        long j;
        for (j = 2; j < n; j++) {
            if (euclid(n, j) == 1) {
                return j;
            }
        }
        return 0;
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

    static long findinverse(long n, long phi) {

        long i = 2;
        while (((i * n) % phi) != 1) {
            i++;
        }
        return i;
    }

    public static void main(String args[]) {
        StdOut.println("Please enter two prime numbers for p and q: ");
        StdOut.print("p: ");
        p = StdIn.readInt();

        StdOut.print("q: ");
        q = StdIn.readInt();

        while (p < q) {
            // compute the value of n
            long n = p * q;
            StdOut.println("\nThe value of n = " + n);

            // Compute phi = (p-1)*(q-1)
            long phi = (p - 1) * (q - 1);
            StdOut.println("The value of PHI = " + phi);

            // choose a random prime e between 1 and phi, exclusive,  
            // so that e has no common factors with phi.
            long e = findfirstnocommon(phi);
            StdOut.println("The value of e = " + e);

            // find d as the multiplicative of the inverse of e
            // modulo phi(n).
            long d = findinverse(e, phi);
            StdOut.println("The value of d = " + d);
            break;
        }
    }
}
