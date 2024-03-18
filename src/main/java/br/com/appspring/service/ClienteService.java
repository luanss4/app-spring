package br.com.appspring.service;


import br.com.appspring.dto.ClienteDTO;
import br.com.appspring.model.Cliente;
import br.com.appspring.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ModelMapper modelMapper;

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente savedCliente = clienteRepository.save(cliente);
        return modelMapper.map(savedCliente, ClienteDTO.class);
    }

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente != null ? modelMapper.map(cliente, ClienteDTO.class) : null;
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}