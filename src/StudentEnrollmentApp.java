import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentEnrollmentApp {

    private static List<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<>();

        printMenu("Enter the number of students to enroll: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        for (int i = 0; i < Integer.valueOf(input); i++) {
            Student student = new Student();
            student.registerStudent(scanner);
            students.add(student);
        }

        do {
            printMenu("Here are the students.  Enter a studentId to login: ");
            input = scanner.next();
            if (!"0".equals(input)) {
                Student student = getStudentById(input);
                student.processStudentChoices(scanner);
            }

        } while (!"0".equals(input));

    }

    private static void printStudents() {
        for (Student student : students) {
            student.printStudent();
        }
    }

    private static Student getStudentById(String input) {
        Student theStudent = null;

        for (Student student : students) {
            if (input != null && input.equalsIgnoreCase(student.getStudentId())) {
                theStudent = student;
                break;
            }
        }

        return theStudent;
    }

    private static void printMenu(String prompt) {
        System.out.println("*****************************************************************************");
        System.out.println("                  WELCOME TO THE COLLEGE OF WINTERHOLD");
        System.out.println("     "+prompt);
        System.out.println("");
        if (students != null && !students.isEmpty()) {
            printStudents();
        }
        System.out.println("");
        System.out.println("     Enter 0 to Exit");
        System.out.println("*****************************************************************************");
    }
}
