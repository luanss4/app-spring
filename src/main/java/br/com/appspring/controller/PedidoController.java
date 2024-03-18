package br.com.appspring.controller;


import br.com.appspring.dto.PedidoDTO;
import br.com.appspring.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO pedidoDTO) {
        return new ResponseEntity<>(pedidoService.save(pedidoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}