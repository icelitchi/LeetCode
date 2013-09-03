package LeetCode;

import java.util.ArrayList;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	int i=0;
    
    	ArrayList<Interval> result=new ArrayList<Interval>();
    	boolean added=false;
 
    	while(i<intervals.size()){
    		Interval x=intervals.get(i);
    		 if(newInterval.end<x.start){
    			result.add(newInterval);
    			while(i<intervals.size()){
    				result.add(intervals.get(i));	
    				i++;
    			}
    			added=true;
    		 }else if(newInterval.start<=x.end){
    			
    			while(i<intervals.size()&&intervals.get(i).start<=newInterval.end){
    				i++;
    			}
    			x.end=intervals.get(i-1).end>newInterval.end?intervals.get(i-1).end:newInterval.end;
    			x.start=x.start<newInterval.start?x.start:newInterval.start;
    			result.add(x);
    			
    			while(i<intervals.size()){
    				result.add(intervals.get(i));	
    				i++;
    			}
    			added=true;
    		}else{
    			result.add(x);
    			i++;
    		}
    	}
    	if(!added){
    		result.add(newInterval);
    	}
        return result;
    }

}
