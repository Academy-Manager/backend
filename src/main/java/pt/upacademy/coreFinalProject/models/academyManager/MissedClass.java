package pt.upacademy.coreFinalProject.models.academyManager;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;


@Entity
@NamedQueries({
	@NamedQuery(name = MissedClass.GET_ALL_MISSEDCLASSES_BY_ID, query = "SELECT m FROM MissedClass m WHERE m.accountId = :accountId"),
	@NamedQuery(name = MissedClass.GET_ALL_MISSEDCLASSES_BY_DATE, query = "SELECT m FROM MissedClass m WHERE m.date = :date")	
})
public class MissedClass extends EntityRoot {
	
	private static final long serialVersionUID = 1L;
	
	
	public static final String GET_ALL_MISSEDCLASSES_BY_ID = "getAllMissedClassesById";
	public static final String GET_ALL_MISSEDCLASSES_BY_DATE = "getAllMissedClassesByDate";
	
	private int accountId;
	private long date;
	private Boolean justified;
	

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public Boolean getJustified() {
		return justified;
	}
	public void setJustified(Boolean justified) {
		this.justified = justified;
	}
	
	
	
	public MissedClass() {
		super();
	}
	public MissedClass(int userId, long date, Boolean justified) {
		super();
		this.accountId = userId;
		this.date = date;
		this.justified = justified;
	}
	
	
}
