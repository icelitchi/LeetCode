package LeetCodeDone;

import java.math.BigInteger;
import java.util.ArrayList;


public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    
        ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>> ();
        if(numRows==0)
        return triangle;
    	ArrayList<Integer> up=new ArrayList<Integer>();
    	up.add(1);
    	triangle.add(up);
    	for(int i=1;i<numRows;i++){
        	ArrayList<Integer> row=new ArrayList<Integer>();
    		for(int j=0;j<=i;j++){
    			if(j==0||j==i)
    				row.add(j,1);
    			else
    				row.add(j,up.get(j-1)+up.get(j));
    			
    		}
    	
    		triangle.add(row);
    		up=row;
    	}
    	return triangle;
        
        
    }
	//time cost n2 慢
    public ArrayList<Integer> getRow(int rowIndex) {

    	ArrayList<Integer> up=new ArrayList<Integer>();
    	ArrayList<Integer> row=new ArrayList<Integer>();
    	up.add(1);
    	for(int i=1;i<=rowIndex;i++){
    		for(int j=0;j<=rowIndex;j++){
    			if(j==0||j==rowIndex)
    				row.add(j,1);
    			else
    				row.add(j,up.get(j-1)+up.get(j));
    			
    		}
    		up.clear();
    		up.addAll(row);
    		row.clear();
    	}
        return up;
        
    }
  //�?�辉三角
  //用组�?�数C(n,m)计算 第n行第m个数
    public ArrayList<Integer> getRow2(int rowIndex) {

    	ArrayList<Integer> row=new ArrayList<Integer>();

    	row.add(1);
    	for(int i=1;i<=rowIndex;i++){
    		if(i>rowIndex/2)
    			row.add(i,row.get(rowIndex-i));
    		else{
    			//会溢出
    			 // Integer temp=row.get(i-1)*(rowIndex-i+1)/i;
    			  BigInteger temp= BigInteger.valueOf(row.get(i-1));
    			  temp= temp.multiply(BigInteger.valueOf(rowIndex-i+1));
    			  temp=temp.divide(BigInteger.valueOf(i));
    			Integer num=Integer.parseInt(temp.toString());
    			row.add(i,num);
    		}
    	
    	}
        return row;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
