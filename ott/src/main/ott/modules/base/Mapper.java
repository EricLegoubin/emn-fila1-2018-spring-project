package main.ott.modules.base;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Mapper<T, E> {

   // private ModelMapper modelMapper = new ModelMapper();


    public abstract E bo2Dto(T bo);

    public abstract T dto2Bo(E dto);

    public List<E> listBo2Dto(List<T> listBo) {
        return listBo.stream().map(this::bo2Dto).collect(Collectors.toList());
    }

}
