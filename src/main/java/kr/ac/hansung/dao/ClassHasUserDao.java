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
     	String sqlStatement="SELECT B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor"
    			+ " FROM class AS B "
    			+ "WHERE B.class_name=? ";
    	return jdbcTemplate.queryForObject(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;
			}},new Object[] {className});
    }
    	public ClassHasUser getOneClassByCode(String classCode) {
    	String sqlStatement="SELECT B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor "
    			+ " FROM class AS B "
    			+ "WHERE B.class_code=?";
    	return jdbcTemplate.queryForObject(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;
			}},new Object[] {classCode});
    }
    	public List<ClassHasUser> getEnableClasses(String username) {
    		String sqlStatement="SELECT C.user_student_name,B.class_code,B.class_name,B.class_classification,B.class_degree,B.professor "
    				+ "        			FROM class AS B left OUTER JOIN	class_has_user AS C  "
    				+ "        			ON C.class_class_code=B.class_code "
    				+ "                    where (C.user_student_name is null or C.user_student_name!=?) And B.semester=1";
    		return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
    			@Override
    			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
    				// TODO Auto-generated method stub
    				ClassHasUser ClassHasUser= new ClassHasUser();
    				ClassHasUser.setUserName(username);
    				ClassHasUser.setSemester(1);
    				ClassHasUser.setClassCode(rs.getString("class_code"));
    				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
    				ClassHasUser.setClassName(rs.getString("class_name"));
    				ClassHasUser.setProfessor(rs.getString("professor"));
    				ClassHasUser.setClassClassification(rs.getString("class_classification"));
    				return ClassHasUser;
    			}},username);
    	}
    	public List<ClassHasUser> getLearnedClasses(String username) {
    	String sqlStatement="SELECT A.username,B.class_code,B.class_name,B.semester,B.class_classification,B.class_degree,B.professor,C.register_year "
    			+ "FROM users AS A "
    			+ "INNER JOIN	class_has_user AS C "
    			+ "ON A.username=C.user_student_name "
    			+ "INNER JOIN class AS B "
    			+ "ON C.class_class_code=B.class_code "
    			+ "WHERE C.user_student_name=? ";
    	return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setUserName(rs.getString("username"));
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
    	public List<ClassHasUser> getSemesterClasses(String username){
    	String sqlStatement="SELECT C.register_year,B.semester,SUM(B.class_degree) "
    			+ "FROM class AS B "
    			+ "INNER JOIN	class_has_user AS C  "
    			+ "ON C.class_class_code=B.class_code "
    			+ "WHERE C.user_student_name=?"
    			+ "GROUP BY C.register_year,B.semester "
    			+ "ORDER BY C.register_year ASC, B.semester ASC";
    	return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setUserName(username);
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setClassDegree(rs.getInt("SUM(B.class_degree)"));
				ClassHasUser.setRegisterYear(rs.getInt("register_year"));
	
				return ClassHasUser;
			}},username);
    }	
    	public List<ClassHasUser> getDetailClasses(String username,String year,String semester){
    		String sqlStatement="SELECT B.class_code,B.class_name,B.class_classification,B.class_degree,B.professor "
        			+ "FROM class AS B "
        			+ "INNER JOIN	class_has_user AS C  "
        			+ "ON C.class_class_code=B.class_code "
        			+ "WHERE C.user_student_name=? AND C.register_year=? AND B.semester=?";
        			
        	return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
    			@Override
    			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
    				// TODO Auto-generated method stub
    				ClassHasUser ClassHasUser= new ClassHasUser();
    				ClassHasUser.setUserName(username);
    				ClassHasUser.setSemester(Integer.parseInt(semester));
    				ClassHasUser.setClassCode(rs.getString("class_code"));
    				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
    				ClassHasUser.setClassName(rs.getString("class_name"));
    				ClassHasUser.setProfessor(rs.getString("professor"));
    				ClassHasUser.setClassClassification(rs.getString("class_classification"));
    				ClassHasUser.setRegisterYear(Integer.parseInt(year));
    	
    				return ClassHasUser;
    			}},username,year,semester);
    	}
    	public List<ClassHasUser> getAllClasses(){
    	String sqlStatement="SELECT class_code,class_name,semester,class_classification,class_degree,professor "
    			+ " FROM class ";
    	return jdbcTemplate.query(sqlStatement,new RowMapper<ClassHasUser>() {
			@Override
			public ClassHasUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ClassHasUser ClassHasUser= new ClassHasUser();
				ClassHasUser.setClassCode(rs.getString("class_code"));
				ClassHasUser.setClassName(rs.getString("class_name"));
				ClassHasUser.setClassDegree(rs.getInt("class_degree"));
				ClassHasUser.setProfessor(rs.getString("professor"));
				ClassHasUser.setSemester(rs.getInt("semester"));
				ClassHasUser.setClassClassification(rs.getString("class_classification"));
				return ClassHasUser;}});
    	}
    	 public boolean Insert(String username,ClassHasUser classHasUser) {
    	    	String name=username;
    	    	String code=classHasUser.getClassCode();
    	    	String className=classHasUser.getClassName();
    	    	int year=classHasUser.getRegisterYear();
    	    	year=2022;
    	    		String sqlStatement="insert into class_has_user (user_student_name,class_class_code,register_year) value (?,?,?)";
	    	    	return(jdbcTemplate.update(sqlStatement,new Object[]{name,code,year})==1);
    	    	
    	    	
    	    }
}
