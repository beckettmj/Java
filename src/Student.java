import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private int tuitionBalance = 0;
    private String studentId;
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Scanner scanner) {
        System.out.println("Enter first and last name of student [FIRST LAST]: ");
        firstName = scanner.next().toUpperCase();
        lastName = scanner.next().toUpperCase();

        System.out.println("Enter year of student [1 2 3 4]: ");
        year = scanner.nextInt();

        String idLast = (lastName != null && lastName.length() > 2) ? lastName.substring(0, 3) : lastName;
        String idFirst = (firstName != null && firstName.length() > 2) ? firstName.substring(0, 3) : firstName;
        studentId = idLast + idFirst + String.valueOf(year);
    }

    public void printStudent() {
        System.out.println("\t" + studentId + "\t\t" + firstName + " " + lastName + "\t\tYear " + year);
    }

    public void processStudentChoices(Scanner scanner) {
        String input = "";
        do {
            printStudentMethod();
            input = scanner.next();

            if ("A".equalsIgnoreCase(input)) {
                enrollCourse(scanner);
            }
            else if ("D".equalsIgnoreCase(input)) {
                dropCourse(scanner);
            }
            else if ("P".equalsIgnoreCase(input)) {
                payTuition(scanner);
            }
        } while (!"0".equals(input));
    }

    private void payTuition(Scanner scanner) {
        System.out.println("Your tuition balance due is currently: $" + tuitionBalance);
        System.out.println("How much would you like to pay? ");
        String input = scanner.next();
        tuitionBalance -= Integer.valueOf(input);
    }

    private void dropCourse(Scanner scanner) {
        System.out.println("Here are you're currently enrolled courses: ");
        printCourses();
        System.out.println("Which course would you like to drop? ");
        String input = scanner.next();
        String courseName = input;
        int index = 0;
        int courseCost = 0;
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                courseCost = course.getCost();
                break;
            }
            index++;
        }
        courses.remove(index);
        tuitionBalance -= courseCost;
    }

    private Integer calcCourseYear(String courseName) {
        return Integer.valueOf(courseName.split("_")[1].substring(0, 1));
    }

    private void enrollCourse(Scanner scanner) {
        System.out.println("Here are the available courses: ");
        printAvailableCourses();
        System.out.println("Enter the name of the course you would like to enroll: ");
        String input = scanner.next();
        String courseName = input;
        int courseYear = calcCourseYear(courseName);
        int courseCost = 200 * courseYear;
        courses.add(new Course(courseName, courseCost));
        tuitionBalance += courseCost;
    }

    private void printAvailableCourses() {
        for (CoursesEnum course : CoursesEnum.values()) {
            System.out.println(course);
        }
    }

    private void printStudentMethod() {
        System.out.println("*****************************************************************************");
        System.out.println("     WELCOME TO THE COLLEGE OF WINTERHOLD, " + firstName + " " + lastName + " (" + studentId + ")");
        System.out.println("");
        String balance = (tuitionBalance > 0) ? "Balance" : "Refund";
        System.out.println("     Current Courses Enrolled:                 Tuition " + balance + " Due: $" + Math.abs(tuitionBalance));
        printCourses();
        System.out.println("");
        System.out.println("     What would you like to do?");
        System.out.println("");

        if (courses != null && courses.size() < 6) {
            System.out.println("     Enter A to Add a course");
        }

        if (courses != null && courses.size() > 0) {
            System.out.println("     Enter D to Drop a course");
        }

        if (tuitionBalance > 0) {
            System.out.println("     Enter P to Pay your tuition");
        }

        System.out.println("");
        System.out.println("     Enter 0 to Go Back to Main Menu");
        System.out.println("*****************************************************************************");
    }

    private void printCourses() {
        for (Course course : courses) {
            course.printCourse();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getTuitionBalance() {
        return tuitionBalance;
    }

    public void setTuitionBalance(int tuitionBalance) {
        this.tuitionBalance = tuitionBalance;
    }

}
