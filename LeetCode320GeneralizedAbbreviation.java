
import java.util.ArrayList;
import java.util.List;


public class LeetCode320GeneralizedAbbreviation {
	 public List<String> generateAbbreviations(String word){
		 List<String> res = new ArrayList<>();
		 if(word == null) return res;
		 findAllSolutions(0,0,new StringBuilder(), word, res);
		 return res;
	 }
	 private void findAllSolutions(int index, int cnt, StringBuilder path, String word, List<String> res) {
		 if(index == word.length()) {
			 int size = path.length();
			 if(cnt > 0) {
				 path.append(cnt);
				 res.add(path.toString());
				 path.setLength(size);
				 return;
			 }
			 res.add(path.toString());
			 return;
			 
		 }
		 // keep char 
		 int size = path.length();
		 if(cnt > 0) {
			 path.append(cnt);
		 }
		 path.append(word.charAt(index));
		 findAllSolutions(index + 1, 0, path,word,res);
		 path.setLength(size);
		 // keep digit
		 findAllSolutions(index + 1, cnt+1, path,word,res);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
