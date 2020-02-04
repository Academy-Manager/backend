package pt.upacademy.coreFinalProject.repositories.academyManager;

import java.util.List;

import javax.persistence.TypedQuery;

import pt.upacademy.coreFinalProject.models.academyManager.MissedClass;
import pt.upacademy.coreFinalProject.repositories.core.EntityRepository;

public class MissedClassRepository extends EntityRepository<MissedClass> {

	@Override
	protected Class<MissedClass> getEntityClass() {
		return MissedClass.class;
	}

	@Override
	protected String getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	protected String getAllMissedClassesById() {
//		return MissedClass.GET_ALL_MISSEDCLASSES_BY_ID;
//	}

	public List<MissedClass> getAllMissedById(int accountId) {

		return entityManager.createNamedQuery(MissedClass.GET_ALL_MISSEDCLASSES_BY_ID, getEntityClass()).setParameter("accountId", accountId).getResultList();
	}

	public List<MissedClass> getAllMissedByDate(long date) {
		TypedQuery<MissedClass> query = entityManager.createQuery(" select m FROM MissedClass m where m.date LIKE :searchKeyword",getEntityClass());
		return query.setParameter("searchKeyword", date+"%").getResultList();
				
//		return entityManager.createNamedQuery(MissedClass.GET_ALL_MISSEDCLASSES_BY_DATE, getEntityClass()).setParameter("date", date).getResultList();
	}

	
	
}
