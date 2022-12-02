package br.com.spring.teste.venda.controller;

import br.com.spring.teste.venda.dto.VendaDto;
import br.com.spring.teste.venda.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venda")
public class VendasController {

    @Autowired
    private VendaService service;

    @PostMapping
    public void cadastrar(@RequestBody VendaDto dadosVenda){
        service.cadastrar(dadosVenda);
    }

    @GetMapping
    public List<VendaDto> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public VendaDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("{id}")
    public void atualizarVenda(@PathVariable Long id, @RequestBody VendaDto vendaDto){
        service.atualizarVenda(id, vendaDto);
    }

}
