package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringConcatenationAllWords {

	public static void main(String[] args) {

		// String S="barfoothefoobarman";
		// String[] L= {"foo","bar"};
		 String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		 String[] L = { "fooo", "barr", "wing", "ding", "wing" };
		//"abababab", ["a","b","a"]
		//"abababab", ["ab","ba"]
		//String S="abababab";
		//String[] L= {"ab","ba"};
		SubstringConcatenationAllWords test = new SubstringConcatenationAllWords();
		test._findSubstring(S, L);
	}



	//优化  移动窗口:思想有点类似 min window substring
	//804ms过大数据！！！

		public ArrayList<Integer> findSubstring(String S, String[] L) {
			ArrayList<Integer> res = new ArrayList<Integer>();

			int wordlength = L[0].length();
			int m=S.length();
			int n=L.length;
			
			
			Map<String, Integer> map = new HashMap<String, Integer>();//单词-index
			ArrayList<Integer> needs=new ArrayList<Integer>();//index-个数
			ArrayList<String> words=new ArrayList<String>();//index-单词(同的单词)
			int index=0;//不同的单词个数
			for(int i=0;i<n;i++){
				if(map.get(L[i])==null){
					map.put(L[i], index);
					needs.add(index, 1);
					words.add(index, L[i]);
					index++;
				}else{
					needs.set(map.get(L[i]), needs.get(map.get(L[i]))+1);
				}
			}
			int[] sp=new int[m-wordlength+1] ;//sp[k]：S中k开始的字串-index
			for(int i=0;i<m-wordlength+1;i++){
				String sub=S.substring(i,i+wordlength);
				if(map.get(sub)!=null){
					sp[i]=map.get(sub);
				}else{
					sp[i]=-1;
				}
			}
		
			for(int k=0;k<wordlength;k++){
				int[] founds=new int[needs.size()];
				int count=0;
				for (int i = k; i <m - wordlength + 1; i+=wordlength) {
					int j=sp[i];	
						if(j>-1){//
							if(founds[j]==needs.get(j))
							{
								//移动窗口！！！！
								int start=i-wordlength*count;
								while(sp[start]!=sp[i]){
									founds[sp[start]]--;
									count--;
									start+=wordlength;
								}
								founds[j]--;
								count--;
							}
								founds[j]++;
								count++;
								if(count==n){
									res.add(i-wordlength*(n-1));

								}
							
						
						}else{
							founds=new int[needs.size()];
							count=0;
						}
			
			}
		}
			return res;
		}
		
		
		
		
		
		
		// 暴力解法//大数据测试超时
		public ArrayList<Integer>  _findSubstring(String S, String[] L) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			// boolean[] c=new boolean[L.length];
			int wordlength = L[0].length();

			Map<String, Boolean> map = new HashMap<String, Boolean>();
			for (int i = 0; i < S.length() - L.length * wordlength + 1; i++) {

				if (res.contains(new Integer(i - wordlength))) {
					if (S.substring(i - wordlength, i).equals(
							S.substring(i + L.length * wordlength-wordlength, i + L.length * wordlength))) {
						res.add(i);
					}
				} else if (isValid(S.substring(i, i + L.length * wordlength), L)) {

					res.add(i);
				}

			}

			return res;
		}

	boolean isValid(String sub, String[] L) {
		int count = 0;
		int wordlength = L[0].length();
		// L中的元素有重复
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			Integer n = map.get(L[i]);
			if (null == n) {
				map.put(L[i], 1);
			} else {
				map.put(L[i], 1 + n);
			}
		}
		for (int i = 0; i < sub.length(); i += wordlength) {
			Integer b = map.get(sub.substring(i, i + wordlength));
			if (b == null || b == 0)
				return false;
			else {
				map.put(sub.substring(i, i + wordlength), b - 1);
				count++;
			}
		}
		return count == L.length;
	}

}
