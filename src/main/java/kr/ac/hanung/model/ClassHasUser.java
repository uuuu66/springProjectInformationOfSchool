package kr.ac.hanung.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClassHasUser {

	@NotEmpty(message="no empty")
	private String classCode;
	@NotEmpty(message="no empty")
	private String userName;
	private int registerYear;
	private String className;
	private int semester;
	private String classClassification;
	private String professor;
	private int classDegree;
}
