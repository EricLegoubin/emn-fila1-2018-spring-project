package com.emn.GEO.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.emn.GEO.domain.Passage;
import com.emn.GEO.service.dto.PassageDTO;

public class PassageMapper {

	public PassageDTO passageToPassageDTO(Passage passage)
	{
		return new PassageDTO(passage.getPoi().getId(), passage.getTime(), passage.getCourse().getId());
	}
	
	public List<PassageDTO> passageToPassageDTO(List<Passage> passages)
	{
		List<PassageDTO> toReturn = new ArrayList<>();
		passages.forEach((passage)-> {
			toReturn.add(passageToPassageDTO(passage));
		});
		return toReturn;
	}
	
}
