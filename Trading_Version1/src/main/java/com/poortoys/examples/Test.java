package com.poortoys.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test {
	int count=0;
	String s="welcomedsdsa";
	HashMap<Character,Integer> m=new HashMap<Character,Integer>();

	
	public Map<Character,Integer> m()
	{
	for(int i=0;i<s.length();i++)
	{
	char s1=s.charAt(i);	
	if(!m.containsKey(s1))
	{
     m.put(s1,i);
	}
	else
	{
	     count++;
	}
//System.out.println(count);
	}
	return m;
	}

public static void main(String args[])
{
	
	System.out.println(new Test().m());
}
}
