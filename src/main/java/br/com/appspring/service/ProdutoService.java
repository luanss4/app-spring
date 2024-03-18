package br.com.appspring.service;

import br.com.appspring.dto.ProdutoDTO;
import br.com.appspring.model.Produto;
import br.com.appspring.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        Produto savedProduto = produtoRepository.save(produto);
        return modelMapper.map(savedProduto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        return produto != null ? modelMapper.map(produto, ProdutoDTO.class) : null;
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
