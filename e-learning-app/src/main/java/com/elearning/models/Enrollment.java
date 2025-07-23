package com.elearning.models;

public class Enrollment {
    private int enrollmentId;
    private int userId;
    private int courseId;

    public Enrollment(int enrollmentId, int userId, int courseId) {
        this.enrollmentId = enrollmentId;
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}