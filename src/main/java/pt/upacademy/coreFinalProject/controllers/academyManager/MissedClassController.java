package pt.upacademy.coreFinalProject.controllers.academyManager;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.academyManager.MissedClass;
import pt.upacademy.coreFinalProject.models.academyManager.DTOS.MissedClassDTO;
import pt.upacademy.coreFinalProject.models.academyManager.converters.MissedClassConverter;
import pt.upacademy.coreFinalProject.repositories.academyManager.MissedClassRepository;
import pt.upacademy.coreFinalProject.services.academyManager.MissedClassService;

@Path("academy-manager/missed")
@RequestScoped
public class MissedClassController extends EntityControllerDTO<MissedClassService,MissedClassRepository,MissedClassConverter,MissedClass,MissedClassDTO>{

	@POST
	@Path("/m")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addMissedClass(MissedClassDTO mclass) {
		try {
			service.addMissedClass(converter.toEntity(mclass));
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400).entity(e.getMessage()).build(); 
		}
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Collection<MissedClassDTO> get() {
//		return service.get().stream().map(E -> converter.toDTO(E)).collect(Collectors.toList());
//	}
	
	@GET
	@Path("/account/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MissedClassDTO> getallbyId(@PathParam("id") int accountId) {
		return service.getAllMissedById(accountId).stream().map(E -> converter.toDTO(E)).collect(Collectors.toList());
	}
	
	@GET
	@Path("/date/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MissedClassDTO> getallbyId(@PathParam("date") long date) {
		return service.getAllMissedByDate(date).stream().map(E -> converter.toDTO(E)).collect(Collectors.toList());
	}
	
	@PUT
	@Path("/justify")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response update(MissedClassDTO mclass) {
		try {
			service.update(converter.toEntity(mclass));
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(400).entity(e.getMessage()).build(); 
		}
	}
	
//	addMissedClass
}
