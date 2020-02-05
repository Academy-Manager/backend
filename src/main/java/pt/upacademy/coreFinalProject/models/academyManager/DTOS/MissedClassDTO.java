package pt.upacademy.coreFinalProject.models.academyManager.DTOS;

import pt.upacademy.coreFinalProject.models.core.DTOS.EntityDTO;

public class MissedClassDTO extends EntityDTO {

	private int accountId;
	private long date;
	private Boolean justified;
	private String verifyDaily;
	
	

	public String getVerifyDaily() {
		return verifyDaily;
	}
	public void setVerifyDaily(String verifyDaily) {
		this.verifyDaily = verifyDaily;
	}
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
	public MissedClassDTO(int accountId, long date, Boolean justified, String verifyDaily) {
		super();
		this.accountId = accountId;
		this.date = date;
		this.justified = justified;
		this.verifyDaily = verifyDaily;
	}
	@Override
	public String toString() {
		return "MissedClassDTO [accountId=" + accountId + ", date=" + date + ", justified=" + justified
				+ ", verifyDaily=" + verifyDaily + "]";
	}
	
	

	
	
}
