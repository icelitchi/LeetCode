package LeetCode;


//双指针思想，尾指针不断往后扫，当扫到有一个窗口包含了所有T的字符，然后再收缩头指针，直到不能再收缩为止。最后记录所有可能的情况中窗口最小的
public class MinimumWindowSubstring {

	public static void main(String[] args) {

	}
    public String minWindow(String S, String T) {
    	int[] count1=new int[256];
    	int[] count2=new int[256];
    	int minlength=Integer.MAX_VALUE;
    	int minstart=0;
    	int count=T.length();
    	for(int i=0;i<T.length();i++){
    		count1[T.charAt(i)]++;
    		count2[T.charAt(i)]++;
    	}
    	//双指针
    	int start=0;

    	for(int end=0;end<S.length();end++){
    		if(count2[S.charAt(end)]>0){
    			count1[S.charAt(end)]--;
    			if(count1[S.charAt(end)]>=0)
    				count--;
    		}
    		
    		if(count==0){
    			while(true){
    				if(count2[S.charAt(start)]>0){
    					if(count1[S.charAt(start)]<0){
    						count1[S.charAt(start)]++;
    					}else
    						break;
    						
    				}
    				start++;
    			}
    			if(	end-start+1<minlength){ //要记录minstart,因为start可能继续往后移，但是不一定是最短的
    				minlength=end-start+1;
    				minstart=start;
    			}
    		
    		}
    	}
    	if(count==0)
    		return S.substring(minstart, minstart+minlength);
    	else
    		return "";

        
    }


}
