package LeetCode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String[] subpaths=path.split("/");
    	Stack<String> s=new Stack<String>();
    	for(int i=0;i<subpaths.length;i++){
    		
    		if(subpaths[i].equals(".")||subpaths[i].equals("")){
    			continue;
    		}else if(subpaths[i].equals("..")){
    			s.pop();
    		}else{
    			s.push(subpaths[i]);
    		}
    	}
    	StringBuffer sb=new StringBuffer();
    	while(!s.empty()){
    		sb.insert(0, s.pop());
    		sb.insert(0, "/");
    	}
    	return sb.toString();
        
    }
    
	public static void main(String[] args) {
		String path="/a/b/./../../c/";
		String sp=new SimplifyPath().simplifyPath(path);

			System.out.println(sp);

	}
}
