package LeetCode;


//KMP
//http://www.cppblog.com/oosky/archive/2006/07/06/9486.html
public class Implement_strStr {

	public static void main(String[] args) {
		Implement_strStr test=new Implement_strStr();
		test.strStr("a", "a");
	}
	//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
	//返回字串首次出现的位置
	//kmp算法
	public String strStr(String haystack, String needle) {
	      if(needle==null|| haystack==null)
	    	  return  haystack;
	      if(needle.length()==0)
	    	  return haystack;
	      if(needle.length()>haystack.length())
	    	  return null;

	    	  
		int[] next=new int[needle.length()];
		getNext(needle,next);
		int m=0,n=0;
		while(m<haystack.length()&&n<needle.length()){
			if(haystack.charAt(m)==needle.charAt(n)){
				m++;
				n++;
				if(n==needle.length()){
					return haystack.substring(m-n);
				}
			}else{
				if(next[n]==-1){
					m++;
					n=0;
				}else{
					n=next[n];
				}
			}
		}
		  return null;
	        
	    }
//	设在字符串S中查找模式串T，若S[m]!=T[n],那么，取T[n]的模式函数值next[n],
//			1.       next[n]=  -1 表示S[m]和T[0]间接比较过了，不相等，下一次比较 S[m+1] 和T[0]
//			2.       next[n]=0 表示比较过程中产生了不相等，下一次比较 S[m] 和T[0]。
//			3.       next[n]= k >0 但k<n, 表示,S[m]的前k个字符与T中的开始k个字符已经间接比较相等了，下一次比较S[m]和T[k]相等吗？
//			4.       其他值，不可能。
//next[n]=k,表示 n位置前的字串，和 0~k-1位置的字串一样,且 T[n]!=T[k]
	
	void getNext(String t,int[] next){
		int k=-1;
		int j=0;
		next[0]=-1;
		while(j<t.length()-1){
			if(k==-1||t.charAt(k)==t.charAt(j)){
				k++;
				j++;
				if(t.charAt(k)!=t.charAt(j))
					next[j]=k;
				else
					next[j]=next[k];
			}else{
				k=next[k];
			}
		}
	}

}
