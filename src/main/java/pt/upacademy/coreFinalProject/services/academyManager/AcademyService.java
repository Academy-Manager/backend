package pt.upacademy.coreFinalProject.services.academyManager;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.academyManager.Academy;
import pt.upacademy.coreFinalProject.models.academyManager.AccountAcademy;
import pt.upacademy.coreFinalProject.repositories.academyManager.AcademyRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;

@RequestScoped
public class AcademyService extends EntityService<AcademyRepository, Academy> {

	@Inject
	protected AccountService acservice;

	public void update(Academy academy) {
		Set<AccountAcademy> ids = academy.getStudents();

		for (AccountAcademy s : ids) {
			Set<Academy> temp = s.getAcademies();
			if (!s.getAcademies().contains(repository.getEntity(academy.getId()))) {
				temp.add(repository.getEntity(academy.getId()));
				s.setAcademies(temp);
				acservice.update(s);
			}
		}
		repository.editEntity(academy);

	}
}
