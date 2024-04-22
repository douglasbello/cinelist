package br.com.douglasbello.cinelist.exceptions;

public class ResourceNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFound(String id) {
        super("Entity not found with id: " + id);
    }
}