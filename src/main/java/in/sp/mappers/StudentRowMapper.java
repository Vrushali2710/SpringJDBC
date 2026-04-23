package in.sp.mappers;

import in.sp.beans.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student std = new Student();
        std.setRollNo(rs.getInt("id"));
        std.setName(rs.getString("name"));
        std.setMarks(rs.getFloat("marks"));
        return std;
    }
}
