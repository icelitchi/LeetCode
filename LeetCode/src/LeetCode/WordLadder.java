package LeetCode;
import java.util.ArrayList;
import java.util.HashSet;

public class WordLadder {

	
	public ArrayList<ArrayList<String>> findLadders2(String start, String end,
			HashSet<String> dict) {
		return null;
	}
	
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {

		int waylength = laddersLength(start, end, dict);
		return findLadders(start, end, waylength, dict);
	}

	// DFS
	ArrayList<ArrayList<String>> findLadders(String start, String end,
			int length, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (length < 0)
			return result;
		if (start.equals(end)) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(end);
			result.add(temp);
			return result;
		}

		HashSet<String> neighbors = neighbors(dict, start);
		HashSet<String> newdict = new HashSet<String>(dict);
		newdict.remove(start);
		for (String neighbor : neighbors) {

			ArrayList<ArrayList<String>> subResult = findLadders(neighbor, end,
					length - 1, newdict);

			if (subResult.size() > 0)
				for (ArrayList<String> list : subResult) {
					list.add(0, start);
				}
			result.addAll(subResult);
		}
		if (result != null && result.size() > 0) {
			int l = Integer.MAX_VALUE;
			for (ArrayList<String> list : result) {
				if (list.size() < l)
					l = list.size();
			}

			// foreach 时不能修改list 不然会出并行错误
			for (int i = 0; i < result.size();) {
				if (result.get(i).size() > l) {
					result.remove(i);
				} else {
					i++;
				}
			}

		}

		return result;
	}

	// BFS
	int laddersLength(String start, String end, HashSet<String> dict) {
		int result = 0;

		HashSet<String> firstlevel = new HashSet<String>(neighbors(dict, start));
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> newDict = new HashSet<String>(dict);
		visited.add(start);
		while (firstlevel.size() > 0) {
			result++;
			HashSet<String> nextlevel = new HashSet<String>();
			for (String s : firstlevel) {
				if (s.equals(end))
					return result + 1;
				visited.add(s);
				newDict.remove(s);
				nextlevel.addAll(neighbors(newDict, s));
			}
			firstlevel.clear();
			for (String s : nextlevel) {
				if (!visited.contains(s))
					firstlevel.add(s);
			}

		}
		return 0;
	}

	HashSet<String> neighbors(HashSet<String> dict, String s) {
		HashSet<String> result = new HashSet<String>();
		for (String _s : dict) {
			if (isNeighbor(s, _s))
				result.add(_s);
		}
		return result;
	}

	boolean isNeighbor(String s1, String s2) {
		int differ = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				differ++;
			if (differ > 1)
				break;
		}
		return differ == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WordLadder f = new WordLadder();
		// , , []
		String start = "sand";
		String end = "acne";
		HashSet<String> dict = new HashSet<String>();
		String[] d = {};
		for (String s : d) {
			dict.add(s);
		}

		int l = f.laddersLength(start, end, dict);
		System.out.println(l);
	}

}