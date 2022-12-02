package br.com.spring.teste.vendedor.controller;

import br.com.spring.teste.venda.dto.RelatorioVendaDto;
import br.com.spring.teste.vendedor.dto.VendedorDto;
import br.com.spring.teste.vendedor.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public List<VendedorDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public VendedorDto findById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid VendedorDto dadosVendedor) {
        service.cadastrar(dadosVendedor);
    }

    @PutMapping("{id}")
    public void atualizarVendedor(@PathVariable Long id, @RequestBody @Valid VendedorDto vendedorDto) {
        service.atualizarVendedor(id, vendedorDto);
    }

    @GetMapping("/relatorio")
    public List<RelatorioVendaDto> relatorioVendaDtos(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFinal){

        return service.relatorio(dataInicio, dataFinal);
    }

    @GetMapping("/relatorioGeral")
    public List<RelatorioVendaDto> relatorioVendaDtosAll(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFinal){

        return service.relatorioAll(dataInicio, dataFinal);
    }

}


