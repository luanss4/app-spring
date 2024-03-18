package br.com.appspring.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private LocalDate dataPedido;
    private BigDecimal valorTotal;
}
