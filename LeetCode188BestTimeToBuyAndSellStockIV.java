package dp;

public class LeetCode188BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        return findMaxProfit(k,0,prices,true); //TODO
    }
   private int num;
    private int findMaxProfit(int k, int idx, int profit, int[] prices, boolean buy) {
    	if(k == 0) return 0;
    	if(idx == prices.length) return 0;
    	int res = 0;
    	for(int i = idx; i < prices.length; i++) {
    		if(buy) {
    			res = Math.max(res, findMaxProfit(k-1,idx+1,prices,false) - prices[idx]);
    		}else {
    			res = Math.max(res, findMaxProfit(k-1,idx+1,prices,true) + prices[idx]);
    		}
    	}
    	return res;
    	
//    	
//    	int res = 0;
//    
//		// rest
//		res = Math.max(res,findMaxProfit(k,idx+1,prices,buy) );
//		// buy
//		if(buy) {
//			res = Math.max(res, findMaxProfit(k-1,idx+1,prices,false) - prices[idx]);
//		}else {
//			res = Math.max(res, findMaxProfit(k-1,idx+1,prices,true) + prices[idx]);
//		}
//		num+= res;
//		return res;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode188BestTimeToBuyAndSellStockIV test = new LeetCode188BestTimeToBuyAndSellStockIV();
		int[] prices = {2,6,0,3};
		System.out.println(test.maxProfit(2, prices));
	}

}
