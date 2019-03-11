import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode131PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<>();
    	if(s == null || s.length() == 0) return res;
        boolean[] mem = new boolean[s.length()];
        Arrays.fill(mem, true);
    	findAllSolutions(0,s,new ArrayList<>(), res, mem);
    	return res;
    }
    private void findAllSolutions(int index, String s, List<String> path, List<List<String>> res, boolean[] mem) {
    	if(index == s.length()) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	if(!mem[index]) return;
    	int size = res.size();
    	for(int i = index; i < s.length(); i++) {
    		String curr = s.substring(index, i+ 1);
    		if(isPalindrome(curr)) {
    			path.add(curr);
    			findAllSolutions(i+1,s,path, res,mem);
    			path.remove(path.size() - 1);
    		}
    	}
    	if(size == res.size()) {
    		mem[index] =false;
    	}else {
    		mem[index] = true;
    	}
    }
    private boolean isPalindrome(String str) {
    	if(str.length() <= 1 ) return true;
    	if(str.charAt(0) == str.charAt(str.length() - 1)) {
    		return isPalindrome(str.substring(1,str.length() - 1));
    	}else {
    		return false;
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode131PalindromePartitioning test = new LeetCode131PalindromePartitioning();
		List<List<String>> res = test.partition("aab");
		for(List<String> list: res) {
			for(String str: list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

}
