package main.ott.modules.sillon;

import main.ott.modules.base.Mapper;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointDto;
import org.modelmapper.ModelMapper;

import main.ott.modules.sillon.SillonBo;
import main.ott.modules.sillon.SillonDto;

public class SillonBoDtoMapper extends Mapper<SillonBo, SillonDto> {

	public SillonBoDtoMapper() {
		super(SillonBo.class, SillonDto.class);
	}
}
