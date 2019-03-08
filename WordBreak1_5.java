import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak1_5 {

	public String wordBreak(String s, List<String> wordDict){
		String res = new String();
		if(s == null || wordDict == null) return res;
		int[] map = new int[s.length() + 1];
        Set<String> dict = new HashSet<String>();
        for(String word: wordDict) {
        	dict.add(word);
        }
        Boolean[] mem = new Boolean[s.length()];
		if(!findAllSolutions(0,s,dict,mem,map)){
			return res;
		}
		int i = s.length();
		while(i > 0) {
			int tmp = map[i];
			res = s.substring(tmp, i) +" "+ res;
			i = tmp;
		}
		return res.substring(0,res.length()-1);
		
	}
	private Boolean findAllSolutions(int index, String s, Set<String> dict, Boolean[] mem,int[] map) {
		 if(index == s.length()) {
			 return true;
		 }
		 if(mem[index] != null) {
			 return mem[index];
		 }
		 for(int i = index + 1; i <= s.length(); i++) {
			 String curr= s.substring(index, i);
			 if(dict.contains(curr)) {
				 if(findAllSolutions(i,s,dict,mem,map)) {
					 map[i]= index;
					 mem[index] = true;
					 return true;
				 }
			 }
		 }
		 mem[index] = false;
		 return false;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak1_5 test = new WordBreak1_5();
		List<String> wordDict = new ArrayList();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
//		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(test.wordBreak("catsanddog", wordDict));
	}

}
