package ross;

public class Rnode {
  private int data=0;
  private Rnode next=null;
  private boolean empty=true;

  public Rnode() {
    data=0;
    next=null;
  }

  public Rnode(int d) {    
    data=d;
    next=null;
  }

  public Rnode(int d, Rnode list) {
    data=d;
    next=list;
  }

  public boolean isSingleton() {
    return (next==null);
  }
  
  public boolean loop() {
    // will allow iteration until we reach an empty rnode
    return (next!=null);
  }
  
  public void setValue(int d) {
    data=d;
  }

  public void set(int d, Rnode link) {
    data=d;
    next=link;
  }

  public Rnode linkTo(Rnode link) {
    next=link;
    return this;
  }
  
  public Rnode setNext(Rnode link) {
    next=link;
    return this;
  }
  
  public void zero() {
    data=0; 
    next=null;
  }

  public int value() {
    return data;
  }
  
  public Rnode next() {
    return next;
  }
  
  public String toString() {
    return this.toStringR();
  }
    
  public String toStringR() {
    String rval="";
    if (this.isSingleton()) 
      rval = data+"";
    else 
      rval = data + ", " + next.toStringR();
    return rval;
  }  
}
