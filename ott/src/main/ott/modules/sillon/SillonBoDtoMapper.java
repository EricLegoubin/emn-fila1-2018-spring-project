package main.ott.modules.sillon;

import main.ott.modules.base.Mapper;
import org.springframework.stereotype.Component;

@Component
public class SillonBoDtoMapper extends Mapper<SillonBo, SillonDto> {

	public SillonBoDtoMapper() {
		super(SillonBo.class, SillonDto.class);
	}

}
