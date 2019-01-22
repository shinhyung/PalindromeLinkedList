package Solution;

import java.io.*;
import java.util.*;

class Solution {
	public boolean isPalindrome(int x) {
	    
		int count=1;
		ArrayList<Integer> listone = new ArrayList<Integer>();
		ArrayList<Integer> listtwo = new ArrayList<Integer>();
		String token = Integer.toString(x);
		String[] tokenlist = token.split("");
		
		
		
		if(x<0) {
			return false;
		}
		if(x<=9) {
			return true;
		}
		
		else {
			
				for(int k=1;k<tokenlist.length;k++) {
					if(tokenlist[k].equals(tokenlist[k-1]))
					count++;
				}
				if(count==tokenlist.length) { //���ڰ� ���� ������ ���
					return true;
				}
				else{ //���ڰ� ���� �������� ���� ���
					count=0;
					for(int k=1;k<tokenlist.length-1;k++) {
						count++; 
					}
					if(tokenlist[0].equals(tokenlist[tokenlist.length-1])&&count==1) { // �� ���� ���ڴ� ���� ��� ���ڰ� �ϳ��� ���
						return true;
					}
					count=1;
					for(int k=1;k<tokenlist.length-1;k++) {
					if(k+1!=tokenlist.length&&tokenlist[k].equals(tokenlist[k+1])) {
							count++;
					}
					}
					if(tokenlist[0].equals(tokenlist[tokenlist.length-1])&&count==tokenlist.length-2) {
						//ù ��°�� ���� ���ڰ� �����ϸ鼭 �ȿ� ���ڰ� ���� ����
						return true;
					}
					else {
						for(int j=0;j<tokenlist.length/2;j++) {
							int sum = Integer.parseInt(tokenlist[j]);
							listone.add(sum);
						}
						for(int j=tokenlist.length-1;j>=tokenlist.length/2;j--) {
							int sum = Integer.parseInt(tokenlist[j]);
							listtwo.add(sum);
						}
						count=0;
						for(int j=0;j<listone.size();j++) {
							if(listone.get(j).equals(listtwo.get(j))) {
								count++;
							}
						}
						if(tokenlist[0].equals(tokenlist[tokenlist.length-1])&&count==listone.size()) {
							return true;
						}
						
						return false;
					}
				}
				
			}
		
	    
	}
	
}


	public class MainClass {
	    public static String booleanToString(boolean input) {
	        return input ? "True" : "False";
	    }
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String line;
	        while ((line = in.readLine()) != null) {
	            int x = Integer.parseInt(line);
	            
	            boolean ret = new Solution().isPalindrome(x);
	            
	            String out = booleanToString(ret);
	            
	            System.out.print(out);
	        }
	    }
	}