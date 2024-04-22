package br.com.douglasbello.cinelist.controllers;

import br.com.douglasbello.cinelist.dtos.RequestResponseDTO;
import br.com.douglasbello.cinelist.services.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Controller<T> {
    Service<T> getService();
    @GetMapping
    default ResponseEntity<List<T>> findAll(Pageable pageable) {
        Page<T> resultPage = getService().findAll(pageable);

        List<T> resultList = resultPage.getContent();

        return ResponseEntity.ok().body(resultList);
    }
    @GetMapping("/{id}")
    default ResponseEntity<T> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(getService().findById(id));
    }
    @PostMapping
    default ResponseEntity<T> save(@RequestBody T entity) {
        return ResponseEntity.ok().body(getService().save(entity));
    }
    @GetMapping("/count")
    default ResponseEntity<Long> count() {
        return ResponseEntity.ok().body(getService().count());
    }
    @DeleteMapping("/{id}")
    default ResponseEntity<RequestResponseDTO> delete(@PathVariable String id) {
        getService().delete(id);

        return ResponseEntity.ok().body(new RequestResponseDTO(HttpStatus.OK.value(), "Resource deleted successfully"));
    }
    @DeleteMapping("/delete/all")
    default ResponseEntity<RequestResponseDTO> deleteAll(@RequestBody List<String> ids) {
        getService().deleteAll(ids);

        return ResponseEntity.ok().body(new RequestResponseDTO(HttpStatus.OK.value(), "Resources deleted successfully"));
    }
}