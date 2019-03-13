
public class LeetCode121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0) return 0;
    	int min = prices[0];
    	int max = prices[0];
    	int res = 0;
    	for(int i = 0; i < prices.length; i++) {
    		int num = prices[i];
    		if(num < min) {
    			min = num;
    			max = num;
    		}else if(num > max) {
    			max = num;
    		}else {
    			continue;
    		}
    		res = Math.max(res, max - min);
    	}
    	return res;   	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,6,4,3,1};
		LeetCode121BestTimeToBuyAndSellStock test = new LeetCode121BestTimeToBuyAndSellStock();
		System.out.println(test.maxProfit(prices));
	}

}
