package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode90SubnetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums == null || nums.length == 0) return res;
    	findAllSubnets(0,nums,new ArrayList<>(), res);
    	return res;
    }
    private void findAllSubnets(int index, int[] nums, List<Integer> subnet, List<List<Integer>> res) {
    	res.add(new ArrayList<>(subnet));
    	for(int i = index; i <nums.length; i++) {
    		subnet.add(nums[i]);
    		findAllSubnets(i+1,nums,subnet,res);
    		subnet.remove(subnet.size() - 1);
    		while(i + 1 < nums.length && nums[i] == nums[i+1]) {
    			i++;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode90SubnetsTwo test = new LeetCode90SubnetsTwo();
		int[] nums = {1,2,2};
		List<List<Integer>> res = test.subsetsWithDup(nums);
		for(List<Integer> list :res) {
			for(Integer num: list) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
