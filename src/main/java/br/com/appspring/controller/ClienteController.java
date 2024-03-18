package br.com.appspring.controller;

import br.com.appspring.dto.ClienteDTO;
import br.com.appspring.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}