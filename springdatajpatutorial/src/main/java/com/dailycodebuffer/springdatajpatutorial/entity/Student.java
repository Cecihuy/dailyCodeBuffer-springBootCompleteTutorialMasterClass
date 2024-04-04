package com.dailycodebuffer.springdatajpatutorial.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
    @Embedded
    private Guardian guardian;
    
    public Student() {
        super();
    }
    public Student(Integer studentId, String firstName, String lastName, String emailId, Guardian guardian) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.guardian = guardian;
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
    public Guardian getGuardian() {
        return guardian;
    }
    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
                + emailId + ", guardian=" + guardian + "]";
    }    
}