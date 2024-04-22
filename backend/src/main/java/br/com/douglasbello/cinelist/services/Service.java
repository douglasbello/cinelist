package br.com.douglasbello.cinelist.services;

import br.com.douglasbello.cinelist.exceptions.ResourceNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface Service<T> {
    JpaRepository<T, String> getRepository();
    default T findById(String id) {
        return getRepository().findById(id).orElseThrow(() -> new ResourceNotFound(id));
    }
    default Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }
    default T save(T entity) {
        return getRepository().save(entity);
    }
    default void delete(String id) {
        T entity = findById(id);
        getRepository().delete(entity);
    }
    default void deleteAll(List<String> ids) {
        List<T> entities = ids.stream().map(this::findById).collect(Collectors.toList());
        getRepository().deleteAll(entities);
    }
    default long count() {
        return getRepository().count();
    }
}