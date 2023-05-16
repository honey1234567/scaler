
//store res in array
 public int[] solve(int[] A, int[] B) {
      // Just write your code below to complete the function. Required input is available to you as the function arguments.
      // Do not print the result or any output. Just return the result via this function.
      int l1 = A.length;
      int l2 = B.length;
      List c = new ArrayList<>();
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i = 0 ;i<A.length;i++){
          int f = map.getOrDefault(A[i],0);
          int n = f + 1;
          map.put(A[i],n);
      }
      for(int i =0;i<l2;i++){
          int freq = map.containsKey(B[i])?map.get(B[i]):0;
          if(freq > 0){
              int newfreq  = freq -1;
              map.put(B[i],newfreq);
             c.add(B[i]);
          }
      }
      int[] d = new int[c.size()];
      Iterator i = c.iterator();
      int j = 0;
      while(i.hasNext()){
          d[j++] = (int)i.next();//coz next returns type of object
      }
    
   
      return d;
  }
