package LeetCodeDone;

public class ZigZagConversion {

    public String convert(String s, int nRows) {
    	//::TODO
     
    	if(s==null)
    		return null;
    	char[] result=new char[s.length()];
    	int line=0;
    	int overlap=0;
    	int lineIndex=0;
    	if(nRows<=2)
    		overlap=nRows;
    	else if(nRows%2==1)
    		overlap=(nRows*nRows-1)/2;
    	else{
    		overlap=(nRows*nRows-4)/2;
    	}
    		
    	for(int i=0;i<s.length()&&line<nRows;i++){
    		int postion=0;
    		
    		if(postion>=s.length()){
    			line++;
    			lineIndex=0;
    		//	if(line>nRows/2)
    		}
    		
    		result[i]=s.charAt(postion);
    	}
    	
    	return new String(result);
    	
    }
}
