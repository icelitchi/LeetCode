package LeetCode;

public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//动态规划
    public int jump(int[] A) {
    int[] steps=new int[A.length];
    //-1表示不可达
    steps[0]=0;
    for(int i=1;i<A.length;i++){
    	int tempstep=Integer.MAX_VALUE;
    	for(int j=0;j<i;j++){
    		if(A[j]>=i-j&&A[j]>=0&&tempstep>A[j]+1){
    			tempstep=steps[j]+1;
    		}
    	}
    	if(tempstep==Integer.MAX_VALUE)
    		steps[i]=-1;
    	else
    		steps[i]=tempstep;
    			
    }
        return steps[A.length-1] ;
    }

}
