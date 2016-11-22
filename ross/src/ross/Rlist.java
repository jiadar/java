package ross;

public class Rlist {
  private int nodes;
  private Rnode head;

  public Rlist() {
    head=new Rnode();
  }

  public boolean isEmpty() {
    return (head.isSingleton()) ? true : false;
  }

  public Rlist delete(int value) {
    if (this.isEmpty()) {
      return this;
    } else if (this.length()==1 && value==1) {
        head=new Rnode();
        return this;
    } else {
      Rnode slow=head;
      Rnode fast=head.next();
      int count=0;
      while (fast.loop() && count != value-1) {
        slow=slow.next();
        fast=fast.next();
        count++;
      }
      if (count == value-1) 
        slow.setNext(fast.next()); 
      return this;
    }
  }
  
  public Rlist insert(int value) {
    if (this.isEmpty()) {
      head.linkTo(new Rnode(value));
      return this;
    }
    else {
      Rnode iter=head;
      while (iter.loop()) {
        iter=iter.next();
      }
      iter.linkTo(new Rnode(value));
      return this;
    }
  }

  public Rlist append(Rlist list) {
    list.splice(1, this);
    head=list.lookup(0);
    return this;
  }
  public Rlist splice(int key, Rlist middle) {
    if (key==1) { 
      Rlist temp=new Rlist();
      Rnode temp_head=temp.lookup(0);
      temp_head=middle.lookup(0);
      Rnode temp_tail=temp.tail();
      temp_tail=head;
      temp.head=temp_head;
      temp_tail=temp.tail().setNext(head.next());
      head=temp.lookup(0);
      return this;
    } else { 
      Rnode start = this.lookup(key);
      Rnode end = this.lookup(key+1);
      start.linkTo(middle.head());
      middle.tail().linkTo(end);
    }
    return this;
  }

  public Rnode head() {
    return (this.isEmpty() ? head : head.next());
  }

  public Rnode tail() {
    return this.lookup(this.length());
  }

  public int length() {
    int count=0;
    if (this.isEmpty()) {
      return 0;
    }
    else {
      Rnode iter=head;
      while (iter.loop()) {
        iter=iter.next();
        count++;
      }
      return count;
    }
  }

  public Rnode lookup(int key) {
    if (key==0)
      return head;
    key = (key < 1) ? 1 : key;
    int i=1;
    if (this.isEmpty()) {
      return head;
    }
    else {
      Rnode iter=head;
      while (iter.loop() && i!=key) {
        iter=iter.next();
        i++;
      }
      return (iter.next()==null ? iter : iter.next());
    }
  }

  public String toString() {
    String rval="";
    Rnode iter=new Rnode();
    if (this.isEmpty()) {
      return "null";
    }
    else if(this.head.next()==null) {
      return "null";
    }
    else {
      iter=head.next();
      while (iter.loop()) {
        rval+=iter.value() + ", ";
        iter=iter.next();
      }
    }
    return rval + iter.value();
  }

  public String toRString() {
    return (this.head.next()==null) ? "null" : this.head.next().toString();
  }
}