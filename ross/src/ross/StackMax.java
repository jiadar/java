package ross;

import java.util.Deque;
import java.util.LinkedList;

public class StackMax {

  private class MaxCount {
    public int value=0;
    public int count=0;
    public MaxCount(int v) {
      value=v;
      count=1;
    }
  }

  private Deque<Integer> stack = new LinkedList<Integer>();
  private Deque<MaxCount> max=new LinkedList<MaxCount>();
  private MaxCount cached_max;

  public int max() {
    return (max.isEmpty() ? 0 : max.peek().value);
  }

  public Integer pop() {
    if (stack.peek()==max.peek().value) 
      if (max.peek().count>1) 
        max.peek().count--;
      else 
        max.pop();
    return stack.pop();  
  }

  public StackMax push(int v) {
    if (max.isEmpty()) {
      max.push(new MaxCount(v));
      stack.push(v);
    } 
    else if (v==max.peek().value) {
      max.peek().count++;
      stack.push(v);
    }
    else if (v>max.peek().value) { 
      max.push(new MaxCount(v));
      stack.push(v);
    }
    else { 
      stack.push(v);
    }
    return this;
  }   
  
  public String toString() {
    return stack.toString();
  }
}
