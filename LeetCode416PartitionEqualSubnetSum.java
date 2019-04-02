package dp;

import java.util.Arrays;

public class LeetCode416PartitionEqualSubnetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null) return false;
        int sum = 0;
        for(int num : nums) {
        	sum += num;
        }
        if(sum % 2 != 0 ) return false;
        Boolean[] mem = new Boolean[sum+1];
        return search(0,sum/2, nums,mem); //TODO      
    }
    private boolean search(int idx, int left, int[] nums, Boolean[] mem) {
    	if(left == 0) return true;
    	if(left < 0) return false;
    	if(mem[left] != null) return mem[left];
    	for(int i = idx; i < nums.length; i++) {
    		//decrease the left sum by removing the num[i] to left
    		if(search(i+1, left - nums[i], nums, mem)) {
    			mem[left] = true;
    			return true;
    		}
    	}
    	mem[left] = false;
    	return false;
    }
    public boolean canPartitionDP(int[] nums) {
        if(nums == null ) return false;
        int sum = 0;
        for(int num : nums) {
        	sum += num;
        }
        if(sum % 2 != 0 ) return false;
        sum = sum /2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        // how to use dp to represent the all solution 
        // stuck at how to get the dp induction rule 
        // induction rule is matching the DFS call 
        // for each number in the array, search every sum 
        for(int i = 1; i < nums.length; i++) {
        	if(dp[sum] == true) return dp[sum];
        	for(int j = sum; j >= nums[i - 1]; j--) {
        		dp[j] = dp[j] || dp[j - nums[i - 1]];
        	}
        }
        return dp[sum];
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode416PartitionEqualSubnetSum test = new LeetCode416PartitionEqualSubnetSum();
		int[] nums = {1,5,11,5};
//		System.out.println(test.canPartition(nums));
		System.out.println(test.canPartitionDP(nums));
	}

}
