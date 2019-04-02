package dp;
// intelligence 
// question trick: no more than two adjacent fence posts have the same color
// track two variables, one is the different color counts(current post has different color than last post)
// another is the same color counts(current post has same color as last post)
public class LeetCode276PaintFence {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        int sameColors = k;
        int differentColors = k*(k - 1);
        for(int i = 3; i <= n; i++) {
        	int tmp = differentColors;
        	differentColors = (sameColors + differentColors) * (k - 1);
        	sameColors = tmp;
        }
        return sameColors + differentColors;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode276PaintFence test = new LeetCode276PaintFence();
		System.out.println(test.numWays(3, 2));
	}

}
