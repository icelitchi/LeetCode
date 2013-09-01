package LeetCode;

import java.util.ArrayList;

//格雷码，有公式的！！！一种十进制数的编码方式
//以二进制为0值的格雷码为第零项，第一项改变最右边的位元，第二项改变右起第一个为1的位元的左边位元，第三、四项方法同第一、二项，如此反复，即可排列出n个位元的格雷码。

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> ret=new ArrayList<Integer> ();
    				//个数
    	          int size = 1 << n;
    	          
    	          //整数i对应的格雷码编码！！！！
    	           for(int i = 0; i < size; ++i)
    	               ret.add((i >> 1)^i);
    	           
    	           return ret;
    }
}
