package br.com.spring.teste.venda.model;

import br.com.spring.teste.vendedor.model.Vendedor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dataDaVenda;
    @Column
    private Float valor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public Venda(){
    }

    public Venda (Long id, LocalDateTime dataDaVenda, Float valor, Vendedor vendedor){
        this.id = id;
        this.dataDaVenda = dataDaVenda;
        this.valor = valor;
        this.vendedor= vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDateTime dataVendaAtual(){
        return java.time.LocalDateTime.now().withNano(0);
    }
}
