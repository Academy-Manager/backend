package pt.upacademy.coreFinalProject.models.academyManager;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;

@Entity
@NamedQueries({
	@NamedQuery(name = Module.GET_ALL_MODULES, query = "SELECT m FROM Module m")
})

public class Module extends EntityRoot {
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_MODULES = "getAllModules";

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Evaluation> evaluation;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Theme> themes;
	private String name;
	private String evaluationSubjects;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<AccountAcademy> teachers;

	public Module() {}
	
	public Module(Set<Evaluation> evaluation, Set<Theme> themes, String name, String evaluationSubjects, Set<AccountAcademy> teachers) {
		this.evaluation = evaluation;
		this.themes = themes;
		this.name = name;
		this.evaluationSubjects = evaluationSubjects;
		this.teachers = teachers;
	}

	public Set<AccountAcademy> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<AccountAcademy> teachers) {
		this.teachers = teachers;
	}

	public Set<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Set<Evaluation> evaluation) {
		this.evaluation = evaluation;
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

	public String getEvaluationSubjects() {
		return evaluationSubjects;
	}

	public void setEvaluationSubjects(String evaluationSubjects) {
		this.evaluationSubjects = evaluationSubjects;
	}
}
