package ross;

import static org.junit.Assert.*;

import org.junit.Test;

public class RlistTest {

  /*
  @Test
  public void testInsert() {
    fail("Not yet implemented");
  }

  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }
*/

  private Rlist list1;
  private Rlist list2;
  private Rlist list3;
  
  public void setup() {

  }
  
  @Test
  public void testDelete() {
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    list3=new Rlist();
    assertEquals(list1.delete(3).toString(),"1, 2, 4, 5, 6");
    assertEquals(list1.delete(3).toString(),"1, 2, 5, 6");
    assertEquals(list1.delete(3).toString(),"1, 2, 6");
    assertEquals(list1.delete(3).toString(),"1, 2");
    assertEquals(list1.delete(3).toString(),"1, 2");
    assertEquals(list2.delete(1).toString(),"8, 9");
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    assertEquals(list1.delete(6).toString(),"1, 2, 3, 4, 5");
    assertEquals(list3.delete(1).toString(),"null");

  }
  @Test
  public void testAppend() {
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    list3=new Rlist();
    assertEquals(list1.append(list2).toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9");
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    list3=new Rlist();
    assertEquals(list2.append(list3).toString(), "7, 8, 9");
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    list3=new Rlist();
    assertEquals(list3.append(list1).toString(), "1, 2, 3, 4, 5, 6");
  }
  
  @Test
  public void testLength() {
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    list3 =new Rlist();
    assertEquals(list1.length(), 6);
    assertEquals(list2.length(), 3);
    assertEquals(list3.length(), 0);
  }
  
  @Test
  public void testTail() {
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    assertEquals(list1.tail().toString(),"6");
    assertEquals(list2.tail().toString(),"9");
  }
  
  @Test
  public void testSplice() {
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    assertEquals(list1.splice(3,list2).toString(), "1, 2, 3, 7, 8, 9, 4, 5, 6");
    list1=(new Rlist()).insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    list2=(new Rlist()).insert(7).insert(8).insert(9);
    assertEquals(list1.splice(1,list2).toString(), "7, 8, 9, 1, 2, 3, 4, 5, 6");

  }
  
  @Test
  public void testLookup() {
    Rlist list = new Rlist();
    assertEquals(list.lookup(1).toString(), "0");
    assertEquals(list.lookup(-16).toString(), "0");
    assertEquals(list.lookup(24).toString(), "0");
    list.insert(1).insert(2).insert(3).insert(4).insert(5).insert(6);
    assertEquals(list.lookup(-16).toString(), "1, 2, 3, 4, 5, 6");
    assertEquals(list.lookup(1).toString(), "1, 2, 3, 4, 5, 6");
    assertEquals(list.lookup(4).toString(), "4, 5, 6");
    assertEquals(list.lookup(6).toString(), "6");
    assertEquals(list.lookup(24).toString(), "6");
  }

  @Test
  public void testToString() {
    Rlist list = new Rlist();
    assertEquals(list.toString(), "null");
    list.insert(5);
    assertEquals(list.toString(), "5");
    list.insert(7);
    assertEquals(list.toString(), "5, 7");
    list.insert(9);
    assertEquals(list.toString(), "5, 7, 9");
  }
/*
  @Test
  public void testSearch() {
    fail("Not yet implemented");
  }
*/
}
