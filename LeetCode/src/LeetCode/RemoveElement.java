package LeetCode;

public class RemoveElement {

	
	public static void main(String[] args) {

	}
    public int removeElement(int[] A, int elem) {
     int[] B=new int[A.length];
     int num=0;
     for(int i=0;i<A.length;i++){
    	 if(A[i]!=elem){
    		 B[num]=A[i];
    		 num++;
    		
    	 }
     }
     for(int i=0;i<num;i++){
    	A[i]=B[i];
     }
     return num;
    }
}
