package main.ott.modules.passage;

import main.ott.modules.base.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PassageBoDtoMapper extends Mapper<PassageBo, PassageDto> {

	public PassageBoDtoMapper() {
		super(PassageBo.class, PassageDto.class);
	}

}
