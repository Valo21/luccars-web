package com.luccars.products.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("El registro solicitado no existe");
    }

    public EntityNotFoundException(String mensaje) {
        super(mensaje);
    }

}