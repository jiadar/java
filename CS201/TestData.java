import java.util.Scanner;

public class TestData {

  public enum Stat { STUDENT, TEST }
  static void printMenu() {
    System.out.println("STUDENT TEST STATS MENU");
    System.out.println("-----------------------\n");
    System.out.println("1. Student stats");
    System.out.println("2. Test stats");
    System.out.println("0. Exit\n"); 
  }
  
  static String computeStats(int[][] scores, String[] students, Stat st){
    String rval="";
    int min, sum, max, i, j, curScore; 
    int iMax = st == Stat.STUDENT ? scores.length : scores[0].length;
    int jMax = st == Stat.STUDENT ? scores[0].length : scores.length;

    for(i=0;i<iMax;i++) {
      min=100; sum=0; max=0;
      for(j=0;j<jMax;j++) {
        curScore = st == Stat.STUDENT ? scores[i][j] : scores[j][i];
        max = curScore > max ? curScore : max;
        min = curScore < min ? curScore : min;
        sum+=curScore;
      }
      rval+=(st == Stat.STUDENT ? String.format("%-8s", students[i]) : "Test " + i);
      rval+= ": Min " + min + " Max " + max + " Avg " + String.format("%2.2f\n", (double)sum/jMax);
    }

    return rval;
  }

  public static void main(String[] args) {
    int option = 1;
    String [] students = {"Max", "Lucy", "Tomas", "Lori", "Nicole", "Dennis"};
    int [][] scores = {{63, 77, 89, 74, 88}, {95, 67, 72, 83, 98}, {92, 89, 73, 77, 88}, 
        {89, 90, 83, 78, 82}, {76, 87, 74, 79, 90}, {76, 85, 94, 99, 70}};
    Scanner input = new Scanner(System.in);

    while(option != 0) {
      printMenu();
      option = input.nextInt();
      switch(option) {
      case 0:
        System.out.println("Bye bye...");
        break;
      case 1:
        System.out.println(computeStats(scores, students, Stat.STUDENT));
        break;
      case 2:
        System.out.println(computeStats(scores, students, Stat.TEST));
        break;
      default:
        System.out.println("I don't understand your request. Try again.");
      }
    }
  }
}

