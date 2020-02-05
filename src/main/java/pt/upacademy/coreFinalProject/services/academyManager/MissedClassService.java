package pt.upacademy.coreFinalProject.services.academyManager;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.upacademy.coreFinalProject.models.academyManager.MissedClass;
import pt.upacademy.coreFinalProject.repositories.academyManager.MissedClassRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;

@RequestScoped
public class MissedClassService extends EntityService<MissedClassRepository,MissedClass>{

	
	public void addMissedClass(MissedClass mclass) {
		repository.addEntity(mclass);
	}

	public List<MissedClass> getAllMissedById(int accountId) {
		return repository.getAllMissedById(accountId);
	}
	
	public List<MissedClass> getAllMissedByDate(String verifyDaily) {
		return repository.getAllMissedByDate(verifyDaily);
	}
	
}
