import java.util.HashSet;
import java.util.Set;

public class LeetCode694NumberOfDistrictIslands {
	public int numDistinctIslands(int[][] grid) {
		if(grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) return 0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		Set<String> set = new HashSet<>();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					StringBuilder path = new StringBuilder();
					findAllDistrictIslands(i, j, "", path, grid,visited);
					set.add(path.toString());
				}
			}
		}
		return set.size();
	}
	private void findAllDistrictIslands(int i, int j,String dir, StringBuilder path, int[][] grid, boolean[][] visited) {
		if(i  < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
			return;
		}
		path.append(dir);
		visited[i][j] = true;
		// up
		findAllDistrictIslands(i - 1, j,"u" ,path, grid, visited);
		// right
		findAllDistrictIslands(i , j + 1,"r" ,path, grid, visited);
		// down
		findAllDistrictIslands(i + 1, j,"d" ,path, grid, visited);
		// left
		findAllDistrictIslands(i , j - 1,"l" ,path, grid, visited);
		path.append("x");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
		LeetCode694NumberOfDistrictIslands test = new LeetCode694NumberOfDistrictIslands();
		System.out.println(test.numDistinctIslands(grid));
	}

}
