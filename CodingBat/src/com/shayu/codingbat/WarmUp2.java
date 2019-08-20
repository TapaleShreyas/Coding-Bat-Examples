package com.shayu.codingbat;

public class WarmUp2 {

	public void main(String[] args) {
		WarmUp2 obj = new WarmUp2();
		obj.stringMatch("xxcaazz", "xxbaaz");
	}
	
	
	/***
	 * 
		Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. 
		So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
		
		stringMatch("xxcaazz", "xxbaaz") → 3
		stringMatch("abc", "abc") → 2
		stringMatch("abc", "axc") → 0
	 */
	public int stringMatch(String a, String b) {
		int matchCount = 0;
		int length = Math.min(a.length(), b.length());
		for(int i = 0; i < length - 1 ; i++)
			if(a.substring(i, i+2).equals(b.substring(i, i+2)))
				matchCount++;
		return matchCount;
	}
	
	
	
	/***
	 * 
		Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
		
		array123([1, 1, 2, 3, 1]) → true
		array123([1, 1, 2, 4, 1]) → false
		array123([1, 1, 2, 1, 2, 3]) → true
	 */
	public boolean array123(int[] nums) {
		for(int i = 0; i < nums.length-2 ; i++)
			if(nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3)
				return true;
		return false;
	}
	
	
	
	/***
	 * 
		Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
		
		arrayFront9([1, 2, 9, 3, 4]) → true
		arrayFront9([1, 2, 3, 4, 9]) → false
		arrayFront9([1, 2, 3, 4, 5]) → false
	 */
	public boolean arrayFront9(int[] nums) {
		int length = nums.length;
		if(length > 4) length = 4; 
	    for(int i = 0; i < length; i++)
	    	if(9 == nums[i])
	    		return true;
	    return false;
	}
	
	
	
	
	/***
	 * 
		Given an array of ints, return the number of 9's in the array.
		
		arrayCount9([1, 2, 9]) → 1
		arrayCount9([1, 9, 9]) → 2
		arrayCount9([1, 9, 9, 3, 9]) → 3
	 */
	public int arrayCount9(int[] nums) {
		int count = 0;
		for(int i=0; i<nums.length; i++)
			if(9 == nums[i])
				count++;
		return count;		
	}
	
	
	
	
	
	/***
	 * 
		Given a string, return the count of the number of times that a substring length 2 appears in the string and 
		also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
		
		last2("hixxhi") → 1
		last2("xaxxaxaxx") → 1
		last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		if (str.length() <= 2) return 0;
		String subString = str.substring(str.length()-2);
		int count=0;
		for(int i=0; i<str.length()-2; i++)
			if(subString.equals(str.substring(i, i+2)))
				count++;
		return count;
	}
	
	
	
	
	
	/***
	 * 
		Given a non-empty string like "Code" return a string like "CCoCodCode".
		
		stringSplosion("Code") → "CCoCodCode"
		stringSplosion("abc") → "aababc"
		stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		StringBuilder finalString = new StringBuilder();
		for(int i=0; i<str.length(); i=i+1)
			finalString.append(str.substring(0, i+1));
		return finalString.toString();
	}
	
	
	
	
	/***
	 * 
		Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
		
		stringBits("Hello") → "Hlo"
		stringBits("Hi") → "H"
		stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		StringBuilder finalString = new StringBuilder();
		for(int i=0;i<str.length();i=i+2)
			finalString .append(str.charAt(i));
		return finalString.toString();
	}
	
	
	
	/***
	 * 
		Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
		
		doubleX("axxbb") → true
		doubleX("axaxax") → false
		doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
	    int index = str.indexOf("x");
		  return index!=-1 && str.substring(index).startsWith("xx");
	}
	
	
	
	/***
	 * 
		Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or 
		whatever is there if the string is less than length 3. Return n copies of the front;
		
		frontTimes("Chocolate", 2) → "ChoCho"
		frontTimes("Chocolate", 3) → "ChoChoCho"
		frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	 public String frontTimes(String str, int n) {
		 str = str.length() <= 3 ? str : str.substring(0, 3);
		 StringBuilder finalString = new StringBuilder();
		 for(int i=1; i<=n; i++)
				finalString.append(str);
		 return finalString.toString();
	}

	
	
	/**
	 * 
		Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.
		
		stringX("xxHxix") → "xHix"
		stringX("abxxxcd") → "abcd"
		stringX("xabxxxcdx") → "xabcdx"*
		
	 * @param str
	 * @return
	 */
	public String stringX(String str) {
		if(str.length() <=2)
			return str;
		
		StringBuilder finalString = new StringBuilder() ;
		finalString.append(str.charAt(0));
		finalString.append(str.substring(1, str.length()-1).replaceAll("x", ""));
		finalString.append(str.charAt(str.length()-1));
		return finalString.toString();  
	}
	
	
	
	
	
	/***
	 * 
		Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
		
		altPairs("kitten") → "kien"
		altPairs("Chocolate") → "Chole"
		altPairs("CodingHorror") → "Congrr"
	 * @param str
	 * @return
	 */
	public String altPairs(String str) {
		StringBuilder finalString = new StringBuilder();
		int length = str.length(); // 9
		for(int i=0; i< length; i= i+4) {
			if(i+2 <= length)
				finalString.append(str.charAt(i)).append(str.charAt(i+1));	
			else if(i+1 <= length)
				finalString.append(str.charAt(i));
			else if(length <= 2)
				return str;
		}
		return finalString.toString();
	}
	
	
	
	
	
	
	/***
	 * 
		Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, 
		but the "a" can be any char. The "yak" strings will not overlap.
		
		stringYak("yakpak") → "pak"
		stringYak("pakyak") → "pak"
		stringYak("yak123ya") → "123ya"
	 * @param str
	 * @return
	 */
	public String stringYak(String str) {
	  return str.replaceAll("yak", "");
	}
	
	
	
	
	
	/***
	 * 
		Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
		
		countXX("abcxx") → 1
		countXX("xxx") → 2
		countXX("xxxx") → 3
	 * @param str
	 * @return
	 */
	public int countXX(String str) {
		int count = 0;
		for(int i=0; i< str.length(); i++){
			if(i+1 < str.length())
			    if(str.charAt(i)==str.charAt(i+1) && str.charAt(i)=='x')
			      count++;
		}
	  return count;
	}
	
	
	
	
	/***
	 * 
		Given a string and a non-negative int n, return a larger string that is n copies of the original string.
		
		stringTimes("Hi", 2) → "HiHi"
		stringTimes("Hi", 3) → "HiHiHi"
		stringTimes("Hi", 1) → "Hi"
	 * @param str
	 * @param n
	 * @return
	 */
	public String stringTimes(String str, int n) {
		StringBuilder finalString = new StringBuilder();
		for(int i=1; i<=n;i++) 
			finalString.append(str);
		return finalString.toString();
	}
	
	
	
	
	/***
	 * 
		Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed by the value plus 5, 
		followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
		
		has271([1, 2, 7, 1]) → true
		has271([1, 2, 8, 1]) → false
		has271([2, 7, 1]) → true
		has271([2,7,12,6]) → true
		
	 * @param nums
	 * @return
	 */
	public boolean has271(int[] nums) {
		for(int i=0; i < nums.length -2; i++) 
			if(nums[i]+5 == nums[i+1] && (nums[i]-1 == nums[i+2] ||  Math.abs(nums[i+2] - (nums[i]-1)) <=2))
				return true;
		return false;
	}
	
	
	
	
	
	/***
	 * 
		Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. 
		Return true if the array does not contain any triples.
		
		noTriples([1, 1, 2, 2, 1]) → true
		noTriples([1, 1, 2, 2, 2, 1]) → false
		noTriples([1, 1, 1, 2, 2, 2, 1]) → false
	 * @param args
	 */
	public boolean noTriples(int[] nums) {
		 for(int i=0; i< nums.length-2; i++)
			 if(nums[i] == nums[i+1] && nums[i] == nums[i+2])
				 return false;
		return true;
	}
	
	
	
	
	
	/***
	 * 
		Given an array of ints, return the number of times that two 6's are next to each other in the array. 
		Also count instances where the second "6" is actually a 7.
		
		array667([6, 6, 2]) → 1
		array667([6, 6, 2, 6]) → 1
		array667([6, 7, 2, 6]) → 1
	 * @param args
	 */
	public int array667(int[] nums) {
		int count = 0;
		for(int i=0; i< nums.length-1; i++)
			if(nums[i] == 6 && (nums[i+1] ==6 || nums[i+1] ==7))
				count++;
		return count; 
	}
	
}
