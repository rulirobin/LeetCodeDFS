import java.util.Stack;

public class LeetCode32LongestValidParentheses {
	// dp[i] meaning: the longest consecutive valid parentheses from i to the end
	// j is index of the matching ')' of the i when i is '('
	// when j is not the end, dp[i] = dp[i+1] + 2 + dp[j+1]
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) return 0;
        char[] chars = s.toCharArray();
        int len = chars.length; 
        int[] dp = new int[len + 1];
        dp[len] = 0;
        int max = 0;
        for(int i = len - 1; i >= 0; i--) {
        	if(chars[i] == ')') {
        		dp[i] = 0;
        	}
        	else if(chars[i] == '(') {
        		int j = i + dp[i + 1] + 1;
        		if(j < len && chars[j] == ')') {
        			dp[i] = dp[i + 1] + 2;
        			if(j + 1 < len) {
        				dp[i] += dp[j + 1];
        			}
        		}
        	}
        	max = Math.max(dp[i], max);
        }
        return max;
      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode32LongestValidParentheses test = new LeetCode32LongestValidParentheses();
		System.out.println(test.longestValidParentheses("(()))"));
		
	}

}
