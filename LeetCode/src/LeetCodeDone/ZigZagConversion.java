package LeetCodeDone;

public class ZigZagConversion {
	public static void main(String[] args){
		ZigZagConversion test=new ZigZagConversion();
		
		String s="PAYPALISHIRING";
		test.convert(s, 3);
				
	}

	//坑爹:每次是指各一行，不是递减再递增,之字形
	//1    9    17
	//2 8 10 16 18
	//3 7 11 15
	//4 6 12 14
	//5   13
    public String convert(String s, int nRows) {
     
    	if(s==null)
    		return null;
    	if(nRows==1)
    		return s;
    	char[] result=new char[s.length()];
    	int steps=2*nRows-2;
    	int[] step=new int[2];
    	int size=0;
    	for(int i=0;i<nRows;i++){
    		
    		int num=nRows-(i+1)+nRows-(i+1);
    		step[0]=num;
    		if(step[0]==0)
    			step[0]=steps;
    		step[1]=steps-step[0];
    		if(step[1]==0)
    			step[1]=steps;
    		int j=i;
    		int index=0;
    		while(j<s.length()){
    			result[size++]=s.charAt(j);
    			j=j+step[index];
    			index=1-index;
    		}
    	}
 
    	return new String(result);
    	
    }
}
