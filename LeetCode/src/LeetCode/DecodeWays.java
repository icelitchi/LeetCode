package LeetCode;

public class DecodeWays {
	//动态规划
	   public int numDecodings(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		   if(s==null||s.length()==0)
			   return 0;
		   int[] ways=new int[s.length()+1];
		   ways[0]=1;
		   if(Integer.parseInt(s.substring(0, 1))>0)
			   ways[1]=1;
		   else
			   return 0;   
			for(int i=1;i<s.length();i++){
				   
				   char pre=s.charAt(i-1);
				   char current=s.charAt(i);
				   int x=Integer.parseInt(s.substring(i-1, i+1));
				   
				   if(pre=='0'){
					   if(current=='0')
						   return 0;
					   else
						   ways[i+1]=ways[i];
				   }else{
					   if(current=='0'){
						   if(x>26)
							   return 0;
						   else
							   ways[i+1]=ways[i-1];
					   }else if(x<27){
						   ways[i+1]=ways[i-1]+ways[i];
					   }else{
						   ways[i+1]=ways[i];
					   }
				   }
				
		
			   }
		  
		
	        return ways[s.length()];
	    }
	   public static void main(String[] args){
		   DecodeWays test=new DecodeWays();
		 System.out.println( test.numDecodings("110")) ;
	   }
}
