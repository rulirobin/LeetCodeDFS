package dp;

public class LeetCode256PaintHouse {
	// the following the wrong solution. I did not think it thoroughly. this solution is to compare the final result starting from each color
	// then find out the mininum. however the best solution is not comparing all the solutions. it misses the solutions which not use the current
	// cheapest price instead use the second or third. 
//    public int minCost(int[][] costs) {
//        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
//        int rows = costs.length;
//        int res = Integer.MAX_VALUE;
//        for(int color = 0; color <= 2; color ++) {
//        	int minCost = costs[0][color];
//        	int prevMinPriceIndex = color;
//        	for(int i = 1; i < rows; i++) {
//        		int currMinCost = Integer.MAX_VALUE; 	
//        		int currMinPriceIndex = 0;
//        		for(int j = 0; j<=2; j++) {
//        			if(j != prevMinPriceIndex && costs[i][j] < currMinCost) {
//        				currMinCost = costs[i][j];
//        				currMinPriceIndex = j;
//        			}
//        		}
//        		prevMinPriceIndex = currMinPriceIndex;
//        		minCost += currMinCost;
//        	}
//        	res = Math.min(res, minCost);
//        }
//        return res;
//        
//    }
	// dp solution 
	// 
	public int minCost(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
		int[] prev =  new int[3];
		int[] curr = new int[3];
		for(int j = 0; j <= 2; j++) {
			prev[j] = costs[0][j];
		}
		for(int i = 1; i < costs.length; i++) {
			curr[0] = costs[i][0] + Math.min(prev[1], prev[2]);
			curr[1] = costs[i][1] + Math.min(prev[0], prev[2]);
			curr[2] = costs[i][2] + Math.min(prev[0], prev[1]);
			// deep copy
			int[] tmp = prev;
			prev = curr;
			curr = tmp;
			
			
			// this is shallow copy, prev and curr point to the same address. if I change curr[0], prev[0] is also changed 
			//prev = curr;
			
		}
		return Math.min(prev[0], Math.min(prev[1], prev[2]));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode256PaintHouse test = new LeetCode256PaintHouse();
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(test.minCost(costs));
		int[] prev = {1,2,3};
		int[] curr = {4,5,6};
		int[] tmp = prev;
		prev = curr;
		curr = tmp;
	
		curr[0] = 7;
		System.out.println(prev[0]);
	}

}
