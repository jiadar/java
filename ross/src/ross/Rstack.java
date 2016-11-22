package ross;

import ross.Rnode;

public class Rstack {

  private Rlist stack;
  private int length;

  
  public Rstack() {
    stack=new Rlist();
  }
  
  public boolean isEmpty() {
    return stack.isEmpty();
  }
  
  public int pop() {
    int rval = stack.lookup(1).value();
    stack.delete(1);
    length--;
    return rval;
  }
  
  public Rstack push(int v) {
    stack.splice(1, new Rlist().insert(v));
    length++;
    return this;
  }

  
  public String toString() {
    return stack.toString();
  }
}

