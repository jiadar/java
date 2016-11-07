package ross;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 */

class Node {
  protected int data;
  protected Node next;
  public Node()                { next=null; data=0; }
  public Node(int d,Node n)    { data = d; next = n; }
  public void setLink(Node n)  { next = n; }
  public void setData(int d)   { data = d; }
  public Node getLink()        { return next; }
  public int getData()         { return data; }
}

class LinkedList {
  protected Node start;
  protected Node end ;
  public int size ;
  public LinkedList()          { start = null; end = null; size = 0; }
  public void insertAtEnd(int val) {
      Node nptr = new Node(val,null);    
      size++ ;         
      if(start == null) {
          start = nptr;
          end = start;
      }
      else {
          end.setLink(nptr);
          end = nptr;
      }
  }
}

public class LinkedListCycle {

  public static void main(String[] args) {
    Node list = new Node();
    Node nptr = new Node(val,null);    
    size++ ;    
    if(start == null) 
    {
        start = nptr;
        end = start;
    }
    else 
    {
        end.setLink(nptr);
        end = nptr;
    }
}
  }

  boolean hasCycle(Node head) {

    if (head.next == null)
      return false;
    if (head.next.next == null)
      return false;

    Node tort = head.next;
    Node hare = head.next.next; 

    while(tort!=hare && tort.next != null && hare.next.next != null) {
      tort=tort.next;
      hare=hare.next.next;
    }
    return (tort==hare ? true : false); 
  }
}
