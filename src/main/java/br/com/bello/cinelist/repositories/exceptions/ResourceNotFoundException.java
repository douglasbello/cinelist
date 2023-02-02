package br.com.bello.cinelist.repositories.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found " + id);
    }
    public ResourceNotFoundException(String username) {
        super("Resource not found = " + username);
    }
}
