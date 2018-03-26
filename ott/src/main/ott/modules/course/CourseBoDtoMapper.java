package main.ott.modules.course;

import main.ott.modules.base.Mapper;
import main.ott.modules.passage.PassageBoDtoMapper;
import main.ott.modules.passage.PassageDto;
import main.ott.modules.sillon.SillonBoDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class CourseBoDtoMapper extends Mapper<CourseBo, CourseDto> {

    @Autowired
    PassageBoDtoMapper passageBoDtoMapper;
    @Autowired
    SillonBoDtoMapper sillonBoDtoMapper;

	@Override
	public CourseDto bo2Dto(CourseBo courseBo){

	    CourseDto dto = new CourseDto();
	    dto.setId(courseBo.getId());

	    dto.setComputedPassages(courseBo.getComputedPassages().stream().map(passageBo ->passageBoDtoMapper.bo2Dto(passageBo)).collect(Collectors.toList()));
	    dto.setIdTrain(courseBo.getIdTrain());
	    dto.setSillons(courseBo.getSillons().stream().map(sillonBo -> sillonBoDtoMapper.bo2Dto(sillonBo)).collect(Collectors.toSet()));

	    return dto;
    }

    @Override
    public CourseBo dto2Bo(CourseDto dto) {
        CourseBo courseBo = new CourseBo();
        courseBo.setComputedPassages(dto.getComputedPassages().stream().map(passageBoDtoMapper::dto2Bo).collect(Collectors.toSet()));
        courseBo.setIdTrain(dto.getIdTrain());
        courseBo.setId(dto.getId());
        courseBo.setSillons(dto.getSillons().stream().map(sillonBoDtoMapper::dto2Bo).collect(Collectors.toSet()));
        return courseBo;
    }
}
