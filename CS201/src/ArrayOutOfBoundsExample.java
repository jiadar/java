
public class ArrayOutOfBoundsExample {
  public static void main(String[] args) {
    int ARRAY_SIZE = 5;
    int numbers[] = {1, 3, 4, 2, 1, 2};
    int i=0;
    while (i<=ARRAY_SIZE) {
      i++;
      System.out.println("numbers["+i+"] = " + numbers[i]);
    }
  }
}
