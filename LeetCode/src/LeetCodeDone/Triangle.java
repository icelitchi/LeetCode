package LeetCodeDone;

import java.util.ArrayList;

public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (triangle == null || triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		int result = 0;
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> up = triangle.get(i - 1);
			ArrayList<Integer> bottom = triangle.get(i);
			for (int j = 0; j < bottom.size(); j++) {
				Integer num = bottom.get(j);
				int min;
				if (j == 0) {
					min = up.get(j);
				} else if (j == bottom.size() - 1) {
					min = up.get(j - 1);
				} else {
					min = up.get(j) < up.get(j - 1) ? up.get(j) : up.get(j - 1);
				}
				//!!!!!!!! �?会改�?�list中integer的值，�?手动改�?�
				num += min;
				bottom.set(j, num);

				if (i == triangle.size() - 1) {
					if (j == 0)
						result = num;
					else {
						result = result < num ? result : num;
					}
				}
			}
		}

		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Triangle t = new Triangle();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(-1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		System.out.print(t.minimumTotal(triangle));

	}

}
