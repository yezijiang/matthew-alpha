package com.matthew.javabase.algorithm;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-15 17:44
 */
public class ArrayDequeTest {
	@Test
	public void cla(){
		int head =0;
		head = (head - 1) & (16- 1);
		System.out.println(head);
		head = (head - 1) & (16- 1);
		System.out.println(head);
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(15));
		StringBuffer number1 = new StringBuffer();

		String a ="111";
		int aint = 12;
		int bint =10;
		System.out.println(aint%10);
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode returnNode = new ListNode(0);
		int carry = 0;
		ListNode aNode=l1;
		ListNode bNode=l2;
		ListNode curr = returnNode;
		while(aNode != null || bNode != null ){
			int aval = aNode == null ? 0 : aNode.val;
			int bval = bNode == null ? 0 : bNode.val;
			int sumval = aval + bval + carry;
			carry = sumval/10;
			int resultVal = sumval % 10;
			curr.next =  new ListNode(resultVal);
			curr = curr.next;
			if (aNode != null) aNode = aNode.next;
			if (bNode != null) bNode = bNode.next;
		}
		if(carry>0){
			curr.next = new ListNode(carry);
		}

		return returnNode.next;

	}
	public void printNode(ListNode listNode){
		ListNode next  = listNode;
		while (next!=null){
			System.out.print(next.val);
			System.out.print("->");
			next = next.next;
		}
		System.out.println("");
	}
	@Test
	public void testCal(){
		//ListNode l1 = new ListNode(2).next = new ListNode(4).next=new ListNode(3);
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		printNode(l1);
		ListNode l2 =  new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		printNode(l2);
		ListNode lresult = addTwoNumbers(l1,l2);
		printNode(lresult);
	}
	@Test
	public void alEqual(){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		printNode(l1);
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x;}
}
