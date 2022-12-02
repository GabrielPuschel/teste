package br.com.spring.teste.vendedor.dto;

import com.sun.istack.NotNull;

public class VendedorDto {

    @NotNull
    private String nome;
    @NotNull
    private Long id;

    public VendedorDto(){
    }

    public VendedorDto(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

