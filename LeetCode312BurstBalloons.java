package dp;

// reverse thinking
// instead of finding the first balloon to burst, finding the last balloon to burst and then trace back. 
// the reason of starting from the last balloon is that the boundary is fixed. 
// divide and conquer, use for loop to search each location in the fixed range to find the maximum coins 
public class LeetCode312BurstBalloons {
//    public int maxCoins(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int len = nums.length;
//        int[] newNums = new int[len+2];
//        for(int i = 0; i < len; i++) newNums[i+1] = nums[i];
//        newNums[0] = newNums[len + 1] = 1;
//        int[][] mem = new int[len + 2][ len + 2];
//        return findMaxCoins(0,len+1,newNums,mem);
//    }
//    private int findMaxCoins(int left, int right, int[] nums, int[][] mem) {
//    	if(left + 1 == right) {
//    		return 0;
//    	}
//    	if(mem[left][right] > 0) return mem[left][right];
//    	int ans = 0;
//    	for(int i = left + 1; i< right; i++) {
//    		ans = Math.max(ans, nums[left] * nums[i] * nums[right] + findMaxCoins(left, i, nums, mem) + findMaxCoins(i,right,nums,mem));
//    	}
//    	mem[left][right] = ans;
//    	return ans; 	
//    }
    // DP 
    // dp[i][j] means in the range between i and j, the maximum coins we could get. 
    // in order to calculate the dp[i][j], we need to iterate the whole range in order to find the optimal last location to burst. 

    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        // add two balloons, one is put in the front, the other is put in the last. it makes sure that the index is always in the range
        int[] newNums = new int[len+2];
        for(int i = 0; i < len; i++) newNums[i+1] = nums[i];
        newNums[0] = newNums[len + 1] = 1;
        int[][] dp = new int[len + 2][ len + 2];
        // use size to locate the right index 
        // use i to traverse the balloons from left to right. 
        // for the induction rule. use size one to do the verification. 
        for(int size = 1; size <= len; size++) {
        	for(int left = 1;left<= len-size+1; left++) {
        		int right = left+size-1;
        		for(int i = left; i <= right; i++ ) {
        			// index i is the last balloon to burst in the range from i to j(including), so the left is left - 1, right is right + 1
        			// then the rest is divided into two subnets 
        			// the left subnet starts from left to i-1
        			// the right subnet starts from i+1 to right
        			dp[left][right] = Math.max(dp[left][right], newNums[left-1] * newNums[i]* newNums[right+1] + dp[left][i-1] + dp[i+1][right]);
        		}
        	}
        }
        return dp[1][len];
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode312BurstBalloons test = new LeetCode312BurstBalloons();
		int[] nums = {3,1,5,8};
		System.out.println(test.maxCoins(nums));
	}

}
