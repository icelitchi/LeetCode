package LeetCode;

public class CountandSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountandSay test=new CountandSay();
		test.countAndSay(4);

	}
    public String countAndSay(int n) {
    	String say="1";
    	for(int i=1;i<n;i++){
    		say=conserveSay(say);
    	}
    	return say;
        
    }
   String conserveSay(String say){
	   String s="";
	   
	   for(int i=0;i<say.length();){
		   char c=say.charAt(i);
		   int count=0;
		 //注意 i 已经 不是当前的了 所以for 中 不用
		   while(i<say.length()&&say.charAt(i)==c){
			   count++;
			   i++;
		   }
		   s+=count;
		   s+=c;
		   
	   }
	   return s;
   }

}
