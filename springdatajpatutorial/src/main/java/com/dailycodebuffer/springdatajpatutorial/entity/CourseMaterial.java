package com.dailycodebuffer.springdatajpatutorial.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CourseMaterial {
    @Id
    @SequenceGenerator(
        name = "course_material_sequence",
        sequenceName = "course_material_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_material_sequence"
    )
    private Integer courseMaterialId;
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;

    public CourseMaterial() {
        super();
    }
    public CourseMaterial(Integer courseMaterialId, String url, Course course) {
        this.courseMaterialId = courseMaterialId;
        this.url = url;
        this.course = course;
    }
    public Integer getCourseMaterialId() {
        return courseMaterialId;
    }
    public void setCourseMaterialId(Integer courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    @Override
    public String toString() {
        return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + ", course=" + course + "]";
    }
}
