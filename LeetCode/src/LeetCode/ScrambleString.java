package LeetCode;

//http://www.blogjava.net/sandy/archive/2013/05/22/399605.html

//三维动态规划！！！帅
public class ScrambleString {
	public static void main(String[] args){
		ScrambleString test=new ScrambleString();
		System.out.println(test.isScramble("aa", "ab"));
	}
	//递归
    boolean isScrambleR(String s1, String s2) {
     
        return false;
    }
    
    
    //动态规划实现
    
    boolean isScramble(String s1, String s2) {
    	if(s1==null&&s2==null)
    		return true;
    	else if(s1==null||s2==null)
    		return false;
    	
    	
        int length=s1.length();
        int l2=s2.length();
        if(length!=l2)
        	return false;
        //mark[k][i][j]:s1中i开始，s2中j开始，长度为k的string是否可以相互转换
        boolean[][][] mark=new boolean[length+1][length][length];
        for(int i=0;i<length;i++){
        	for(int j=0;j<length;j++){
        		mark[1][i][j]=(s1.charAt(i)==s2.charAt(j));
        	}
        }
        for(int k=2;k<length+1;k++){
        	for(int i=0;i<=s1.length()-k;i++){//!!!!注意范围，不然下面要溢出
        		for(int j=0;j<=s2.length()-k;j++){
        			boolean flag=false;
        			for(int x=1;x<k&&!flag;x++){
        				if((mark[x][i][j]&&mark[k-x][i+x][j+x])||(mark[x][i][j+k-x])&&mark[k-x][i+x][j])
        					flag=true;
        			}
        			mark[k][i][j]=flag;
        		}
        	}
        }
        
        return mark[length][0][0];
    }
    
    
}
