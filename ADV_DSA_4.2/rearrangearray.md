https://www.youtube.com/watch?v=IEr74xZGNoU

## Solution

import java.lang.*;
import java.util.*;
import java.util.Collections;
public class Solution {
    public void arrange(ArrayList<Integer> A) {
        int n = A.size();

        for(int i = 0;i<n;i++){
            int x = A.get(i);
            int y = A.get(x)%n;
            //by modn extract orig number from used indexes
           int value =x + (y)*n;
           A.set(i,value);
        }
        //if n = A+b*c then A = n%c,b=n/c;

        for(int i=0;i<n;i++){
            A.set(i,A.get(i)/n);
        }
    }
}

