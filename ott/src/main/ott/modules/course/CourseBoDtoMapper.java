package main.ott.modules.course;

import main.ott.modules.base.Mapper;
import org.modelmapper.ModelMapper;

import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseDto;

public class CourseBoDtoMapper extends Mapper<CourseBo, CourseDto> {

	public CourseBoDtoMapper() {
		super(CourseBo.class, CourseDto.class);
	}
}
