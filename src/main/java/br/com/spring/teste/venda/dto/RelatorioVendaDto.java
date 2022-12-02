package br.com.spring.teste.venda.dto;

public class RelatorioVendaDto {

    private String nome;
    private Long id;
    private double totalVendas;
    private double mediaVendasDiarias;

    public RelatorioVendaDto() {
    }

    public RelatorioVendaDto(String nome, Long id, double totalVendas) {
        this.nome = nome;
        this.id = id;
        this.totalVendas = totalVendas;
    }

    public RelatorioVendaDto(String nome, Long id, int totalVendas, long mediaVendasDiarias) {
        this.nome = nome;
        this.id = id;
        this.totalVendas = totalVendas;
        this.mediaVendasDiarias = mediaVendasDiarias;
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

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getMediaVendasDiarias() {
        return mediaVendasDiarias;
    }

    public void setMediaVendasDiarias(double mediaVendasDiarias) {
        this.mediaVendasDiarias = mediaVendasDiarias;
    }

}
