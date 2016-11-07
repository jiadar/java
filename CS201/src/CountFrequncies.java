public class CountFrequncies {      
    public static void main(String[] args) {
    // Initialization
    final int ARRAY_SIZE = 20;
    int n = ARRAY_SIZE;
    int numbers[] = {5, 4, 6, 87, 33, 87, 5, 22, 32, 6, 87, 5, 4, 4, 18, 33, 87, 4, 6, 22};
    int recorded[] = new int[n];
    int recordedSize = 0;
    int count;
    int total=0;
    boolean rec;
    
    int i = 0;
    while(i < n) {  
      rec = false;
      for(int j = 0; j < recordedSize; j++) {
        if(numbers[i] == recorded[j]) {
          rec = true;      
          break;
        }
      }
      if(!rec && i != n-1)  {           
        count = 0;            
        for(int j = i; j < n; j++) {
          if(numbers[i] == numbers[j]) {
            count++;
          }
        }
        recorded[recordedSize] = numbers[i];
        recordedSize++;
        System.out.println(numbers[i] + ": " + count);
        total += count;
      }
      i++;
    }
    System.out.println("Total numbers counted: " + total);
  }
}
