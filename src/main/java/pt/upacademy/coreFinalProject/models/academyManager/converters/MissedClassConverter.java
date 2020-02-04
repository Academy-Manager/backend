package pt.upacademy.coreFinalProject.models.academyManager.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pt.upacademy.coreFinalProject.models.academyManager.MissedClass;
import pt.upacademy.coreFinalProject.models.academyManager.DTOS.MissedClassDTO;
import pt.upacademy.coreFinalProject.models.core.converters.EntityConverter;

public class MissedClassConverter extends EntityConverter<MissedClass,MissedClassDTO>{

	@Override
	public MissedClass toEntity(MissedClassDTO dto) {
		MissedClass mclass = new MissedClass();
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		mclass.setId(dto.getId());
		mclass.setAccountId(dto.getAccountId());
		mclass.setJustified(dto.getJustified());
//		if(dto.getData() != null) {
//		LocalDate localDate1 = LocalDate.parse(dto.getData(),dateTimeFormatter);
		mclass.setDate(dto.getDate());
//		}
		return mclass;
	}

	@Override
	public MissedClassDTO toDTO(MissedClass entity) {
		MissedClassDTO mclass = new MissedClassDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		mclass.setId(entity.getId());
		mclass.setAccountId(entity.getAccountId());
		mclass.setJustified(entity.getJustified());
//		if(entity.getData() != null) {
//		String startDateString = entity.getData().format(formatter);
		mclass.setDate(entity.getDate());
//		}
		return mclass;
	}

}
