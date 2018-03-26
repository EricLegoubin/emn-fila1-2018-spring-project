package main.ott.modules.base;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T, E> {

   // private ModelMapper modelMapper = new ModelMapper();


    public abstract E bo2Dto(T bo);

    public abstract T dto2Bo(E dto);

    public List<E> listBo2Dto(List<T> listBo) {
        List<E> listDto = new ArrayList<>(listBo.size());
        for (T bo : listBo) {
            listDto.add(this.bo2Dto(bo));
        }
        return listDto;
    }

}
