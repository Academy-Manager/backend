package pt.upacademy.coreFinalProject.models.academyManager.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.academyManager.Academy;
import pt.upacademy.coreFinalProject.models.academyManager.DTOS.AcademyDTO;
import pt.upacademy.coreFinalProject.models.core.converters.EntityConverter;
import pt.upacademy.coreFinalProject.services.academyManager.AccountService;
import pt.upacademy.coreFinalProject.services.academyManager.ModuleService;

public class AcademyConverter extends EntityConverter<Academy, AcademyDTO> {
	
	@Inject
	protected ModuleConverter moduleConverter;
	
	@Inject
	protected ModuleService moduleService;
	
	@Inject
	protected AccountService accountService;
	
	@Override
	public Academy toEntity(AcademyDTO dto) {
		Academy academy = new Academy();
		academy.setId(dto.getId());
		academy.setClient(dto.getClient());
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(dto.getStartDate() != null) {
		LocalDate localDate = LocalDate.parse(dto.getStartDate(),dateTimeFormatter);
		academy.setStartDate(localDate);
		}
		if(dto.getEndDate() != null) {
		LocalDate localDate1 = LocalDate.parse(dto.getEndDate(),dateTimeFormatter);
		academy.setEndDate(localDate1);
		}
		academy.setEdName(dto.getEdName());
		academy.setModules(dto.getModuleDTOs().stream().map(moduleDto -> moduleConverter.toEntity(moduleDto)).collect(Collectors.toSet()));
		academy.setStudents(dto.getStudentsIds().stream().map(studentId -> accountService.get(studentId)).collect(Collectors.toSet()));
		academy.setStatus(dto.getStatus());
		academy.setWarning(dto.getWarning());  		  		 //GONCALO
		academy.setUsefulInfo(dto.getUsefulInfo());   		 //GONCALO
		academy.setAcademyType(dto.getAcademyType());  		 //GONCALO
		return academy;
		
		
	}

	@Override
	public AcademyDTO toDTO(Academy entity) {
		AcademyDTO academyDTO = new AcademyDTO();
		academyDTO.setId(entity.getId());
		academyDTO.setClient(entity.getClient());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(entity.getStartDate() != null) {
		String startDateString = entity.getStartDate().format(formatter);
		academyDTO.setStartDate (startDateString);
		}
		if(entity.getEndDate() != null) {
		String endDateString = entity.getEndDate().format(formatter);
		academyDTO.setEndDate(endDateString);
		}
		academyDTO.setEdName(entity.getEdName());
		academyDTO.setStatus(entity.getStatus());
		academyDTO.setModuleDTOs(entity.getModules().stream().map(module -> moduleConverter.toDTO(module)).collect(Collectors.toSet()));
		academyDTO.setStudentsIds(entity.getStudents().stream().map(student -> student.getId()).collect(Collectors.toList()));
		academyDTO.setWarning(entity.getWarning());  		 	//GONCALO
		academyDTO.setUsefulInfo(entity.getUsefulInfo());     	//GONCALO
		academyDTO.setAcademyType(entity.getAcademyType());	  	//GONCALO
		return academyDTO;
		
	
	}

}
