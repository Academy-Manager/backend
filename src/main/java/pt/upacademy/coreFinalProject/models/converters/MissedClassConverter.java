package pt.upacademy.coreFinalProject.models.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pt.upacademy.coreFinalProject.models.MissedClass;
import pt.upacademy.coreFinalProject.models.DTOS.MissedClassDTO;

public class MissedClassConverter extends EntityConverter<MissedClass,MissedClassDTO>{

	@Override
	public MissedClass toEntity(MissedClassDTO dto) {
		MissedClass mclass = new MissedClass();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		mclass.setId(dto.getId());
		mclass.setAccountId(dto.getAccountId());
		mclass.setJustified(dto.getJustified());
		if(dto.getData() != null) {
		LocalDate localDate1 = LocalDate.parse(dto.getData(),dateTimeFormatter);
		mclass.setData(localDate1);
		}
		return mclass;
	}

	@Override
	public MissedClassDTO toDTO(MissedClass entity) {
		MissedClassDTO mclass = new MissedClassDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		mclass.setId(entity.getId());
		mclass.setAccountId(entity.getAccountId());
		mclass.setJustified(entity.getJustified());
		if(entity.getData() != null) {
		String startDateString = entity.getData().format(formatter);
		mclass.setData(startDateString);
		}
		return mclass;
	}

}
