import java.util.NoSuchElementException;

public class CircularLinkedList {
	private ListNode head;
	private int length;
	
	private class ListNode {
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularLinkedList() {
		head = null;
		length = 0;
	}
	//check CLL length
	public int length() {
		return length;
	}
	//to check is CLL is empty
	public boolean isEmpty() {
		return length == 0;
	}
	
//insert the node the back of the list
	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		if(head == null) {
			head = temp;
			head.next = head;
		} else {
			temp.next = head.next;
			head.next = temp;
			head = temp;
		}
		length++;
	}


//ddG moves forward 3 nodes in the list and removes every 3rd node 
//Duck Duck goose 
public int ddG()
{
  ListNode temp = head.next;

  int i = length;
  while(i != 1)
  {
    //move forward 2 times and then point the node to the one after goose
    temp.next.next = temp.next.next.next;
    //move temp to the node after the goose
    temp = temp.next.next;
    //decrease the counter for the length of the list
    i--;
  }
  //return the last number in the list
return temp.data;
}
}