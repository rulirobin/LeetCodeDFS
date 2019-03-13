
public class LeetCode122BestTimeToBuyAndSellStockTwo {
	 public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0) return 0;
    	int min = prices[0];
    	int max = prices[0];
    	int res = 0;
    	for(int i = 0; i < prices.length; i++) {
    		int num = prices[i];
    		if(num < max) {
    			res += max - min;
    			max = num;
    			min = num;
    		}else{
    			max = num;
    		}
    	}
    	res += max - min;
    	return res; 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,3,4,5};
		LeetCode122BestTimeToBuyAndSellStockTwo test = new LeetCode122BestTimeToBuyAndSellStockTwo();
		System.out.println(test.maxProfit(prices));
	}

}
