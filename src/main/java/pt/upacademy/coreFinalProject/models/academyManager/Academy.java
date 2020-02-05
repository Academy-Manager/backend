package pt.upacademy.coreFinalProject.models.academyManager;

import java.time.LocalDate;
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
	@NamedQuery(name = Academy.GET_ALL_ACADEMIES, query = "SELECT a FROM Academy a")
})

public class Academy extends EntityRoot {
   
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_ACADEMIES = "getAllAcademies";
	
    private String client;
    private LocalDate startDate;
    private LocalDate endDate;
    private String edName;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Module> modules;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AccountAcademy> students;
    private Status status;
    private String warning;    		 //GONÇALO
    private String usefulInfo;       //GONÇALO
    private String academyType;		 //GONÇALO
    
    
    public Academy() {}
    
    public Academy(String client, LocalDate startDate, LocalDate endDate, String edName, 
    	Set<Module> modules, Set<AccountAcademy> students, Status status, String warning, String usefulInfo) {

		this.setClient(client);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setEdName(edName);
		this.setModules(modules);
		this.setStudents(students);
		this.setStatus(status);
		this.setWarning(warning);  			//GONÇALO
		this.setUsefulInfo(usefulInfo);		//GONÇALO
		this.setAcademyType(usefulInfo);    //GONÇALO
		
    }
    

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getEdName() {
		return edName;
	}

	public void setEdName(String edName) {
		this.edName = edName;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}


	public Set<AccountAcademy> getStudents() {
		return students;
	}

	public void setStudents(Set<AccountAcademy> students) {
		this.students = students;
	}

	public String getWarning() {
		return warning;
	}   //GONÇALO

	public void setWarning(String warning) {
		this.warning = warning;
	}   //GONÇALO

	public String getUsefulInfo() {
		return usefulInfo;
	}	//GONÇALO

	public void setUsefulInfo(String usefulInfo) {
		this.usefulInfo = usefulInfo;
	}	//GONÇALO

	public String getAcademyType() {
		return academyType;
	}	//GONÇALO

	public void setAcademyType(String academyType) {
		this.academyType = academyType;
	}	//GONÇALO

	@Override
	public String toString() {
		return "Academy [client=" + client + ", startDate=" + startDate + ", endDate=" + endDate + ", edName=" + edName
				+ ", modules=" + modules + ", students=" + students + ", status=" + status + ", warning=" + warning
				+ ", usefulInfo=" + usefulInfo + ", academyType=" + academyType + "]";
	}

}

	