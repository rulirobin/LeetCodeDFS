package dp;

// DFS: when i of s is equal to j of t, there are two options, one is to move i to i + 1, j to j + 1
// another is to keep j unchanged, just move i to i + 1 . 
// when i of s is not equal to j of t, there is only one option, which is to keep j unchanged, move i to i + 1.
// 
public class LeetCode115DistinctSubsequence {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() ==0 || t.length() == 0) return 0;
        Integer[][] mem = new Integer[s.length()+1][t.length()+1];
        return findNumDistinct(0,0,s,t,mem); // TODO
    }
    private int findNumDistinct(int idx1, int idx2, String s, String t, Integer[][] mem) {
    	if(idx1 == s.length() && idx2 != t.length()) {
    		return 0;
    	}
    	if(idx2 == t.length()) {
    		return 1;
    	}
    	if(mem[idx1][idx2] != null) return mem[idx1][idx2];
    	int res = 0;
    	if(s.charAt(idx1) == t.charAt(idx2)) {
    		// highlight
    		res += findNumDistinct(idx1+1, idx2+1, s ,t,mem) + findNumDistinct(idx1 + 1, idx2,s ,t, mem);
    	}else {
    		res += findNumDistinct(idx1+1,idx2, s, t,mem);
    	}
    	mem[idx1][idx2] = res;
    	return res;
    }
    
    // DP solution
    // highlight1: the meaning of dp[i][j] i and j is the number of characters in string i and j 
    // hightlight 2: base case. empty string is the substring of any string 
    // highlight 3: the induction of the dp formula. when i is not matching to j, i is undoubtedly added. but j is not matching, 
    // so we need to find the matching j from j+1 to lenS. when i is matching to j, there are two options. one is add i and j. 
    // another option is add i but not add j. continue to find another character matching the i in the range of j + 1 to lenS. 
    
    public int numDistinctDP(String s, String t) {
    	int lenS = s.length();
    	int lenT = t.length();
        if(s == null || t == null || lenS ==0 || lenT == 0) return 0;
        int[][] dp = new int[lenT+1][lenS+1];
        // base case 
        for(int i = 0; i<= lenS; i++) dp[0][i] = 1;
        for(int i = 0; i < lenT; i++) {
        	for(int j = i; j < lenS; j++) {
        		char charT = t.charAt(i);
        		char charS = s.charAt(j);
        		if(charT == charS) {
        			dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
        		}else {
        			dp[i + 1][j + 1] = dp[i + 1][j];
        		}
        	}
        }
        return dp[lenT][lenS];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode115DistinctSubsequence test = new LeetCode115DistinctSubsequence();
		System.out.println(test.numDistinct("rrabbbitt", "rabbit"));
		System.out.println(test.numDistinctDP("rabbbit", "rabbit"));
	}

}
