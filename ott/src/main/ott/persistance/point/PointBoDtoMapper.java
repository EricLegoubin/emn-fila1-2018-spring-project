package main.ott.persistance.point;

import org.modelmapper.ModelMapper;

import main.ott.persistance.Point;

public class PointBoDtoMapper {
	
	public static PointDto map(Point p) {
		ModelMapper modelMapper = new ModelMapper();
		PointDto dto = modelMapper.map(p, PointDto.class);
		return dto;
	}
}
