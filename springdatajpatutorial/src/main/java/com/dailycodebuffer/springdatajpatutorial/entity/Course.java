package com.dailycodebuffer.springdatajpatutorial.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Course() {
        super();
    }
    public Integer getCourseId() {
        return courseId;
    }
    public Course(Integer courseId, String title, Integer credit, CourseMaterial courseMaterial) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
        this.courseMaterial = courseMaterial;
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
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + 
            ", title=" + title + 
            ", credit=" + credit + 
            ", courseMaterial=" + courseMaterial + 
            "]";
    }
}