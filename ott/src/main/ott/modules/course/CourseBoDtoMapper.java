package main.ott.modules.course;

import main.ott.modules.base.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseBoDtoMapper extends Mapper<CourseBo, CourseDto> {

	public CourseBoDtoMapper() {
		super(CourseBo.class, CourseDto.class);
	}

}
