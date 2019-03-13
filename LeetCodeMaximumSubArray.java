
public class LeetCodeMaximumSubArray {
	// dp solution
	// count is the sum of continuous array. count is the bigger number of count + num[i] and num[i]
    public int maxSubArray(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	int len = nums.length;
    	int count = 0;
    	int max = Integer.MIN_VALUE;
    	for(int i = len -1; i >= 0; i--) {
    		count = Math.max(nums[i], count + nums[i]);
    		max = Math.max(max, count);
    	}
    	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
