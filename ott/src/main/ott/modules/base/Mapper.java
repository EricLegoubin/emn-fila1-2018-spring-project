package main.ott.modules.base;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Mapper<T, E> {

    private ModelMapper modelMapper = new ModelMapper();

    private Class<T> boClass;
    private Class<E> dtoClass;

    public Mapper(Class<T> boClass, Class<E> dtoClass) {
        this.boClass = boClass;
        this.dtoClass = dtoClass;
    }

    public E bo2Dto(T bo) {
        return modelMapper.map(bo, dtoClass);
    }

    public T dto2Bo(E dto) {
        return modelMapper.map(dto, boClass);
    }

    public List<E> listBo2Dto(List<T> listBo) {
        return listBo.stream().map(this::bo2Dto).collect(Collectors.toList());
    }

}
