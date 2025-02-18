import java.util.HashSet;
import java.util.Set;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityCourse {
    private String courseName;
    private int maxEnrollment;
    private Set<String> enrolledStudents;
    private String prerequisiteCourse;

    public UniversityCourse(String courseName, int maxEnrollment, String prerequisiteCourse) {
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.prerequisiteCourse = prerequisiteCourse;
        this.enrolledStudents = new HashSet<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getPrerequisiteCourse() {
        return prerequisiteCourse;
    }

    public boolean enrollStudent(String studentName, Set<String> completedCourses) throws CourseFullException, PrerequisiteNotMetException {
       
        if (!completedCourses.contains(prerequisiteCourse)) {
            throw new PrerequisiteNotMetException("Complete " + prerequisiteCourse + " before enrolling in " + courseName + ".");
        }

        if (enrolledStudents.size() >= maxEnrollment) {
            throw new CourseFullException("The course " + courseName + " is full. Cannot enroll " + studentName + ".");
        }
        enrolledStudents.add(studentName);
        return true;
    }

    public void displayEnrollmentStatus() {
        System.out.println("Course: " + courseName + " - Enrolled Students: " + enrolledStudents.size() + "/" + maxEnrollment);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Set<String> completedCourses = new HashSet<>();
        completedCourses.add("Core Java");

        UniversityCourse advancedJava = new UniversityCourse("Advanced Java", 2, "Core Java");

        String studentName = "John Doe";

        try {
          
            if (advancedJava.enrollStudent(studentName, completedCourses)) {
                System.out.println(studentName + " successfully enrolled in " + advancedJava.getCourseName());
            }
        } catch (PrerequisiteNotMetException e) {
            
            System.out.println("Error: " + e.getMessage());
        } catch (CourseFullException e) {
          
            System.out.println("Error: " + e.getMessage());
        } finally {
          
            advancedJava.displayEnrollmentStatus();
        }
    }
}
