package com.luccars.users.exceptions;

public class UnsavedEntityException extends RuntimeException {

    public UnsavedEntityException() {
        super("Se produjo un error inesperado al intentar guardar el registro");
    }

    public UnsavedEntityException(String mensaje) {
        super(mensaje);
    }

}