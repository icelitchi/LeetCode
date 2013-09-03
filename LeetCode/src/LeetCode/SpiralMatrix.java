package LeetCode;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix test=new SpiralMatrix();
		int[][] m={{1,2}};
		test.spiralOrder(m);

	}
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    
  
    	 ArrayList<Integer> list=new  ArrayList<Integer> ();
    	 if(matrix==null||matrix.length==0)
    		 return list;
    	  	int n=matrix.length;
    	  	int m=matrix[0].length;
    	  	int left=m-1;
    	  	int down=n-1;
    	  	int up=1;
    	  	int right=0;
         int direction=0;
         int i=0,j=0;
         for(int k=0;k<n*m;k++){
         	list.add(matrix[i][j]);
         	switch(direction){
         	case 0://left
         		if(j==left){
         			direction=(direction+1)%4;
         			left--;
         			i++;
         		}else{
         			j++;
         		}
         		break;
         	case 1://down
         		if(i==down){
         			direction=(direction+1)%4;
         			down--;
         			j--;
         		}else{
         			i++;
         		}
         		break;
         	case 2://right
         		if(j==right){
         			direction=(direction+1)%4;
         			right++;
         			i--;
         		}else{
         			j--;
         		}
         		break;
         	case 3://up
         		if(i==up){
         			direction=(direction+1)%4;
         			up++;
         			j++;
         		}else{
         			i--;
         		}
         		break;
         	}
         }
    	 return list;
        
    }

}
