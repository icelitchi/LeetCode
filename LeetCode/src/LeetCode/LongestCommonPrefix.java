package LeetCode;

public class LongestCommonPrefix {

	public static void main(String[] args) {


	}
    public String longestCommonPrefix(String[] strs) {

    	if(strs==null||strs.length==0)
    		return "";
    	//提高效率，先找到最短的string的长度
    	int minlength=strs[0].length();
    	for(int j=1;j<strs.length;j++){
    		if(strs[j].length()<minlength)
    			minlength=strs[j].length();
    	}
    	int end=-1;
    	boolean endflag=false;
    	for(int i=0;i<minlength&&!endflag;i++){
    		//boolean sameflag=true;
    		char c=strs[0].charAt(i);
    		for(int j=1;j<strs.length;j++){
    			if(i>=strs[j].length()||c!=strs[j].charAt(i)){
    				
    				endflag=true;
    				break;
    			}
    		}
    		if(!endflag){
    			end=i;
    		}else{
    			break;
    		}
    	}
    	if(end>=0){
    		return strs[0].substring(0,end+1);
    	}else
    		return "";
        
    }

}
