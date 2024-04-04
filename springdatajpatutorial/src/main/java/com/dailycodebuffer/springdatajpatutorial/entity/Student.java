package com.dailycodebuffer.springdatajpatutorial.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "tbl_student",
    uniqueConstraints = 
        @UniqueConstraint(
            name = "emailid_unique",
            columnNames = "email_address"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Integer studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

    public Student() {
        super();
    }
    public Student(Integer studentId, String firstName, String lastName, String emailId, String guardianName,
            String guardianEmail, String guardianMobile) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.guardianName = guardianName;
        this.guardianEmail = guardianEmail;
        this.guardianMobile = guardianMobile;
    }
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getGuardianName() {
        return guardianName;
    }
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }
    public String getGuardianEmail() {
        return guardianEmail;
    }
    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }
    public String getGuardianMobile() {
        return guardianMobile;
    }
    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile;
    }
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
                + emailId + ", guardianName=" + guardianName + ", guardianEmail=" + guardianEmail + ", guardianMobile="
                + guardianMobile + "]";
    }
}