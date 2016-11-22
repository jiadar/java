package ross;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RnodeTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testRnode() {
    Rnode r = new Rnode();
    Rnode s = new Rnode();
    r.set(5,null);
    assertEquals(r.value(), 5);
    assertEquals(r.next(), null);
    r.setNext(s);
    assertEquals(r.next(), s);
  }

  @Test
  public void testRnodeIntRnode() {
    Rnode s = new Rnode(6, null);
    Rnode r = new Rnode(5, s);
    assertEquals(r.value(), 5);
    assertEquals(s.value(), 6);
    assertEquals(r.next().value(), 6);
    assertEquals(r.next().next(), null);
    assertEquals(r.next(), s);
    assertEquals(s.next(), null);
  }

  @Test
  public void testToStringR() {
    Rnode t = new Rnode(7);
    Rnode s = new Rnode(6, t);
    Rnode r = new Rnode(5, s);
    Rnode q = new Rnode();
    assertEquals(q.toStringR(), "0");
    assertEquals(t.toStringR(), "7");
    assertEquals(s.toStringR(), "6, 7");
    assertEquals(r.toStringR(), "5, 6, 7");
  }

  @Test
  public void testisSingleton() {
    Rnode t = new Rnode(7, null);
    Rnode q = new Rnode();
    Rnode r = new Rnode(9, t);
    assertEquals(q.isSingleton(), true);
    assertEquals(t.isSingleton(), true);
    t.zero();
    assertEquals(t.isSingleton(), true);
    assertEquals(r.isSingleton(), false);
  }
}


