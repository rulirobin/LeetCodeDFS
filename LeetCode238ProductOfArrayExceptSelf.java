package dp;

public class LeetCode238ProductOfArrayExceptSelf {
	// dp: two loops 
	// first loop, res[i] represents the product from index 0 to i - 1
	// second loop, use right to accumulate the product from i to end. res[i] * right is res[i]
	public int[] productExceptSelf(int[] nums) {
		if(nums == null || nums.length == 0) return new int[0];
		int len = nums.length;
		int[] res = new int[len];
		res[0] = 1;
		for(int i = 1; i < len; i++) {
			res[i] = res[i - 1]*nums[i - 1];
		}
		int right = 1;
		for(int i = len - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode238ProductOfArrayExceptSelf test = new LeetCode238ProductOfArrayExceptSelf();
		int[] nums = {0,0,3,4};
		int[] res = test.productExceptSelf(nums);
		for(int num : res) {
			System.out.print(" "+ num);
		}
	}

}
