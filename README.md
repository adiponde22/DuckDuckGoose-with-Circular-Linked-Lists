In the (simplified) game of Duck, Duck, Goose!, the first person is declared “Duck,” the second person is declared “Duck,” and the third person is declared “Goose” and is then out of the game. In the next iteration, we start with the fourth person (the person after the one who was just eliminated). This process repeats until there is only one person left in the circle; that person is the winner.

You will use a circular linked list for this lab. The basic linked list class (LList) we wrote is provided on the next page for you. (It uses slightly easier organization than the DLList code we wrote.) But you will have to adjust this to be a circular list (CLList), and that will involve adjusting the code in some of the methods. Some methods will not be needed, and you can leave them alone or “comment them out” if you like. (You can use your own code if you prefer. In the end, the linked list should be circular, but does not have to be doubly-linked.)

The program should take in as input the number of players, and set up a linked list assigning the player’s number in the data field for that player. The last node remaining will contain the winner’s number.

The program should run for as long as a user enters the number of players, and end when the user enters 0. Any invalid input should indicate an error and ask the user to try again.

Again, the LList class is on the next page.public class LList {
 private Node head;
 
 static class Node {
   private Node next;
   private Object data;
 
   public Node(Object dataValue) {
     next = null;
     data = dataValue;
   }
 }
 
 public LList() {
   head = null;
 }
 
 public Node getNext(Node n) { return n.next; }
 
 public Object getData(Node n) { return n.data; }
 
 public void InsertAtHead(Object info) {
   Node temp = new Node(info);
   temp.next = head;
   head = temp;
 }
 
 public void InsertAtTail(Object info) {
   Node temp = new Node(info);
 
   if (head == null) {
     head = temp;
   } else {
     Node iterator = head;
     while (iterator.next != null)
       iterator = iterator.next;
     iterator.next = temp;
   }
 }
 
 public void InsertItem(Node before, Object info) {
   Node temp = new Node(info);
   temp.next = before.next;
   before.next = temp;
 }
 

 public int DeleteNode(Object info) {
   Node temp = Find(info);
 
   if (temp == null)
     return 0;
 
   Node iterator = head;
 
   while (iterator != null && iterator.next != temp)
     iterator = iterator.next;
 
   iterator.next = temp.next;
 
   return 1;
 
 }
 
 public void PrintList() {
   Node iterator = head;
   while (iterator != null) {
     System.out.println(iterator.data);
     iterator = iterator.next;
   }
 }
 
 public Node Find(Object target) {
   Node iterator = head;
   while (iterator != null && iterator.data != target)
     iterator = iterator.next;
 
   return iterator;
 }
}
