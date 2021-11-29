package kr.ac.hanung.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClassHasUser {

	
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="no 특수문자")
	private String classCode;
	
	private String userName;
	private int registerYear;
	private String className;
	private int semester;
	private String classClassification;
	private String professor;
	private int classDegree;
}
