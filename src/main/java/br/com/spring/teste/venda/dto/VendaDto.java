package br.com.spring.teste.venda.dto;

import com.sun.istack.NotNull;

import java.time.LocalDateTime;

public class VendaDto {

    private Long idVenda;
    @NotNull
    private Long idVendedor;
    private String nomeVendedor;
    private LocalDateTime dataDaVenda;
    @NotNull
    private Float valor;

    public VendaDto(){
    }

    public VendaDto(Long idVenda, Long idVendedor, String nomeVendedor, LocalDateTime dataDaVenda, Float valor) {
        this.idVenda = idVenda;
        this.idVendedor = idVendedor;
        this.nomeVendedor = nomeVendedor;
        this.dataDaVenda = dataDaVenda;
        this.valor = valor;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public LocalDateTime getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDateTime dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
