package com.example.biblioteca.biblioteca.controller;

import com.example.biblioteca.biblioteca.dto.AutorDTO;
import com.example.biblioteca.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public ResponseEntity<AutorDTO> save(@RequestBody AutorDTO autorDTO) {
        return new ResponseEntity<>(autorService.save(autorDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AutorDTO>> findAll() {
        return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK);
    }

    /* Antes
    @GetMapping("/findById/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(autorService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     */

    @GetMapping("/findById/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable Integer id) {
        return autorService.findById(id)
                .map(autordto -> ResponseEntity.ok(autordto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
/*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            autorService.deleteByID(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
*/
    @DeleteMapping("/deleteOptional/{id}")
    public ResponseEntity<AutorDTO> eliminar(@PathVariable Integer id) {
        return autorService.deleteAutorByID(id)
                .map(autordto->ResponseEntity.ok(autordto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
