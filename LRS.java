package com.amazon;
import java.util.*;

public class LRS {
	public static void main(String[] args){
		String str = "aba";
		SuffixNode root = new SuffixNode('$');
		for(int i = 0; i < str.length(); i ++){
			String s = str.substring(i);
			insertInSuffixTree(root, s, i, s, 0);
		}
		System.out.println (maxStr);
	}
	static int maxLen = 0;
	static String maxStr =  "";
	 
	public  static void insertInSuffixTree(SuffixNode root, String str, int index, String ori, int level){
		 
		root.indexes.add(index);
		
		if(root.indexes.size() > 1 && maxLen < level){
			maxLen = level;
			maxStr = ori.substring(0, level);
		}
		
		if(str.length() == 0){
			return;
		}
		SuffixNode child;
		if(!root.children.containsKey(str.charAt(0))){
			child = new SuffixNode(str.charAt(0));
			root.children.put(str.charAt(0), child);
		} else{
			child = root.children.get(str.charAt(0));
		}
		
		insertInSuffixTree(child, str.substring(1), index, ori, level + 1);
	}
}

class SuffixNode{
	char c;
	Map<Character, SuffixNode> children = new HashMap<>();
	List<Integer> indexes = new ArrayList<>();
	SuffixNode(char c){
		this.c = c;
	}
}