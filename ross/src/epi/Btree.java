package epi;

import javax.rmi.CORBA.Util;

// Test if a binary tree is height balanced


public class Btree {
  Integer data;
  Btree left, right;

  private enum Branch {
    ROOT, LEFT, RIGHT;
  }
  
  public Btree() {
    data=null;
    left=null;
    right=null;
  }

  public Btree(Integer d) {
    data=d; 
    left=null;
    right=null;
  }

  public Btree(Integer d,Btree l, Btree r) {
    data=d;
    left=l;
    right=r;
  }

  public static Btree insert(Btree node, Integer value) {
    Btree head=node;
    if (head.data==null) {
      head.data=value;
      head.left=head.left == null ? new Btree() : head.left;
      head.right=head.right == null ? new Btree() : head.right;
    }
    else if(value<head.data) {
      if (head.left == null) head.left=new Btree();
      insert(head.left,value);
    }
    else if (value>head.data) {
      if (head.right == null) head.right=new Btree();
      insert(head.right,value);
    }
    else {
      System.out.println("Duplicate");
    }
    return head;
  }

  public String toLine() {
    StringBuilder builder = new StringBuilder();
    if (this.data != null && this.left != null)
      builder.append(this.left.toLine()).append(", ");
    if (this.data != null && this.right != null)
      builder.append(this.right.toLine()).append(", ");
    return (this.data==null) ? "N" : builder.append(this.data.toString()).toString();    
  }

  public String toCompressedString() {
    return this.toString().replaceAll("\n","").replaceAll("\\+", " ").replaceAll(" ","").replaceAll("-","").replaceAll("\\|", "\\.").toLowerCase();
  }
  
  public String toString() {
    Btree root=this;
    StringBuilder builder=new StringBuilder();
    printTree(root, 0, builder, Branch.ROOT);
    return builder.toString();
  }

  private static void printTree(Btree root, int indent, StringBuilder builder, Branch branch) {
    if (root.data != null) {
      builder.append(genIndent(indent));
      if (branch==Branch.ROOT) builder.append("+--");
      else builder.append((branch == Branch.LEFT) ? "L--" : "R--");
      builder.append(root.data.toString());
      builder.append("\n");
    }
    if (root.left != null) {
      printTree(root.left, indent+1, builder, Branch.LEFT);        
    } 
    if (root.right != null) {
      printTree(root.right, indent+1, builder, Branch.RIGHT);
    } 
  }
    
  private static String genIndent(int indent) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < indent; i++) {
      sb.append("|  ");
    }
    return sb.toString();
  }
}