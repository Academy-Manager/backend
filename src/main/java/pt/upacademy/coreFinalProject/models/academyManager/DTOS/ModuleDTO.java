package pt.upacademy.coreFinalProject.models.academyManager.DTOS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pt.upacademy.coreFinalProject.models.academyManager.Theme;
import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;

public class ModuleDTO extends EntityDTO {

	private List<Long> evaluationIds = new ArrayList<Long>();
	private Set<Theme> themes = new HashSet<Theme>();
	private String name;
	private List<Long> teacherIds= new ArrayList<Long>();
	private String evaluationSubjects;
	
	public ModuleDTO() {}

	public ModuleDTO(List<Long> evaluationIds, Set<Theme> themes, String name, List<Long> teacherIds, String evaluationSubjects) {
		this.evaluationIds = evaluationIds;
		this.themes = themes;
		this.name = name;
		this.teacherIds = teacherIds;
		this.evaluationSubjects = evaluationSubjects;
	}

	public String getEvaluationSubjects() {
		return evaluationSubjects;
	}

	public void setEvaluationSubjects(String evaluationSubjects) {
		this.evaluationSubjects = evaluationSubjects;
	}

	public List<Long> getEvaluationIds() {
		return evaluationIds;
	}

	public void setEvaluationIds(List<Long> evaluationIds) {
		this.evaluationIds = evaluationIds;
	}

	public Set<Theme> getThemes() {
		return themes;
	}

	public void setThemes(Set<Theme> themes) {
		this.themes = themes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getTeacherIds() {
		return teacherIds;
	}

	public void setTeacherIds(List<Long> teacherIds) {
		this.teacherIds = teacherIds;
	}

	

}
