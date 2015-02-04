// Dan Mahoney Assignement 5
// 
public class EncodeString {
    static long e;
    static long n;
    static String[] string;
    
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
    public static void main (String args []) {
        
        StdOut.print("Enter the decoding exponent e: ");
        e = StdIn.readLong();
        
        StdOut.print("\nEnter the moduls n :");
        n = StdIn.readLong();
        
        StdOut.print("\nEnter the string to encode: ");
        StdIn.readLine();
        String s = StdIn.readLine();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            StdOut.print(expomod(c, e, n));
            StdOut.print(" ");
        }
        StdOut.println();
    }
    
}
