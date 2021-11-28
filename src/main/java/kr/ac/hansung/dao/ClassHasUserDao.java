package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hanung.model.ClassHasUser;

@Repository("classHasUserDao")
public class ClassHasUserDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public int getRowCount() {
    	String sqlStatement="select count(*) from class_has_user";
    	return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }
    public ClassHasUser getOneClassByName(String className) {
     	String sqlStatement="SELECT A.student_name,B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor,C.register_year"
    			+ "FROM user AS A"
    			+ "INNER JOIN	class_has_user AS C"
    			+ "ON A.student_name=C.user_student_name"
    			+ "INNER JOIN class AS B"
    			+ "ON C.class_class_code=B.class_code"
    			+ "WHERE B.class_name=?";
    	return jdbcTemplate.queryForObject(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setUserName(rs.getString("student_name"));
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setRegisterYear(rs.getInt("register_year"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;
			}},new Object[] {className});
    }
    public ClassHasUser getOneClassByCode(String classCode) {
    	String sqlStatement="SELECT A.student_name,B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor,C.register_year"
    			+ "FROM user AS A"
    			+ "INNER JOIN	class_has_user AS C"
    			+ "ON A.student_name=C.user_student_name"
    			+ "INNER JOIN class AS B"
    			+ "ON C.class_class_code=B.class_code"
    			+ "WHERE C.class_class_code=?";
    	return jdbcTemplate.queryForObject(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setUserName(rs.getString("student_name"));
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setRegisterYear(rs.getInt("register_year"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;
			}},new Object[] {classCode});
    }

    public List<ClassHasUser> getLearnedClasses(String username) {
    	String sqlStatement="SELECT A.student_name,B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor,C.register_year"
    			+ "FROM user AS A"
    			+ "INNER JOIN	class_has_user AS C"
    			+ "ON A.student_name=C.user_student_name"
    			+ "INNER JOIN class AS B"
    			+ "ON C.class_class_code=B.class_code"
    			+ "WHERE C.user_student_name=?";
    	return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setUserName(rs.getString("student_name"));
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setRegisterYear(rs.getInt("register_year"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;
			}},username);
    }
    public List<ClassHasUser> getAllClasses(){
    	String sqlStatement="SELECT B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor"
    			+ "FROM class AS B";
    	return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setUserName(rs.getString("student_name"));
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setRegisterYear(rs.getInt("register_year"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;}});
    }
}
