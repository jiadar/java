public class Function2 {

    private static void setGrade(String[] names, double[] grades, int size, String student, int grade) {
      for(int i = 0; i < size; i++) 
          if(names[i] == student)
              grades[i] = grade;
    }
    
    public static void main(String[] args)
    {
        int classSize = 5;
        String [] studNames = {"Mark", "Mary", "Eddie", "Angela", "Bruce"};
        double [] studGrades = new double[classSize];

        setGrade(studNames, studGrades, classSize, "Mark", 87);
        setGrade(studNames, studGrades, classSize, "Mary", 93);
        setGrade(studNames, studGrades, classSize, "Eddie", 75);
        setGrade(studNames, studGrades, classSize, "Angela", 80);
        setGrade(studNames, studGrades, classSize, "Bruce", 89);
        for(int i = 0; i < classSize; i++)
            System.out.println(studNames[i] + "'s grade = " + studGrades[i]);
    }
}