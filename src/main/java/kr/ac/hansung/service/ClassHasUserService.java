package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ClassHasUserDao;
import kr.ac.hanung.model.ClassHasUser;

@Service
public class ClassHasUserService {
	@Autowired
	private ClassHasUserDao classHasUserDao ;
	
	public ClassHasUser getClassbyName(String username){
		return classHasUserDao.getOneClassByName(username);
	}
	public ClassHasUser getClassbyCode(String code) {
		return classHasUserDao.getOneClassByCode(code);
	}
	public List<ClassHasUser> getAllClasses(){
		return classHasUserDao.getAllClasses();
	}
	public List<ClassHasUser> getLearnedClasses(String username){
		return classHasUserDao.getLearnedClasses(username);
		
	}

}
