package lab.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;

    private String studentGroup;
    private boolean hasScholarship;
    private double scholarship;
    private double averageMark;
    private String profilePhoto;

    public String getRandom() {
        String [] arr = new String[]{"bg-primary", "bg-secondary", "bg-success", "bg-danger", "bg-warning",
                "bg-info", "bg-light", "bg-dark", "bg-white"};
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }

    @Transient
    private String random;

    public Student() {
    }

    public Student(String firstName, String lastName, String studentGroup, boolean hasScholarship, double scholarship, double averageMark, String profilePhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentGroup = studentGroup;
        this.hasScholarship = hasScholarship;
        this.scholarship = scholarship;
        this.averageMark = averageMark;
        this.profilePhoto = profilePhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName + "\n" +
                "LastName: " + lastName + "\n" +
                "AverageMark: " + averageMark + "\n" +
                "Has SCH: " + hasScholarship + "\n" +
                "SCH: " + scholarship;
    }
}
