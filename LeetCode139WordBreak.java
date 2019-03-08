import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139WordBreak {
	 public boolean wordBreak(String s, List<String> wordDict) {
	        if(s == null || wordDict == null) return false;
	        // DFS + Pruning
	        Set<String> dict = new HashSet<String>();
	        for(String word: wordDict) {
	        	dict.add(word);
	        }
//	        Boolean[] mem = new Boolean[s.length()];
//	        return findAllSolutions(0,s,dict,mem);
	        //DP
	        boolean[] dp = new boolean[s.length()  +1];
	        dp[s.length()] = true;
	        for(int i = s.length() - 1; i >= 0; i--) {
	        	for(int j = i + 1; j <= s.length(); j++) {
	        		String curr = s.substring(i,j);
	        		if(dict.contains(curr) && dp[j]) {
	        			dp[i] = true;
	        			break;
	        		}
	        	}
	        }
	        return dp[0];
	        
	        
	 }
	 private Boolean findAllSolutions(int index, String s, Set<String> dict, Boolean[] mem) {
		 if(index == s.length()) {
			 return true;
		 }
		 if(mem[index] != null) {
			 return mem[index];
		 }
		 for(int i = index + 1; i <= s.length(); i++) {
			 String curr= s.substring(index, i);
			 if(dict.contains(curr)) {
				 if(findAllSolutions(i,s,dict,mem)) {
					 mem[index] = true;
					 return true;
				 }
			 }
		 }
		 mem[index] = false;
		 return false;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode139WordBreak test = new LeetCode139WordBreak();
		List<String> wordDict = new ArrayList();
//		wordDict.add("cat");
//		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(test.wordBreak("catsanddog", wordDict));
	}

}
