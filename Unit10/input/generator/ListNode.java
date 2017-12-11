/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 6, 2017 6:45:03 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

public class ListNode {
	
	public int value;
	public ListNode next;

	public ListNode()
	{
		value=0;
		next=null;
	}
	
	public ListNode(int x)
	{
		value=x;
		next=null;
	}
	
	public ListNode(int x, ListNode y)
	{
		value=x;
		next=y;
	}
	
	public int length()
	{
		if(next==null)
		{
			return 1;
		}
		else
		{
			return 1+next.length(); 
		}
	}
	
	public void print()
	{
		System.out.print(value);
		if(next!=null){
			System.out.print(" -> ");
			next.print();
		}
	}
}
