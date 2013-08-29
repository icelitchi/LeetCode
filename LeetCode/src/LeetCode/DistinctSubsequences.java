package LeetCode;
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(S==null)
			return 0;
		
		//掐头去尾，精简计算
		//让S的头尾合T一样
	     int start=S.indexOf(T.charAt(0));
	        int end=S.lastIndexOf(T.charAt(T.length()-1));
	        if(end<start||start<0)
	        return 0;
			S=S.substring(start,end+1);
	
		if(S.length()<T.length())
			return 0;
		//防止溢出
		long[][] subResult = new long[T.length()][S.length()];
		for (int i = 0; i < T.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				subResult[i][j] = 0;
			}
		}
		// 初始化第一行
		long tempNum = 0;
		for (int j = 0; j < S.length(); j++) {
			if (S.charAt(j) == T.charAt(0)) {
				subResult[0][j] = ++tempNum;
			} else {
				subResult[0][j] = tempNum;
			}
		}

		for (int i = 1; i < T.length(); i++) {
			char c = T.charAt(i);
			tempNum = 0;
			for (int j = 0; j < S.length(); j++) {
				if(subResult[i-1][j]==0)
					continue;
				
				if(c==S.charAt(j)){
					if(j==0||subResult[i-1][j-1]==0)
						continue;
					else{
						//注意c和前一个c是否相同
                        if(c==T.charAt(i-1)){
                        if(subResult[i-1][j]==subResult[i-1][j-1])
							tempNum=subResult[i-1][j];
						else if(subResult[i-1][j]>subResult[i-1][j-1]){
							tempNum+=subResult[i-1][j-1];
						}
    					
                        }
                        else{
                            tempNum+=subResult[i-1][j];
                        }
					}
				}
				subResult[i][j]=tempNum;	
			}

		}
		return (int)subResult[T.length()-1][S.length()-1];

	}
	public static void main(String[] args){
		DistinctSubsequences d=new DistinctSubsequences();
		String s="rmwmwwiwmwwwiaiwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzooz";
		                                                                  String t="rwmimatmhydhbujebqehjprarwfkoebcxxqfktayaaeheys";
		System.out.print(d.numDistinct(s, t));
	}
}
