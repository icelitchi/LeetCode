package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {

	public static void main(String[] args) {
		Interval i=new Interval(1,3);
		ArrayList<Interval> list=new ArrayList<Interval>();
		list.add(i);
		MergeIntervals test=new MergeIntervals();
		test.merge(list);
	}
	//先按start 排序，
	//然后依次 merge
	  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		  ArrayList<Interval> result=new ArrayList<Interval>();
		  if(intervals==null||intervals.size()==0)
			  return result;
		  Collections.sort(intervals, new  java.util.Comparator<Interval>(){
			public int compare(Interval o1, Interval o2) {
				if(o1.start!=o2.start)
					return o1.start-o2.start;
				else 
					return o1.end-o2.end;
			}});
		  Interval x=intervals.get(0);
		  int i=1;
		while(i<intervals.size()){
			 Interval y=intervals.get(i);
			 if(y.start==x.start){
				 x=y;	 
			 }else if(y.start<=x.end){
				 if(y.end>x.end){
					 x.end=y.end;
				 }
			 }else{
				 result.add(x);
				 x=y;
			 }
			 i++;
		}
		result.add(x);
		  return result;
	        
	    }
	
}
 class Interval {
    int start;
    int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }