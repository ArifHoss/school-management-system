package org.arif.initializer;

import org.arif.Database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void init(){
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE student (id IDENTITY PRIMARY KEY, name VARCHAR(100), email VARCHAR(100));");
            stmt.execute("CREATE TABLE course (id IDENTITY PRIMARY KEY, title VARCHAR(100), description VARCHAR(255));");
            stmt.execute("CREATE TABLE enrollment (" +
                    "id IDENTITY PRIMARY KEY," +
                    "student_id BIGINT," +
                    "course_id BIGINT," +
                    "enrollment_date DATE," +
                    "FOREIGN KEY (student_id) REFERENCES student(id)," +
                    "FOREIGN KEY (course_id) REFERENCES course(id));");

            System.out.println("Database initialized.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
