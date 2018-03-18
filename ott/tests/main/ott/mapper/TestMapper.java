package main.ott.mapper;

import main.ott.persistance.Point;
import main.ott.persistance.point.PointBoDtoMapper;
import main.ott.persistance.point.PointDto;

public class TestMapper {

	public static void main(String[] args) {
		Long id = new Long(55555);
		String nom = "Gare du nord";
		Point p = new Point(id, nom);
		
		PointDto dto = PointBoDtoMapper.map(p);
		
		System.out.println("Expected : "+p.getId()+", actual : "+dto.getId());
		System.out.println("Expected : "+p.getNom()+", actual : "+dto.getNom());

	}

}
