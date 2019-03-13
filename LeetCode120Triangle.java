import java.util.ArrayList;
import java.util.List;

public class LeetCode120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	// dp solution
    	// dp[i][j] could be simplified to dp[i]
        if(triangle == null || triangle.size() == 0) return -1;   
        int[] res = new int[triangle.get(triangle.size()-1).size()];
        for(int i = triangle.size() - 1; i>=0; i--) {
        	for(int j = 0; j < triangle.get(i).size(); j++) {
        		Integer num = triangle.get(i).get(j);
        		if(i != triangle.size() -1) {
        			num += Math.min(res[j], res[j+1]);
        		}
        		res[j] = num;
        	}        
        }
        return res[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> level = new ArrayList<>();
		level.add
	}

}
