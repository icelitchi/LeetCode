package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

//递归
//非递归 
//运行时间差不多
public class NQueens {
	
	//递归
	public ArrayList<String[]> solveNQueens(int n) {
	    if(n <= 0) return null;
	    int[] queens = new int[n];
	    return solve(n, queens, 0);
	}
	public ArrayList<String[]> solve(int n, int[] q, int index){
	    ArrayList<String[]> rl = new ArrayList<String[]>();
	    if(index == n){
	        rl.add(new String[n]);
	        return rl;
	    }
	   outer:for(int i = 0; i < n; i++){
	        for(int k = 0; k < index; k++)
	            if(q[k] == i || Math.abs(q[k] - i) == index - k) continue outer;
	        q[index] = i;
	        for(String[] x : solve(n, q, index + 1)){
	            x[index] = "";
	            for(int j = 0; j < n; j++) x[index] += (j == i) ? "Q" : ".";
	            rl.add(x);
	        }
	    }
	    return rl;
	}
	//非递归版本 
	public ArrayList<String[]> _solveNQueens(int n) {
	    int[] q = new int[n];
	    ArrayList<String[]> rl = new ArrayList<String[]>();
	    for(int i = 0; i < n; i++) q[i] = -1;   
	    int i = 0;
	    while(true){                                  
	outer:  while(i < n){                        //put queen at column i 
	inner:      for(int m = q[i] + 1; m < n; m++){                   
	                for(int k = 0; k < i; k++)
	                    if(q[k] == m || Math.abs(q[k] - m) == i - k)  continue inner;
	                q[i++] = m;                  //m is good for now
	                continue outer;              //go for column i+1, put the next queen
	            }                                       
	            if(i == 0) return rl;                                  
	            q[i--] = -1;                     //m == n, go back to modify old queens 
	        }
	        String[] tmp = new String[n];        //i == n, find a solution
	        for(int y = 0; y < n; y++){
	            tmp[y] = "";
	            for(int z = 0; z < n; z++) tmp[y] += (q[y] == z) ? "Q" : ".";
	        }
	        rl.add(tmp);
	        i = n - 1;                           // go find the next solution
	    }
	}

}
