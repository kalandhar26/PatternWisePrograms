package altimetrik;

import java.util.List;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private int rollNumber;
    private List<Subject> subject;

    public Student(Long id, String firstName, String lastName, int rollNumber, List<Subject> subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setName(String lastName) {
        this.lastName = lastName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rollNumber=" + rollNumber +
                ", subject=" + subject +
                '}';
    }
}
