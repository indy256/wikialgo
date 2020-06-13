package combinatorics;

import java.math.BigInteger;

public class BinomialCoefficients {
    public static long[][] binomialTable(int n) {
        long[][] c = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= i; j++)
                c[i][j] = (j == 0) ? 1 : c[i - 1][j - 1] + c[i - 1][j];
        return c;
    }

    public static long binomial(long n, long m) {
        m = Math.min(m, n - m);
        long res = 1;
        for (long i = 0; i < m; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res;
    }

    // for (int i = 1; i < f.length; i++) f[i] = f[i - 1] + Math.log(i);
    public static double binomial(int n, int m, double[] f) {
        if (m < 0 || m > n)
            return 0;
        return Math.exp(f[n] - f[m] - f[n - m]);
    }

    // n! % mod
    public static int factorial(int n, int mod) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i % mod;
        return (int) (res % mod);
    }

    // n! mod p, p - prime, O(p*log(n)) complexity
    public static int factorial2(int n, int p) {
        int res = 1;
        while (n > 1) {
            res = (res * ((n / p) % 2 == 1 ? p - 1 : 1)) % p;
            for (int i = 2; i <= n % p; ++i)
                res = (res * i) % p;
            n /= p;
        }
        return res % p;
    }

    // fact[0] = ifact[0] = fact[1] = ifact[1] = inv[1] = 1;
    // for (int i = 2; i < fact.length; i++)
    //   fact[i] = (int)c((long) fact[i - 1] * i % mod);
    //   inv[i] = (int) ((long) (p - p / i) * inv[p % i] % p);
    //   ifact[i] = (int)c((long) ifact[i - 1] * inv[i] % mod);
    public static int binomial(int n, int m, int[] fact, int[] ifact, int mod) {
        return (int) ((long) fact[n] * ifact[m] % mod * ifact[n - m] % mod);
    }

    // Usage example
    public static void main(String[] args) {}
}
