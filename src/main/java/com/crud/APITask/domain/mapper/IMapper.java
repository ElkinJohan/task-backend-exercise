package com.crud.APITask.domain.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
