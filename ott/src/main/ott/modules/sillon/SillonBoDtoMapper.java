package main.ott.modules.sillon;

import main.ott.modules.base.Mapper;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.passage.PassageDto;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointBoDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SillonBoDtoMapper extends Mapper<SillonBo, SillonDto> {
	
	@Autowired
	private SillonBoDtoMapper sillonBoDtoMapper;

	@Override
	public SillonDto bo2Dto(SillonBo bo) {
		SillonDto dto = new SillonDto();
		dto.setId(bo.getId());
		PointBoDtoMapper pmapper = new PointBoDtoMapper();
		dto.setPoints(bo.getPoints().stream().map(pointBo -> pmapper.bo2Dto(pointBo)).collect(Collectors.toSet()));
		return dto;
	}

	@Override
	public SillonBo dto2Bo(SillonDto dto) {
		SillonBo bo = new SillonBo();
		bo.setId(dto.getId());
		PointBoDtoMapper pmapper = new PointBoDtoMapper();
		bo.setPoints(dto.getPoints().stream().map(pointBo -> pmapper.dto2Bo(pointBo)).collect(Collectors.toSet()));
		return bo;
	}
	

}
