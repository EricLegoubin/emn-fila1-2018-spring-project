package main.ott.modules.point;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PointBoDtoMapper {
	
	public PointDto map(PointBo p) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(p, PointDto.class);
	}

}
