package com.example.core.domain;

public interface Mapper<From, To> {

    To map(From object);

}