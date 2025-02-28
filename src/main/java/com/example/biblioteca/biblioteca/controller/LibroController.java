package com.example.biblioteca.biblioteca.controller;

import com.example.biblioteca.biblioteca.dto.LibroDTO;
import com.example.biblioteca.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/save")
    public ResponseEntity<LibroDTO> createLibro(@RequestBody LibroDTO libroDto) {
        return new ResponseEntity<>(libroService.save(libroDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LibroDTO>> getAllL() {
        return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<LibroDTO> getById(@RequestParam Integer id) {
        return libroService.findById(id)
                //  .map(libroDTO -> ResponseEntity.ok(libroDTO))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LibroDTO> delete(@PathVariable Integer id) {
        return libroService.delete(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
