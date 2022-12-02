package br.com.spring.teste.vendedor.model;

import br.com.spring.teste.venda.model.Venda;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor", orphanRemoval = true)
    private List<Venda> vendas;

    public Vendedor (String nome){
        this.nome = nome;
    }

    public Vendedor (Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
