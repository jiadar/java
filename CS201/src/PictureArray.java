import java.util.Scanner;

public class PictureArray {

  public static void main(String[] args) {

    int length = 4;

    String[] pictures = new String[100];    
    pictures[0] = "mountains";
    pictures[1] = "lakes";
    pictures[2] = "meadows";
    pictures[3] = "stars";
    pictures[4] = "trees";

    printMenu();

    Scanner s = new Scanner(System.in);
    int choice = s.nextInt();
    while (choice != 3){
      switch (choice) {
      case 1:
        printPictures(pictures,length);
        break;
      case 2:
        System.out.print("Enter element: ");
        length=addElement(s.next(),pictures,length);
        break;
      default:
        System.out.println("I don't know what to do with your request of " + choice + ".");
        System.out.println("Please try again.");
        break;
      }
      printMenu();
      choice = s.nextInt();
    }
    System.out.println("Goodbye now...");    
  }

  private static int addElement(String next, String[] pictures, int length) {
    pictures[length]=next;
    return length++;
  }

  private static void printPictures(String[] pictures, int length) {
    for (int i=0; i<=length; i++) {
      System.out.println("Picture #" + i + ": " + pictures[i]);
    }
  }

  private static void printMenu() {
    System.out.println("1: Print pictures");
    System.out.println("2: Add Element");
    System.out.println("3: Quit");
  }
}