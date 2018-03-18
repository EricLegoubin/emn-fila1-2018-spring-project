package main.ott.mapper;

import java.util.HashSet;
import java.util.Set;

import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointBoDtoMapper;
import main.ott.modules.point.PointDto;
import main.ott.modules.sillon.SillonBo;
import main.ott.modules.sillon.SillonBoDtoMapper;
import main.ott.modules.sillon.SillonDto;

public class TestMapper {

	public static void main(String[] args) {
		Long id = new Long(55555);
		String nom = "Gare du nord";
		PointBo point = new PointBo(id, nom);
		
		PointDto dto = PointBoDtoMapper.mapToDto(point);
		
		System.out.println("Expected : "+point.getId()+", actual : "+dto.getId());
		System.out.println("Expected : "+point.getNom()+", actual : "+dto.getNom());
		
		Set<PointBo> points = new HashSet<>();
		points.add(new PointBo(1L, "Bordeaux"));
		points.add(new PointBo(2L, "Marseille"));
		points.add(new PointBo(3L, "Paris"));
		points.add(new PointBo(4L, "Autogrill"));
		
		SillonBo sillonBo = new SillonBo(1L, points);
		System.out.println("Le SillonBo");
		for(PointBo p : sillonBo.getPoints()) {
			System.out.println(p);
		}
		
		SillonDto sillonDto = SillonBoDtoMapper.mapToDto(sillonBo);
		System.out.println("Le SillonDtoMap");
		for(PointDto d : sillonDto.getPoints()) {
			System.out.println(d);
		}
		
		SillonBo sillonBo2 = SillonBoDtoMapper.mapToBo(sillonDto);
		System.out.println("Le SillonBoMap");
		for(PointBo p : sillonBo2.getPoints()) {
			System.out.println(p);
		}

	}

}
