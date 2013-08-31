package LeetCode;

public class MergeSortedArray {
	public void merge(int[]A,int m,int[] B,int n){
		int[] C=new int[m+n];
		int pa=0;
		int pb=0;
		int pc=0;
		while(pa<m||pb<n){
			int value;

			if(pa<m&&pb<n){
				if(A[pa]<=B[pb]){
					value=A[pa];
					pa++;
				}else{
					value=B[pb];
					pb++;
				}
			}else if(pa<m){
				value=A[pa];
				pa++;
				
			}else{
				value=B[pb];
				pb++;
			}
			C[pc]=value;
			pc++;
		}
		for(int i=0;i<m+n;i++){
			A[i]=C[i];
		}
	}

}
