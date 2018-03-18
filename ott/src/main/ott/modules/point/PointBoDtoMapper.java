package main.ott.modules.point;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PointBoDtoMapper {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static PointDto mapToDto(PointBo p) {
		return modelMapper.map(p, PointDto.class);
	}
	
	public static PointBo mapToBo(PointDto dto) {
		return modelMapper.map(dto, PointBo.class);
	}

}
