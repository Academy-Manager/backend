package pt.upacademy.coreFinalProject.services.academyManager;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import pt.upacademy.coreFinalProject.controllers.core.UserController;
import pt.upacademy.coreFinalProject.models.academyManager.AccountAcademy;
import pt.upacademy.coreFinalProject.models.core.User;
import pt.upacademy.coreFinalProject.models.core.DTOS.UserDTO;
import pt.upacademy.coreFinalProject.repositories.academyManager.AccountRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;
import pt.upacademy.coreFinalProject.services.core.UserService;

@RequestScoped
public class AccountService extends EntityService<AccountRepository,AccountAcademy> {
	
	@Inject
	protected UserController userController;
	
	@Inject
	protected UserService userService;
	
	public Collection<AccountAcademy> getByUserRole(String role) {
		Collection<UserDTO> usersByRole = userController.getAdminFilter(null, role, null);
		Collection<Long> userIdsByRole = usersByRole.stream().map(user -> user.getId()).collect(Collectors.toList());
		return repository.getByUserIds(userIdsByRole);
	}
	
	public AccountAcademy getByUserId(long userId) {
		Optional<AccountAcademy> account = repository.getByUserId(userId).stream().findFirst();
		if (account.isPresent()) {
			return account.get();
		} else {
			//throw new IllegalArgumentException(String.format("Account with user id %d doesn't exist", userId));
			return null;
		}
	}
		
	public User getUserbyAccountId (long id) { //id da account
		AccountAcademy account = super.get(id);
		return userService.get(account.getUserId());
		
		
	}
	
}
