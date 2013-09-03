package LeetCode;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
	}
    public ArrayList<String> letterCombinations(String digits) {

    	 ArrayList<String> words=new  ArrayList<String> ();
    	 if(digits!=null&&digits.length()>0)
    		letterCombinations(0,new char[digits.length()],digits,words);
    	 else  if(digits!=null&&digits.length()==0){
    		 words.add("");
    	 }
    	 return words;
    }
    
    void letterCombinations(int i,char[] word,String digits,ArrayList<String> words){
    	if(i==word.length){
    		words.add(new String(word));
    		return;
    	}
    	char digit=digits.charAt(i);
    	switch(digit){
    	case '0':
    		word[i]=' ';
    		letterCombinations(i+1,word,digits,words);
    		break;
    		
    	case '1':
    		word[i]='1';
    		letterCombinations(i+1,word,digits,words);
    		break;
    		
    	case '2':
    		word[i]='a';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='b';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='c';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '3':
    		word[i]='d';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='e';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='f';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '4':
    		word[i]='g';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='h';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='i';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '5':
    		word[i]='j';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='k';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='l';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '6':
    		word[i]='m';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='n';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='o';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '7':
    		word[i]='p';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='q';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='r';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='s';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '8':
    		word[i]='t';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='u';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='v';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	case '9':
    		word[i]='w';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='x';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='y';
    		letterCombinations(i+1,word,digits,words);
    		word[i]='z';
    		letterCombinations(i+1,word,digits,words);
    		break;
    	}
    }

}
