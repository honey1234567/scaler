## Qyuestion
<img width="396" alt="image" src="https://github.com/user-attachments/assets/88a20ebb-5a4d-4d97-bad6-d5840fae2d9d" />

A=[1,2,3]

<img width="406" alt="image" src="https://github.com/user-attachments/assets/1ecf390a-936f-40a9-a911-c6fe5c87be31" />

## APProa h
1) Make freq array of each element
2) iterate through freq array fior each i and j calculate imod j and multiply it with no of pair of i and j

3) ## code

   public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        int n = A.size(), mod = 1000 * 1000 * 1000 + 7;
        
        // To store the frequency of each element
        int[] cnt = new int[1009];
        
        // Store the frequency of each element
        for(int a: A)    
            cnt[a]++;
            
        // To store the required answer
        int ans = 0;
        
        // For all valid pairs
        for(int i = 1; i <= 1000; i++){
            if(cnt[i] == 0)    
                continue;
            for(int j = 1; j <= 1000; j++){
                if(cnt[j] == 0)    
                    continue;
                // Update the count
                int val = j % i;
                //multipliation of both count is totalpair
                int temp = cnt[i] * cnt[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return ans;
    }
}

