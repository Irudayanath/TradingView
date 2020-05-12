package com.poortoys.examples;

import java.util.HashSet;

import org.testng.annotations.Test;

public class NewTest {
	public void m()
	{
		String s="pwwkew";
		int count=0;
		HashSet<Character> hs=new HashSet<Character>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			while(!hs.contains(c))
			{
				hs.add(c);
				count++;
			}
		}
		System.out.print(count);
	}
public static void main(String args[])
{
	
	new NewTest().m();
	
}
}
