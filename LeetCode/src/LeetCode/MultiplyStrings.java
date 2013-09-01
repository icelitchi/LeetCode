package LeetCode;

import java.math.BigInteger;

//除了这种 方法？？？？？
public class MultiplyStrings {

	public static void main(String[] args) {

	}
    public String multiply(String num1, String num2) {
  BigInteger a=new BigInteger(num1);
  BigInteger b=new BigInteger(num2);
  return a.multiply(b).toString();
        
    }
}
