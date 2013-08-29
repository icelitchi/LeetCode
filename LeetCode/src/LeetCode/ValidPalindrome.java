package LeetCode;

public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
	    	int low=0;
			int high=s.length()-1;
			String _s=s.toLowerCase();
			while(low<high){
				 low=getUpcharIndex(_s,low);
				 high=getDowncharIndex(_s,high);
				 if(low>=0&&_s.charAt(low)!=_s.charAt(high)){
					return false;
				 }
				 low++;
				 high--;
			}
			return true;
		}
		int getUpcharIndex(String s,int start){
			
			while(start<s.length()){
				char c=s.charAt(start);
				if(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9')
					return start;
				
						start++;}
			return -1;
		}
		int getDowncharIndex(String s,int end){
			
			while(end>=0){
				char c=s.charAt(end);
				if(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9')
					return end;
				
						end--;}
			return -1;
		}
	public static void main(String[] args){
		ValidPalindrome v=new ValidPalindrome();
		System.out.println(v.isPalindrome("a."));
		
	}
}
