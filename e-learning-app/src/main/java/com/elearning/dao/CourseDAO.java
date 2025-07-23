package com.elearning.dao;

import com.elearning.models.Course;
import com.elearning.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private Connection connection;

    public CourseDAO() {
        connection = DBConnection.getConnection();
        if (connection == null) {
            throw new IllegalStateException("Database connection is not established.");
        }
    }

    public void createCourse(Course course) {
        String query = "INSERT INTO courses (title, description) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, course.getTitle());
            pstmt.setString(2, course.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating course", e);
        }
    }

    public Course getCourse(int id) {
        Course course = null;
        String query = "SELECT * FROM courses WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    course = new Course(rs.getInt("id"), rs.getString("title"), rs.getString("description"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching course", e);
        }
        return course;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Course course = new Course(rs.getInt("id"), rs.getString("title"), rs.getString("description"));
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching courses", e);
        }
        return courses;
    }

    public void updateCourse(Course course) {
        String query = "UPDATE courses SET title = ?, description = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, course.getTitle());
            pstmt.setString(2, course.getDescription());
            pstmt.setInt(3, course.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating course", e);
        }
    }

    public void deleteCourse(int id) {
        String query = "DELETE FROM courses WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting course", e);
        }
    }
}