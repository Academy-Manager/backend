package pt.upacademy.coreFinalProject.controllers.academyManager;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.academyManager.Academy;
import pt.upacademy.coreFinalProject.models.academyManager.DTOS.AcademyDTO;
import pt.upacademy.coreFinalProject.models.academyManager.converters.AcademyConverter;
import pt.upacademy.coreFinalProject.repositories.academyManager.AcademyRepository;
import pt.upacademy.coreFinalProject.services.academyManager.AcademyService;

@Path ("academy-manager/academies")
@RequestScoped
public class AcademyController extends EntityControllerDTO<AcademyService,AcademyRepository,AcademyConverter,Academy,AcademyDTO>{

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response update(AcademyDTO academy) {
		try {
		service.update(converter.toEntity(academy));
		return Response.ok().build();
		}
		catch (Exception e){
			e.printStackTrace();
			return Response.status(400).entity(e.getMessage()).build(); 
		}
		
	}
}
