package ross;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackMaxTest {

  private StackMax stack1 = new StackMax();
  private Deque<Integer> stack2 = new LinkedList<Integer>();
  
  @Test
  public void testPush() {
    stack1=new StackMax();
    assertEquals(stack1.toString(), "[]");
    stack1.push(1);
    assertEquals(stack1.toString(), "[1]");
    stack1.push(2);
    assertEquals(stack1.toString(), "[2, 1]");
    stack1.push(3);
    assertEquals(stack1.toString(), "[3, 2, 1]");
  }

  @Test
  public void testPop() {
    stack1=new StackMax();
    stack1.push(1);
    stack1.push(2);
    stack1.push(3);
    assertEquals(stack1.pop().intValue(), 3); 
    assertEquals(stack1.pop().intValue(), 2); 
    assertEquals(stack1.pop().intValue(), 1); 
  }
  
  @Test
  public void testMax() {
    stack1=new StackMax();
    assertEquals(stack1.max(), 0);
    stack1.push(1);
    assertEquals(stack1.max(), 1); 
    stack1.push(2);
    assertEquals(stack1.max(), 2); 
    stack1.push(25);
    assertEquals(stack1.max(), 25); 
    stack1.push(3);
    assertEquals(stack1.max(), 25);
    stack1.push(33);
    assertEquals(stack1.max(), 33);
    stack1.push(36);
    assertEquals(stack1.max(), 36);
    stack1.push(5);
    assertEquals(stack1.max(), 36); 

    stack1.pop();
    assertEquals(stack1.max(), 36);
    stack1.pop();
    assertEquals(stack1.max(), 33);
    stack1.pop();
    assertEquals(stack1.max(), 25);
    stack1.pop();
    assertEquals(stack1.max(), 25);
    stack1.pop();
    stack1.pop();
    assertEquals(stack1.max(), 1);
  }
}
