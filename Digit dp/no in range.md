## How many no in[a,b] exist where digit d occurs exactly k times

<img width="642" height="582" alt="image" src="https://github.com/user-attachments/assets/7b4627c3-4dfb-4650-869f-c7da83592444" />

To count numbers in [a, b] where digit d occurs exactly k times, use digit DP.
The DP tracks position, count of d, tight bound, and leading zeros.

Concept of leading zero:
Leading zeros help avoid counting numbers like "0005" as valid unless zero is allowed. The flag ensures you only count numbers with at least one non-zero digit.

Code Explanation:
pos: current digit position
cnt: count of digit d so far
tight: restricts digits to not exceed the bound
leadingZero: true if all previous digits are zero
Java implementation:

public class DigitDP {
    private int[][][][] dp;
    private char[] num;
    private int targetDigit, targetCount;

    private int count(int pos, int cnt, boolean tight, boolean leadingZero) {
        if (pos == num.length) return (cnt == targetCount && !leadingZero) ? 1 : 0;
        int t = tight ? 1 : 0, lz = leadingZero ? 1 : 0;
        if (dp[pos][cnt][t][lz] != -1) return dp[pos][cnt][t][lz];

        int limit = tight ? num[pos] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextLeadingZero = leadingZero && (d == 0);
            int nextCnt = nextLeadingZero ? 0 : cnt + (d == targetDigit ? 1 : 0);
            res += count(pos + 1, nextCnt, nextTight, nextLeadingZero);
        }
        dp[pos][cnt][t][lz] = res;
        return res;
    }

    private int solve(String s, int d, int k) {
        this.targetDigit = d;
        this.targetCount = k;
        this.num = s.toCharArray();
        int n = num.length;
        dp = new int[n][k + 1][2][2];
        for (int[][][] arr1 : dp)
            for (int[][] arr2 : arr1)
                for (int[] arr3 : arr2)
                    java.util.Arrays.fill(arr3, -1);
        return count(0, 0, true, true);
    }

    public int countInRange(int a, int b, int d, int k) {
        return solve(Integer.toString(b), d, k) - solve(Integer.toString(a - 1), d, k);
    }
}


## How many no in[a,b] exist where sum of digit is divisible by k

here return sum of digit mod from each call and check tha in base case

and logic of filling numbers in position use samae logic as above coz we need to ensure no should be in given range

<img width="694" height="594" alt="image" src="https://github.com/user-attachments/assets/4e7b75d3-2ad2-4326-96f8-a13176b14090" />


## how many numbers in [a,b] exist where sum of digit is divisible by k code

To count numbers in [a, b] where the sum of digits is divisible by k, use digit DP. The DP state tracks position, current sum modulo k, tight bound, and leading zeros.

Concept of leading zero:

Leading zeros are digits at the start of a number that do not contribute to the sum (e.g., "007"). In digit DP, we use a leadingZero flag to avoid counting numbers with only zeros (unless zero is a valid number in the range).
Code Explanation:
pos: current digit position
sum: sum of digits modulo k
tight: restricts digits to not exceed the bound
leadingZero: true if all previous digits are zero
Java implementation:

public class DigitDP {
    private int[][][][] dp;
    private char[] num;
    private int k;

    private int count(int pos, int sum, boolean tight, boolean leadingZero) {
        if (pos == num.length) return (sum % k == 0 && !leadingZero) ? 1 : 0;
        int t = tight ? 1 : 0, lz = leadingZero ? 1 : 0;
        if (dp[pos][sum][t][lz] != -1) return dp[pos][sum][t][lz];

        int limit = tight ? num[pos] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextLeadingZero = leadingZero && (d == 0);
            res += count(pos + 1, nextLeadingZero ? 0 : (sum + d) % k, nextTight, nextLeadingZero);
        }
        dp[pos][sum][t][lz] = res;
        return res;
    }

    private int solve(String s, int k) {
        this.k = k;
        this.num = s.toCharArray();
        this.dp = new int[num.length][k][2][2];
        for (int[][][] arr1 : dp)
            for (int[][] arr2 : arr1)
                for (int[] arr3 : arr2)
                    java.util.Arrays.fill(arr3, -1);
        return count(0, 0, true, true);
    }

    public int countInRange(int a, int b, int k) {
        return solve(Integer.toString(b), k) - solve(Integer.toString(a - 1), k);
    }
}


## how many numbers in [a,b] exist where sum of digit and number itself is divisible by k code of digit dp and explain the code with concept of leading zero

To count numbers in [a, b] where both the sum of digits and the number itself are divisible by k, use digit DP.
The DP tracks position, sum modulo k, number modulo k, tight bound, and leading zeros.

Concept of leading zero:

Leading zeros help avoid counting numbers like "0005" as valid unless zero is allowed. The flag ensures you only count numbers with at least one non-zero digit.

Code Explanation:
pos: current digit position
sumMod: sum of digits modulo k
numMod: number modulo k
tight: restricts digits to not exceed the bound
leadingZero: true if all previous digits are zero

public class DigitDP {
    private int[][][][][] dp;
    private char[] num;
    private int k;

    private int count(int pos, int sumMod, int numMod, boolean tight, boolean leadingZero) {
        if (pos == num.length) return (sumMod == 0 && numMod == 0 && !leadingZero) ? 1 : 0;
        int t = tight ? 1 : 0, lz = leadingZero ? 1 : 0;
        if (dp[pos][sumMod][numMod][t][lz] != -1) return dp[pos][sumMod][numMod][t][lz];

        int limit = tight ? num[pos] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextLeadingZero = leadingZero && (d == 0);
            int nextSumMod = nextLeadingZero ? 0 : (sumMod + d) % k;
            int nextNumMod = nextLeadingZero ? 0 : (numMod * 10 + d) % k;
            res += count(pos + 1, nextSumMod, nextNumMod, nextTight, nextLeadingZero);
        }
        dp[pos][sumMod][numMod][t][lz] = res;
        return res;
    }

    private int solve(String s, int k) {
        this.k = k;
        this.num = s.toCharArray();
        int n = num.length;
        dp = new int[n][k][k][2][2];
        for (int[][][][] arr1 : dp)
            for (int[][][] arr2 : arr1)
                for (int[][] arr3 : arr2)
                    for (int[] arr4 : arr3)
                        java.util.Arrays.fill(arr4, -1);
        return count(0, 0, 0, true, true);
    }

    public int countInRange(int a, int b, int k) {
        return solve(Integer.toString(b), k) - solve(Integer.toString(a - 1), k);
    }
}
new DigitDP().countInRange(a, b, k);
This returns the count of numbers in [a, b] where both the sum of digits and the number itself are divisible by k, handling leading zeros correctly.

# how many numbers in [a,b] exist wheresum of digit at even position-sum of digit at odd position =1

To count numbers in [a, b] where the difference between the sum of digits at even positions and the sum at odd positions equals 1, use digit DP.
Track position, even sum, odd sum, tight bound, and leading zeros.

Concept of leading zero:
Leading zeros ensure you only count numbers with at least one non-zero digit. If all digits so far are zero, don't update sums.

Code Explanation:
pos: current digit position
evenSum, oddSum: sums at even/odd positions
tight: restricts digits to not exceed the bound
leadingZero: true if all previous digits are zero

public class DigitDP {
    private int[][][][][] dp;
    private char[] num;

    private int count(int pos, int evenSum, int oddSum, boolean tight, boolean leadingZero) {
        if (pos == num.length) return (evenSum - oddSum == 1 && !leadingZero) ? 1 : 0;
        int t = tight ? 1 : 0, lz = leadingZero ? 1 : 0;
        if (dp[pos][evenSum][oddSum][t][lz] != -1) return dp[pos][evenSum][oddSum][t][lz];

        int limit = tight ? num[pos] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextLeadingZero = leadingZero && (d == 0);
            int nextEvenSum = evenSum, nextOddSum = oddSum;
            if (!nextLeadingZero) {
                if ((pos % 2) == 0) nextEvenSum += d;
                else nextOddSum += d;
            }
            res += count(pos + 1, nextEvenSum, nextOddSum, nextTight, nextLeadingZero);
        }
        dp[pos][evenSum][oddSum][t][lz] = res;
        return res;
    }

    private int solve(String s) {
        this.num = s.toCharArray();
        int n = num.length;
        // Max sum for each position is 9*n, adjust as needed
        dp = new int[n][9 * n + 1][9 * n + 1][2][2];
        for (int[][][][] arr1 : dp)
            for (int[][][] arr2 : arr1)
                for (int[][] arr3 : arr2)
                    for (int[] arr4 : arr3)
                        java.util.Arrays.fill(arr4, -1);
        return count(0, 0, 0, true, true);
    }

    public int countInRange(int a, int b) {
        return solve(Integer.toString(b)) - solve(Integer.toString(a - 1));
    }
}

