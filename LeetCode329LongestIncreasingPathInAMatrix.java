
public class LeetCode329LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
    	// Do not use DP because it has four directions to expand 
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int res = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i ++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		res = Math.max(res, findTheLongestIncreasingPath(i,j,Integer.MIN_VALUE, matrix,mem));
        	}
        }
        return res;
    }
    private int findTheLongestIncreasingPath(int i, int j, int prev, int[][] matrix, int[][] mem) {
    	if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ||  matrix[i][j] <= prev) return 0;
    	if(mem[i][j] > 0) return mem[i][j];
    	int val = matrix[i][j];
    	int max = 0;
    	max =  Math.max(max, findTheLongestIncreasingPath(i+1, j, val, matrix,mem));
    	max =  Math.max(max, findTheLongestIncreasingPath(i-1, j, val, matrix,mem)); 
    	max =  Math.max(max, findTheLongestIncreasingPath(i, j+1, val, matrix,mem)); 
    	max =  Math.max(max, findTheLongestIncreasingPath(i, j-1, val, matrix,mem)); 
    	mem[i][j] = max + 1;
    	return max + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
