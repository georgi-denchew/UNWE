package studentsgrades;
import java.util.Scanner;

public class StudentsGrades {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of students between 1 and 30");

        int n = scan.nextInt();

        while (n < 1 || n > 30) {
            System.out.println("Enter a number of students between 1 and 30.");

            n = scan.nextInt();
        }

        double[][] studentsAndGrades = new double[n][5];

        double averageGrade = 0;
        
        // The maximal average grade is by default the minimal possible value;
        double maxStudentAverageGrade = 2;
        int maxStudentAverageGradePosition = -1;
        
        // The minimal average grade is by default the maximal possible value;
        double minStudentAverageGrade = 6;
        int minStudentAverageGradePosition = -1;

        for (int i = 0; i < studentsAndGrades.length; i++) {

            double currentStudentAverageGrade = 0;

            System.out.println("Enter 5 grades for the current student:");
            
            for (int j = 0; j < studentsAndGrades[i].length; j++) {

                studentsAndGrades[i][j] = scan.nextDouble();

                while (studentsAndGrades[i][j] < 2 || studentsAndGrades[i][j] > 6) {
                    System.out.println("Enter a grade between 2 and 6.");
                    studentsAndGrades[i][j] = scan.nextDouble();
                }
                
                currentStudentAverageGrade += studentsAndGrades[i][j];
                averageGrade += studentsAndGrades[i][j];
            }

            currentStudentAverageGrade = currentStudentAverageGrade / 5;

            if (currentStudentAverageGrade > maxStudentAverageGrade) {
                maxStudentAverageGrade = currentStudentAverageGrade;
                maxStudentAverageGradePosition = i;
            }
            if (currentStudentAverageGrade < minStudentAverageGrade) {
                minStudentAverageGrade = currentStudentAverageGrade;
                minStudentAverageGradePosition = i;
            }
        }

        averageGrade = averageGrade / n;
        averageGrade = averageGrade / 5;
        
        int aboveAverageCount = 0;
        int belowAverageCount = 0;
        
        for (int i = 0; i < studentsAndGrades.length; i++) {
            
            double currentStudentAverageGrade = 0;

            for (int j = 0; j < studentsAndGrades[i].length; j++) {
                currentStudentAverageGrade += studentsAndGrades[i][j];
            }
            
            currentStudentAverageGrade = currentStudentAverageGrade / 5;
            
            if (currentStudentAverageGrade > averageGrade) {
                aboveAverageCount++;
            }
            else if (currentStudentAverageGrade < averageGrade) {
                belowAverageCount++;
            }
        }

        System.out.println("The average grade for all students is: " + averageGrade);
        System.out.println("The number of the student with the highest grade is: " +
                maxStudentAverageGradePosition + ". The grade is: " + maxStudentAverageGrade);
        System.out.println("The number of the student with the lowest grade is: " +
                minStudentAverageGradePosition + ". The grade is: " + minStudentAverageGrade);
        System.out.println("The count of the students with a grade above the average is: " +
                aboveAverageCount + ".");
        System.out.println("The count of the students with a grade below the average is: " +
                belowAverageCount + ".");
    }
}