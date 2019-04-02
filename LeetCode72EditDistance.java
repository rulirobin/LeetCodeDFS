package dp;

public class LeetCode72EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1 == null || word2 == null) throw new IllegalArgumentException("Invalid input");
		return findMinDistance(0,0,word1, word2, new Integer[word1.length()][word2.length()]); //TODO
	}
	private int findMinDistance(int idx1, int idx2, String word1, String word2, Integer[][] mem) {
		if(idx1 == word1.length()) return word2.length() - idx2;
		if(idx2 == word2.length()) return word1.length() - idx1;
		if(mem[idx1][idx2] != null) return mem[idx1][idx2];
		int res = Integer.MAX_VALUE;
		if(word1.charAt(idx1) == word2.charAt(idx2)) {
			// match
			res = Math.min(res, findMinDistance(idx1 + 1, idx2 + 1, word1, word2,mem));
		}else {
			// delete 
			res = Math.min(res, 1 + findMinDistance(idx1+1, idx2, word1, word2,mem));
			// replace
			res = Math.min(res, 1 + findMinDistance(idx1+1, idx2+1, word1, word2,mem));
			// insert
			res = Math.min(res, 1 + findMinDistance(idx1, idx2+1, word1, word2,mem));
		}
		mem[idx1][idx2] = res;
		return res;
	
	}
	public int minDistanceDP(String word1, String word2) {
		if(word1 == null || word2 == null) throw new IllegalArgumentException("Invalid input");
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1+1][len2+1];
		// initialization
		for(int i = 0; i <= len2; i++ ) {
			dp[0][i] = i;
		}
		for(int i = 0; i <= len1; i++ ) {
			dp[i][0] = i;
		}
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				int num = Integer.MAX_VALUE;
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
					// Match
					num = Math.min(num, dp[i-1][j-1]);
				}else {
					// delete character in word1 
					num = Math.min(num, 1+dp[i-1][j]);
					// replace
					num = Math.min(num, 1+dp[i-1][j-1]);
					// insert character in word1, insert the character on the right 
					num = Math.min(num, 1+dp[i][j-1]);
				}
				dp[i][j]= num;
					
			}
		}
		return dp[len1][len2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode72EditDistance test = new LeetCode72EditDistance();
		System.out.println(test.minDistance("intention", "execution"));
		System.out.println(test.minDistanceDP("intention", "execution"));
	}

}
