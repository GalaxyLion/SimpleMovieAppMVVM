package com.example.simplemovieappmvvm.data.mappers;

public interface Mapper<F,M> {

    M from(F data);
    F to(M model);
}