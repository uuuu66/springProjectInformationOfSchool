package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import kr.ac.hansung.service.ClassHasUserService;
import kr.ac.hanung.model.ClassHasUser;

@Controller
public class ClassController {
	@Autowired
	ClassHasUserService CHUService=new ClassHasUserService();
//	@RequestMapping("/information")
//	public String getAllClasses(Model model) {
//		List<ClassHasUser> classes=CHUService.getAllClasses();
//		model.addAttribute("allClasses", classes);
//		return "information";
//	}
	@RequestMapping("/information")
	public String getAll(Authentication auth,Model model) {
		String username=auth.getName();
		List<ClassHasUser> classes=CHUService.getSemesterClasses(username);
		model.addAttribute("username",username);
		model.addAttribute("allClasses", classes);
		return "information";
	}
	@RequestMapping("/getDetailView")
	public String getDetailView(@RequestParam(value="year")String year,@RequestParam(value="semester") String semester,Authentication auth,Model model) {
		String username=auth.getName();
		List<ClassHasUser> classes=CHUService.getDetailSemesterClasses(username, year, semester);
		model.addAttribute("allClasses", classes);
		model.addAttribute("year",year);
		model.addAttribute("semester",semester);
		return "getDetailView";
	}
	@RequestMapping("/register")
	public String Register(Authentication auth,Model model) {
		String username=auth.getName();
		model.addAttribute("classHasUser",new ClassHasUser());
		List<ClassHasUser> classes=CHUService.getEnableClasses(username);
		model.addAttribute("allClasses", classes);
		model.addAttribute("year","2022");
		model.addAttribute("semester","1");
		return "register";
	}
	@RequestMapping("/registered")
	public String Registered(Authentication auth,Model model) {
		String username=auth.getName();
		
		List<ClassHasUser> classes=CHUService.getDetailSemesterClasses(username, "2022","1");
		model.addAttribute("allClasses", classes);
		return "registered";
	}
	@RequestMapping("/doRegister")
	public String doRegister(Authentication auth,Model model,@Valid ClassHasUser classHasUser,BindingResult result) {
		String username=auth.getName();
		if(result.hasErrors()) {
			List<ClassHasUser> classes=CHUService.getEnableClasses(username);
			model.addAttribute("allClasses", classes);
			model.addAttribute("year","2022");
			model.addAttribute("semester","1");
			return "register";
		}else {
			try {
				CHUService.insert(username,classHasUser);
				List<ClassHasUser> classes=CHUService.getDetailSemesterClasses(username, "2022","1");
				model.addAttribute("allClasses", classes);
				return "registered";
			}catch(Exception e) {
				System.out.println(e);
				model.addAttribute("errorMsg","디비 에러");
				List<ClassHasUser> classes=CHUService.getEnableClasses(username);
				model.addAttribute("allClasses", classes);
				model.addAttribute("year","2022");
				model.addAttribute("semester","1");
				return "register";
			}
			
		}
	}
}
