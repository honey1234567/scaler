# Reference
Friends pairing - Pepcodeing

## Problem Description
In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.

## Solution
f(n) = f(n-1) + (n-1).f(n-2)

public class Solution {
    public int solve(int A) {
        int first = 1, second = 1;
        for(int i = 2; i <= A; i++) {
            int temp = (((i-1) * first) + second)%10003;
            first = second;
            second = temp;
        }
        return second;
    }
}
