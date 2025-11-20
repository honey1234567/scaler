Here is a Java implementation of fast matrix exponentiation using recursion, handling both even and odd exponent cases:

public class MatrixExponentiationRecursive {
    // Multiplies two matrices modulo mod
    public static int[][] multiply(int[][] a, int[][] b, int mod) {
        int n = a.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    result[i][j] = (result[i][j] + (int)((1L * a[i][k] * b[k][j]) % mod)) % mod;
        return result;
    }

    // Returns identity matrix of size n
    public static int[][] identity(int n) {
        int[][] id = new int[n][n];
        for (int i = 0; i < n; i++) id[i][i] = 1;
        return id;
    }

    // Recursive fast exponentiation of matrix a to power exp modulo mod
    public static int[][] power(int[][] a, long exp, int mod) {
        int n = a.length;
        if (exp == 0) return identity(n);
        if (exp == 1) return a;
        if (exp % 2 == 0) {
            int[][] half = power(a, exp / 2, mod);
            return multiply(half, half, mod);
        } else {
            int[][] half = power(a, exp / 2, mod);
            return multiply(multiply(half, half, mod), a, mod);
        }
    }
}

Explanation:
If exponent is 0, return identity matrix.
If exponent is 1, return the matrix itself.
If exponent is even, recursively compute half the power, then multiply half by itself.
If exponent is odd, recursively compute half the power, multiply half by itself, then multiply by the matrix once more.
This approach is efficient and works for both even and odd exponents using recursion.
