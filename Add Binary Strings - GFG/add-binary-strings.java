//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        return solve(A, B);
    }
    
    String solve(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        a = reverse(a);
        b = reverse(b);
        
        char carry = '0';
        int i = 0;
        for (i = 0; i < a.length() || i < b.length(); i++) {
        	char charA = (i < a.length()) ? a.charAt(i) : '0';
        	char charB = (i < b.length()) ? b.charAt(i) : '0';
        	
        	if (charA == charB) {
        		sb.append(carry);
        		carry = charA;
        	}
        	else {
        		char ch = (carry=='0') ? '1' : '0';
        		sb.append(ch);
        	}
        }
        
        if (carry == '1') {
        	sb.append(carry);
        }
        
        String ans = sb.reverse().toString();
        ans = remove(ans);
        return ans;
    }
    
    String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	String remove(String s) {
		int i = 0;
		while (i < s.length() && s.charAt(i)=='0') {
			i++;
		}
		
		return s.substring(i);
	}
}