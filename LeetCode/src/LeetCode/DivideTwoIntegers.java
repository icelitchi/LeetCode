package LeetCode;
//直接用除数去一个一个加，直到被除数被超过的话，会超时。

//解决办法每次将被除数增加1倍，同时将count也增加一倍，如果超过了被除数，那么用被除数减去当前和再继续本操作。
//记得最大的int： 2147483647
public class DivideTwoIntegers {
	   public int divide(int dividend, int divisor) {

		 if(dividend==0||divisor==0)
			 return 0;
		 boolean neg=false;
		 long m=dividend;
		 long n=divisor;
		 if(m>0&&n<0||m<0&&n>0)
			 neg=true;
		 int result=0;
		 
		 long a=m>0?m:-m;//！！！！！ int 为负数时最小为-2147483648 变正就溢出了，所以要先转换为long
		 long b=n>0?n:-n;
		 if(a<b)
			 return 0;
		 while(a>=b){
			 int count=1;
			 long sum=b;
			 while(sum+sum<a){
				 sum+=sum;
				 count+=count;
			 }
			 a=a-sum;
			 result+=count;
		 }
		 if(neg)
			 return 0-result;
		 else
			 return result;
	        
	    }
}
