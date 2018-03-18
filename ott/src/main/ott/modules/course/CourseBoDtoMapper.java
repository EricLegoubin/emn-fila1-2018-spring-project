package main.ott.modules.course;

import org.modelmapper.ModelMapper;

import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseDto;

public class CourseBoDtoMapper {
	
private static ModelMapper modelMapper = new ModelMapper();
	
	public static CourseDto mapToDto(CourseBo p) {
		return modelMapper.map(p, CourseDto.class);
	}
	
	public static CourseBo mapToBo(CourseDto dto) {
		return modelMapper.map(dto, CourseBo.class);
	}
	
}
