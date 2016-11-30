package epi;

import static org.junit.Assert.*;

import org.junit.Test;

public class BtreeTest {

  private static final int N=-1;
  private Btree tree1; 
  private Btree root;
  private Btree left;
  private Btree right;
  private int a[]={314,6,7,271,561,2,288,28,0,3,1,28,17,401,257,641};
 
  @Test  
  public void stringTest() {
    root=new Btree(a[0]); 
    root.left=new Btree(a[1]);
    root.right=new Btree(a[2]);
    root.left.left=new Btree(a[3]);
    root.left.right=new Btree(a[4]);
    root.right.left=new Btree(a[5]);
    root.right.right=new Btree(a[6]);
    assertEquals(root.toCompressedString(), "314.l6..l271..r561.r7..l2..r288");
  }


  @Test 
  public void insertTest() {
    root=new Btree();
    Btree.insert(root,50);
    Btree.insert(root,6);
    Btree.insert(root,17);
    Btree.insert(root,64);
    Btree.insert(root,77);
    Btree.insert(root,58);
    Btree.insert(root,18);
    Btree.insert(root,9);
    assertEquals(root.toCompressedString(),"50.l6..r17...l9...r18.r64..l58..r77");
  }
}
