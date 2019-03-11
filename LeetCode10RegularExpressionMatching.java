
public class LeetCode10RegularExpressionMatching {
	 public boolean isMatch(String s, String p) {
		 if(s == null || p == null) return false;
		 return findIfMatch(0,0,s,p, new Boolean[s.length()+1][p.length()+1]);
		 // dp
		 
	 }
	 private boolean findIfMatch(int idxS, int idxP, String s, String p,Boolean[][] mem) {
		 if(idxP == p.length()) return idxS == s.length();
		 if(mem[idxS][idxP] !=null) return mem[idxS][idxP];
		 if(idxP == p.length() - 1 || p.charAt(idxP + 1) !='*') {
			 if(idxS < s.length() && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))) {
				 if(findIfMatch(idxS + 1, idxP + 1, s, p,mem)) {
					 mem[idxS][idxP] = true;
					 return true;
				 }
			 }
			 else {
				 mem[idxS][idxP] = false;
				 return false;
			 }
			 
		 }
		 else{
			 int i = idxS -1;
			 while(i < s.length()  && (i < idxS || p.charAt(idxP) == '.' || s.charAt(i) == p.charAt(idxP))) {
				 if(findIfMatch(i+1,idxP + 2, s, p,mem)){
					 mem[idxS][idxP] = true;
					 return true;
				 }
				 i++;
			 }
		 }
		 mem[idxS][idxP] = false;
		 return false;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode10RegularExpressionMatching test = new LeetCode10RegularExpressionMatching();
		System.out.println(test.isMatch("ab", ".*c"));
	}

}
