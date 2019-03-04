package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        findAllIPs(0,new StringBuilder(), 0, s, res);
        return res;
    }
    private void findAllIPs(int index, StringBuilder ip, int part, String s, List<String> res) {
    	if(part == 4 && index == s.length()) {
    		res.add(ip.toString());
    		return;	
    	}
    	if(index > s.length() || part >= 4) {
    		return;
    	}
    	int len = ip.length();
    	for(int i = 1; i <= 3 ; i++) {
    		if(index + i > s.length()) break;
    		int curr = Integer.valueOf(s.substring(index, index + i));
    		
    		if(curr >= 0 && curr <=255) {
    			if(part == 3) {
    				ip.append(curr);	
    			}else {
    				ip.append(curr + ".");
    			}
    			findAllIPs(index + i, ip, part+1,s,res);
    			ip.setLength(len);
    		}
    		// val = 0 is invalid 
    		if(curr ==0) break;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode93RestoreIPAddresses test = new LeetCode93RestoreIPAddresses();
		String s = "010010";
		List<String> res = test.restoreIpAddresses(s);
		for(String str: res) {
			System.out.println(str);
		}
			
	}

}
