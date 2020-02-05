package pt.upacademy.coreFinalProject.models.academyManager.DTOS;

import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;

public class MissedClassDTO extends EntityDTO {

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
	
	
	
	public MissedClassDTO() {
		super();
	}
	
	
	public MissedClassDTO(int userId, long date, Boolean justified) {
		super();
		this.accountId = userId;
		this.date = date;
		this.justified = justified;
	}
	@Override
	public String toString() {
		return "MissedClassDTO [userId=" + accountId + ", data=" + date + ", justified=" + justified + "]";
	}
	
	
	
}
