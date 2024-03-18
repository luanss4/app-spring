package br.com.appspring.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
}
