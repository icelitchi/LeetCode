package LeetCodeDone;

public class PalindromeNumber {
	//不用额外空间
	//先反转 比较是否相等
    public boolean isPalindrome(int x) {
      	int result=0;
      	int original=x;
        while(x!=0){
      	 
      	  result=result*10+x%10;
      	  x=x/10;
        }
        return original==result;
    }
    
    public static void main(String[] args){
    	PalindromeNumber p=new PalindromeNumber();
    	System.out.print(p.reverseInt(-21));
    }
    public int  reverseInt(int x) {
    	int result=0;
      while(x!=0){
    	 
    	  result=result*10+x%10;
    	  x=x/10;
      }
      return result;
    }
    
}
