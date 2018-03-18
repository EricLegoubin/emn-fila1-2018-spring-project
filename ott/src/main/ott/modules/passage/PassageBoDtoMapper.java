package main.ott.modules.passage;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PassageBoDtoMapper {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static PassageDto mapToDto(PassageBo p) {
		return modelMapper.map(p, PassageDto.class);
	}
	
	public static PassageBo mapToBo(PassageDto dto) {
		return modelMapper.map(dto, PassageBo.class);
	}

}
