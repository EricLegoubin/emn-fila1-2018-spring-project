package main.ott.modules.passage;

import main.ott.modules.base.Mapper;
import main.ott.modules.course.CourseBoDtoMapper;
import main.ott.modules.point.PointBoDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassageBoDtoMapper extends Mapper<PassageBo, PassageDto> {

	@Autowired
	private PointBoDtoMapper pointBoDtoMapper;



	@Override
	public PassageDto bo2Dto(PassageBo bo) {
		PassageDto dto = new PassageDto();
		dto.setPoint(pointBoDtoMapper.bo2Dto(bo.getPoint()));
		dto.setTimestamp(bo.getTimestamp());
		return dto;
	}

	@Override
	public PassageBo dto2Bo(PassageDto dto) {
		PassageBo passageBo = new PassageBo();

		passageBo.setPoint(pointBoDtoMapper.dto2Bo(dto.getPoint()));
		passageBo.setTimestamp(dto.getTimestamp());

		return passageBo;
	}
}
