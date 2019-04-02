package dp;

import java.util.Arrays;

public class LeetCode377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] mem = new int[target+1];
        Arrays.fill(mem, -1);
        return findCombination(target, nums, mem); //TODO
    }
    private int findCombination(int sum, int[] nums, int[] mem) {
    	if(sum == 0) return 1;
    	if(sum < 0) return 0;
    	if(mem[sum] != -1) return mem[sum];
    	int res = 0;
    	for(int i  = 0; i < nums.length; i++) {
    		int num = findCombination(sum - nums[i], nums, mem);
    		res += num;
    	}
    	mem[sum] = res;
    	return res;
    }
    public int combinationSum4DP(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
        	for(int num : nums) {
        		if(i >= num) dp[i] += dp[i - num];
        	}
        }
        return dp[target];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode377CombinationSumIV test = new LeetCode377CombinationSumIV();
		int[] nums = {1,2,3,4};
		System.out.println(test.combinationSum4(nums, 6));
		System.out.println(test.combinationSum4DP(nums, 6));
	}

}
