package LeetCode;

public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a={1,1,2,1,1};
		JumpGameII test=new JumpGameII();
		test.jump(a);
	}
	//动态规划!!!这种动态规划   大数据 会超过 时间限制
	//要优化
	//http://www.cnblogs.com/remlostime/archive/2012/11/25/2787916.html
//    public int jump(int[] A) {
//    int[] steps=new int[A.length];
//    //-1表示不可达
//    steps[0]=0;
//    for(int i=1;i<A.length;i++){
//    	int tempstep=Integer.MAX_VALUE;
//    	for(int j=0;j<i;j++){
//    		if(A[j]>=i-j&&steps[j]>=0&&tempstep>steps[j]+1){
//    			tempstep=steps[j]+1;
//    		}
//    	}
//    	if(tempstep==Integer.MAX_VALUE)
//    		steps[i]=-1;
//    	else
//    		steps[i]=tempstep;
//    			
//    }
//        return steps[A.length-1] ;
//    }
	public int jump(int[] A) {
		int[] steps=new int[A.length];
		int maxPosition=0;
		steps[0]=0;
		for(int i=0;i<=maxPosition;i++){
			int pos=i+A[i];
			if(pos>=A.length){
				pos=A.length-1;
			}
			if(pos>maxPosition){
				for(int j=maxPosition+1;j<=pos;j++){
					steps[j]=steps[i]+1;
				}
				maxPosition=pos;
			}
			if(maxPosition==A.length-1)
				return steps[A.length-1];	
			
		}
		
		return -1;
	}
}
