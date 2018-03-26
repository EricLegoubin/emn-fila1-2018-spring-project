package main.ott.modules.point;

import main.ott.modules.base.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PointBoDtoMapper extends Mapper<PointBo, PointDto> {


	@Override
	public PointDto bo2Dto(PointBo bo) {

		PointDto pointDto = new PointDto();
		pointDto.setGare(bo.isGare());
		pointDto.setId(bo.getId());
		pointDto.setNom(bo.getNom());
		return pointDto;
	}

	@Override
	public PointBo dto2Bo(PointDto dto) {
		return null;
	}
}
