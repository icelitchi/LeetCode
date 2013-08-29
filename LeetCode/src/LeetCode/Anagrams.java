package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//
public class Anagrams {


	public static void main(String[] args) {
		String[] temp={"tea","and","ate","eat","den"};
		ArrayList<String> r=new Anagrams().anagrams(temp);
		for(int i=0;i<r.size();i++){
			System.out.println(r.get(i));
		}
	}
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result=new  ArrayList<String>();
		Map<String,Integer > map=new HashMap<String,Integer>();
		int length=strs.length;
		for(int i=0;i<length;i++){
			char[] ca=strs[i].toCharArray();
			Arrays.sort(ca);
			Integer l=map.get(String.valueOf(ca));
			if(l==null){
			
				map.put(String.valueOf(ca), i);
	
			}else{
				if(l!=-1){
					result.add(strs[l]);
					map.put(String.valueOf(ca), -1);
				}
					result.add(strs[i]);
			}
		
		}
		
	        return result;
	}
}
