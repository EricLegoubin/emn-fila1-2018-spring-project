package main.ott.modules.sillon;

import org.modelmapper.ModelMapper;

import main.ott.modules.sillon.SillonBo;
import main.ott.modules.sillon.SillonDto;

public class SillonBoDtoMapper {
	
private static ModelMapper modelMapper = new ModelMapper();
	
	public static SillonDto mapToDto(SillonBo p) {
		return modelMapper.map(p, SillonDto.class);
	}
	
	public static SillonBo mapToBo(SillonDto dto) {
		return modelMapper.map(dto, SillonBo.class);
	}
	
}
