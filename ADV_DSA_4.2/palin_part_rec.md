public class Solution {
	public ArrayList<ArrayList<String>> partition(String A) {
        ArrayList<ArrayList<String>> response = new ArrayList<>();
        ArrayList<String> currentList = new ArrayList<>();
        addBreakPoint(0, A, currentList, response);
        return response;
	}
    public void addBreakPoint(int index, String A, ArrayList<String> currentList, ArrayList<ArrayList<String>> response){
        if(index == A.length()){
            response.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = index; i < A.length(); i++){
            if(isPalindrome(A, index, i)){
                currentList.add(A.substring(index, i + 1));
                addBreakPoint(i + 1, A, currentList, response);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String A, int s, int e){ 
        while(s < e){
            if(A.charAt(s) != A.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }

}
