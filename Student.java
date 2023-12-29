import java.util.ArrayList;
import java.util.List;

// Student.java
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private List<Course> courses;

    // Constructor
    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<>();
    }

    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Method to enroll in a course
    public void enroll(Course course) {
        courses.add(course);
        System.out.println("Enrolled in course: " + course.getCourseName());
    }
}

// Course.java
public class Course {
    private int courseId;
    private String courseName;
    private Instructor instructor;

    // Constructor
    public Course(int courseId, String courseName, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    // Getter methods
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }
}

// Instructor.java
public class Instructor {
    private int instructorId;
    private String firstName;
    private String lastName;

    // Constructor
    public Instructor(int instructorId, String firstName, String lastName) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter methods
    public int getInstructorId() {
        return instructorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

// Main.java (Example usage)
public class Main {
    public static void main(String[] args) {
        // Creating an Instructor
        Instructor instructor = new Instructor(101, "John", "Doe");

        // Creating a Course with the Instructor
        Course mathCourse = new Course(1, "Mathematics", instructor);

        // Creating a Student
        Student student = new Student(1001, "Alice", "Smith");

        // Enrolling the student in the course
        student.enroll(mathCourse);

        // Displaying information
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Enrolled Courses: " + student.getCourses().get(0).getCourseName());
        System.out.println("Instructor Name: " + student.getCourses().get(0).getInstructor().getFirstName() + " "
                + student.getCourses().get(0).getInstructor().getLastName());
    }
}
