package pt.upacademy.coreFinalProject.models.academyManager.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pt.upacademy.coreFinalProject.models.academyManager.Declarations;
import pt.upacademy.coreFinalProject.models.academyManager.DTOS.DeclarationsDTO;
import pt.upacademy.coreFinalProject.models.core.converters.EntityConverter;

public class DeclarationsConverter extends EntityConverter<Declarations,DeclarationsDTO>{

	@Override
	public Declarations toEntity(DeclarationsDTO dto) {
		Declarations declarations = new Declarations();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		
		declarations.setId(dto.getId());
		declarations.setAccountIdSender(dto.getAccountIdSender());
		declarations.setAccountIdReceiver(dto.getAccountIdReceiver());
		
		if(dto.getDateSent() != null) {
	LocalDate localDate1 = LocalDate.parse(dto.getDateSent(),dateTimeFormatter);
		declarations.setDateSent(localDate1);
		}
//		else {localDate1 = null;}
		
		if(dto.getDateReceived() != null) {
			LocalDate localDate2 = LocalDate.parse(dto.getDateReceived(),dateTimeFormatter);
		declarations.setDateReceived(localDate2);
		}
//		else {localDate2 = null;}
		
		declarations.setFileUrlSent(dto.getFileUrlSent());
		declarations.setFileUrlReturned(dto.getFileUrlReturned());
		declarations.setVerified(dto.getVerified());
		return declarations;
	}

	@Override
	public DeclarationsDTO toDTO(Declarations entity) {
		DeclarationsDTO declarationsDTO = new DeclarationsDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		declarationsDTO.setId(entity.getId());
		declarationsDTO.setAccountIdReceiver(entity.getAccountIdReceiver());
		declarationsDTO.setAccountIdSender(entity.getAccountIdSender());
		
		if(entity.getDateSent() != null) {
		String sentDateString = entity.getDateSent().format(formatter);
		declarationsDTO.setDateSent(sentDateString);
		}
		if(entity.getDateReceived() != null) {
		String receivedDateString = entity.getDateReceived().format(formatter);
		declarationsDTO.setDateReceived(receivedDateString);
		}
		declarationsDTO.setFileUrlSent(entity.getFileUrlSent());
		declarationsDTO.setFileUrlReturned(entity.getFileUrlReturned());
		declarationsDTO.setVerified(entity.getVerified());
		return declarationsDTO;
	}

}
