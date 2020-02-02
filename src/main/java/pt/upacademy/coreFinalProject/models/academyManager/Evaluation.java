package pt.upacademy.coreFinalProject.models.academyManager;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;

@Entity
@NamedQueries({
	@NamedQuery(name = Evaluation.GET_ALL_EVALUATIONS, query = "SELECT e FROM Evaluation e")
})		

public class Evaluation extends EntityRoot {
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_EVALUATIONS = "getAllEvaluations";

	@ManyToOne
	private AccountAcademy account;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@OrderBy("sdgsdg")
	private Set<Grade> grades;
	private String comment;
	
	public Evaluation() {}
	
	public Evaluation(AccountAcademy account, Set<Grade> grades, String comment) {
		this.account = account;
		this.grades = grades;
		this.comment = comment;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public AccountAcademy getAccount() {
		return account;
	}

	public void setAccount(AccountAcademy account) {
		this.account = account;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
