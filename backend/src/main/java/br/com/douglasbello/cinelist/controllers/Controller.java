package br.com.douglasbello.cinelist.controllers;

import br.com.douglasbello.cinelist.services.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @GetMapping("/count")
    default ResponseEntity<Long> count() {
        return ResponseEntity.ok().body(getService().count());
    }
}