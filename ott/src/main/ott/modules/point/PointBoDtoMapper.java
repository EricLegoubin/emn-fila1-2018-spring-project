package main.ott.modules.point;

import main.ott.modules.base.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PointBoDtoMapper extends Mapper<PointBo, PointDto> {

	public PointBoDtoMapper() {
		super(PointBo.class, PointDto.class);
	}

}
