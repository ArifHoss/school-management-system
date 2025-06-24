package org.arif.dto;

import org.arif.Database;
import org.arif.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDto {
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (name, email) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.executeUpdate();
        }
    }
}
