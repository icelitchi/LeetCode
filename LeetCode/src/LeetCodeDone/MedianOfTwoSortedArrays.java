package LeetCodeDone;

public class MedianOfTwoSortedArrays {

	

	public double findMedianSortedArrays(int A[], int B[]) {
	
		int al = A.length;
		int bl = B.length;
		boolean adone = (al < 1);
		boolean bdone = (bl < 1);
		int aIndex=0;
		int bIndex=0;
		int last=0;
		int last2=0;
		for(int i=0;i<=(al+bl)/2;i++){
			int temp=0;
			if(!adone&&!bdone){
				temp=A[aIndex]<=B[bIndex]?A[aIndex++]:B[bIndex++];
				
			}else if(!adone){
				temp=A[aIndex++];
			}else {
				temp=B[bIndex++];
			}
			adone=aIndex>=al;
			bdone=bIndex>=bl;
			
			last2=last;
			last=temp;
		}
		if((al+bl)%2==0)
			return (last+last2)/2.0;
		else
			return last;
	
	}
}
