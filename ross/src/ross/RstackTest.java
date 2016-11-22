package ross;

import static org.junit.Assert.*;

import org.junit.Test;

public class RstackTest {

  private Rstack Rstack1;
  private Rstack Rstack2;
  
  @Test
  public void testIsEmpty() {
    Rstack1=new Rstack();
    assertEquals(Rstack1.isEmpty(), true);
    Rstack1.push(1).push(2).push(3);
    assertEquals(Rstack1.isEmpty(), false);
    Rstack1.pop();
    Rstack1.pop();
    Rstack1.pop();
    assertEquals(Rstack1.isEmpty(), true);
  }
  
  @Test
  public void testPop() {
    Rstack1=new Rstack();
    Rstack1.push(1).push(2).push(3);
    assertEquals(Rstack1.pop(), 3); 
    assertEquals(Rstack1.pop(), 2); 
    assertEquals(Rstack1.pop(), 1); 
  }

  @Test
  public void testPush() {
    Rstack1=new Rstack();
    assertEquals(Rstack1.push(1).toString(), "1"); 
    assertEquals(Rstack1.push(2).toString(), "2, 1"); 
    assertEquals(Rstack1.push(3).toString(), "3, 2, 1"); 
    Rstack1.pop();
    assertEquals(Rstack1.push(4).toString(), "4, 2, 1"); 
  }

  @Test
  public void testToString() {
    Rstack1=new Rstack();
    assertEquals(Rstack1.toString(), "null");
    assertEquals(Rstack1.push(1).push(2).push(3).toString(), "3, 2, 1");
  }

}