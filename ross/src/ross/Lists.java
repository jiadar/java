package ross;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Lists {

  static class Node {
    int data;
    Node next;

    Node Insert(Node head,int x) {
      Node temp = new Node();
      temp.data = x;
      temp.next = null;
      if(head == null) {
        return temp;
      }
      Node temp1;
      for(temp1 = head;temp1.next!=null;temp1 = temp1.next);
      temp1.next = temp;
      return head;
    }

    public String toString() {
      String rval="[";
      Node cur=this.next;
      while (cur != null) {
        rval += (cur.data + ((cur.next!= null) ? ", " : ""));
        cur=cur.next;
      }
      return rval + "]";
    }

    public static Node Append(Node a, Node b) {
      Node tail=a;
      Node cur=a;
      while (a.next!=null) {
        a=a.next;
      }
      a.next=b.next;
      return tail;
    }

    public static Node MergeSorted(Node a, Node b) {
      Node result=new Node();
      Node p=result;
      while(a!=null || b!=null) {
        if (a!= null && b!= null) {
          if(a.data<=b.data) {
            p.next=a;
            a=a.next;
          }
          else {
            p.next=b;
            b=b.next;
          }
          p=p.next;
        }
        if (a==null) {
          p.next=b;
          break;
        }
        else if (b==null) {
          p.next=a;
          break;
        }
      }
      return result.next.next;
    }


    public static Node ReverseSublist(Node list, int start, int finish) {
      // find start of reversion
      Node head=list;
      int i=1;
      while(i++ < start) {
        head=head.next;
      }
      Node iter=head.next;
      while(i++ < finish) {
        Node temp = iter.next;
        iter.next=temp.next;
        temp.next=head.next;
        head.next=temp;
      }
      return list;
    }

    public static Node RemoveDuplicates(Node list) {
      Node iter=list;
      while(iter.next!=null) {
        while (iter.data==iter.next.data) {
          iter.next=iter.next.next;
        }
        iter=iter.next;
      }
      return list;
    }
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int l1=in.nextInt();
    int l2=in.nextInt();    
    Node head1=new Node();
    Node head2=new Node();
    while (l1-- >0) 
      head1 = head1.Insert(head1,in.nextInt());
    while (l2-- >0) 
      head2 = head2.Insert(head2,in.nextInt());
    System.out.println(head1);
    //    System.out.println(head2);
    //    System.out.println(Node.Append(head1, head2));
    //    Node m = Node.MergeSorted(head1, head2);
    //Node r = Node.ReverseSublist(head1, 3, 8);
    Node r=Node.RemoveDuplicates(head1);
    System.out.println(r);
  }
}
