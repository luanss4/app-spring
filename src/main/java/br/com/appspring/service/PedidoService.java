package br.com.appspring.service;

import br.com.appspring.dto.PedidoDTO;
import br.com.appspring.model.Pedido;
import br.com.appspring.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ModelMapper modelMapper;

    public PedidoService(PedidoRepository pedidoRepository, ModelMapper modelMapper) {
        this.pedidoRepository = pedidoRepository;
        this.modelMapper = modelMapper;
    }

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        Pedido savedPedido = pedidoRepository.save(pedido);
        return modelMapper.map(savedPedido, PedidoDTO.class);
    }

    public List<PedidoDTO> findAll() {
        return pedidoRepository.findAll().stream()
                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
                .collect(Collectors.toList());
    }

    public PedidoDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        return pedido != null ? modelMapper.map(pedido, PedidoDTO.class) : null;
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
