package com.myproject.orders.infrastructure.dto;

public abstract class Mapper <DTO, DOMAIN>  {

    public abstract DTO toDto(DOMAIN domainObject);
    public abstract DOMAIN toDomain(DTO dtoObject);
}
