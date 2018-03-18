package main.ott.mapper;

import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointBoDtoMapper;
import main.ott.modules.point.PointDto;

public class TestMapper {

	public static void main(String[] args) {
		Long id = new Long(55555);
		String nom = "Gare du nord";
		PointBo p = new PointBo(id, nom);
		
		PointDto dto = PointBoDtoMapper.mapToDto(p);
		
		System.out.println("Expected : "+p.getId()+", actual : "+dto.getId());
		System.out.println("Expected : "+p.getNom()+", actual : "+dto.getNom());

	}

}
