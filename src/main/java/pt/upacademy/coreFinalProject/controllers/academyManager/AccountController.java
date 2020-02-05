package pt.upacademy.coreFinalProject.controllers.academyManager;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.academyManager.AccountAcademy;
import pt.upacademy.coreFinalProject.models.academyManager.DTOS.AccountDTO;
import pt.upacademy.coreFinalProject.models.academyManager.converters.AccountConverter;
import pt.upacademy.coreFinalProject.models.core.DTOS.UserDTO;
import pt.upacademy.coreFinalProject.models.core.converters.UserConverter;
import pt.upacademy.coreFinalProject.repositories.academyManager.AccountRepository;
import pt.upacademy.coreFinalProject.services.academyManager.AccountService;

@Path("academy-manager/accounts")
@RequestScoped
public class AccountController extends EntityControllerDTO<AccountService,AccountRepository,AccountConverter,AccountAcademy,AccountDTO> {
	
	@Inject 
	protected UserConverter userConverter;
	
	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<AccountDTO> getByUserRole(@QueryParam("role") String role) {
		return service.getByUserRole(role).stream().map(account -> converter.toDTO(account)).collect(Collectors.toList());
	}
	
	@GET
	@Path("/user-id/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountDTO getByUserId(@PathParam("userId") long userId) {
		//try {
		AccountAcademy account = service.getByUserId(userId);
		if(account != null) {
			return converter.toDTO(service.getByUserId(userId));
		}
		return null;
//			return Response.status(200).entity(dto).build();
//		} catch (IllegalArgumentException e){
//			return Response.status(400).entity(e.getMessage()).build();
//		}
	}

	@GET
	@Path("/{id}/user")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getUser (@PathParam("id") long id) {	
		return userConverter.toDTO(service.getUserbyAccountId(id));
		
	}
	
}
