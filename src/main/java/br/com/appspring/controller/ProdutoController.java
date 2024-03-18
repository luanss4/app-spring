package br.com.appspring.controller;

import br.com.appspring.dto.ProdutoDTO;
import br.com.appspring.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.save(produtoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}