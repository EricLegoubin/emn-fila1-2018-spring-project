package main.ott.mapper;

public abstract class AbstractMapper<T,E> {

    public abstract E bo2Dto(T bo);

    public abstract T dto2Bo(E Dto);

}
