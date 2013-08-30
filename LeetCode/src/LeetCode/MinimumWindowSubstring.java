package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

	}
	//TODO::
    public String minWindow(String S, String T) {
  
    	
    	//
    	boolean exist=false;
    	int meetnum=0;
    	//双指针
    	int start=-1;
    	int end=-1;
    	int[] latestIndex=new int[T.length()];

    	Map<Character,Integer> cmap=new HashMap<Character,Integer>();
    	for(int i=0;i<T.length();i++){
    		cmap.put(T.charAt(i), -1);
    	}
    	for(int i=0;i<S.length();i++){
    		char c=S.charAt(i);
    		Integer p=cmap.get(c);
    		if(p!=null){
    			if(p>-1){
    				if(exist){
    					
    					if(isFirst(c)){
    						int second=mapSecond();
    						if(i-second<end-start){
    							start
    						}
    						 
    					}
    				}
    			
    			}else{
    			
        				meetnum++;	
    			}
    			
    				
    			if(start==-1)
        			start=i;	
    			if(meetnum==cmap.size())
					exist=true;
    		}
    	
    	}
    	return S.substring(start, end+1);

        
    }
   boolean isFirst(char c){
    	return false;
    }
   int mapMin(){
	   return 0;
   }
   int mapSecond(){
	   return 0;
   }
   int mapMax(){
	   return 0;
   }

}
