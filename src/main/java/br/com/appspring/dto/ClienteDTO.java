package br.com.appspring.dto;
import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}