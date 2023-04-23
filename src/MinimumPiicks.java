// Example Input
// Input 1:

//  A = [0, 2, 9]
// Input 2:

//  A = [5, 17, 100, 1]


// Example Output
// Output 1:

// -7
// Output 2:

// 99


// Example Explanation
// Explanation 1:

// Maximum of all even numbers = 2
// Minimum of all odd numbers = 9
// ans = 2 - 9 = -7
// Explanation 2:

// Maximum of all even numbers = 100
// Minimum of all odd numbers = 1
// ans = 100 - 1 = 99  
public int solve(int[] A) {
      int maxeven = 0;
      int minodd= 0;
      for(int i=0;i<A.length;i++){
          if(A[i] % 2 == 0){
              maxeven = Math.max(maxeven,A[i]);
          }else{
              minodd = Math.min(minodd,A[i]);
          }
      }
      return maxeven - minodd;
      // Just write your code below to complete the function. Required input is available to you as the function arguments.
      // Do not print the result or any output. Just return the result via this function.
  }
