package main.ott.modules.sillon;

import main.ott.modules.base.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SillonBoDtoMapper extends Mapper<SillonBo, SillonDto> {
	
	private ModelMapper mapper;

	public SillonBoDtoMapper() {
		mapper = new ModelMapper();
	}
	@Override
	public SillonDto bo2Dto(SillonBo bo) {
		return mapper.map(bo, SillonDto.class);
	}

	@Override
	public SillonBo dto2Bo(SillonDto dto) {
		return mapper.map(dto, SillonBo.class);
	}

}
