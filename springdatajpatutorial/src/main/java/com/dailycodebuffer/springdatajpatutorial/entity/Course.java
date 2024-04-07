package com.dailycodebuffer.springdatajpatutorial.entity;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Course {
    @Id
    @SequenceGenerator(
        name = "course_sequence",
        sequenceName = "course_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_sequence"
    )
        private Integer courseId;
    private String title;
    private Integer credit;
    @OneToOne(mappedBy = "course")
        private CourseMaterial courseMaterial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
        private Teacher teacher;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course_map",
        joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "student_id",
            referencedColumnName = "studentId"
        )
    )
        private List<Student> students;

    public Course() {
        super();
    }
    public Course(Integer courseId, String title, Integer credit, CourseMaterial courseMaterial, Teacher teacher,
            List<Student> students) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
        this.courseMaterial = courseMaterial;
        this.teacher = teacher;
        this.students = students;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getCredit() {
        return credit;
    }
    public void setCredit(Integer credit) {
        this.credit = credit;
    }
    public CourseMaterial getCourseMaterial() {
        return courseMaterial;
    }
    public void setCourseMaterial(CourseMaterial courseMaterial) {
        this.courseMaterial = courseMaterial;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + 
            ", title=" + title + 
            ", credit=" + credit + 
            ", courseMaterial=" + courseMaterial + 
            ", teacher=" + teacher + 
            ", students=" + students + 
            "]";
    }

    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}