package br.com.spring.teste.vendedor.service;

import br.com.spring.teste.venda.dto.RelatorioVendaDto;
import br.com.spring.teste.venda.dto.VendaDto;
import br.com.spring.teste.venda.repository.VendaRepository;
import br.com.spring.teste.vendedor.dto.VendedorDto;
import br.com.spring.teste.vendedor.model.Vendedor;
import br.com.spring.teste.vendedor.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VendedorService {

    public static final String VENDEDOR_NAO_LOCALIZADO = "Não foi possível localizar o vendedor!";

    @Autowired
    private VendedorRepository repository;

    @Autowired
    private VendaRepository vendaRepository;

    public void cadastrar(VendedorDto dadosVendedor){
        var vendedor = new Vendedor(dadosVendedor.getNome());
        repository.save(vendedor);
    }

    public List<VendedorDto> findAll(){
        return repository.findAll().stream().map(vendedor -> new VendedorDto(vendedor.getNome(),
                vendedor.getId())).collect(Collectors.toList());
    }

    public VendedorDto getById(Long id){
        try{
            var vendedor = repository.getById(id);
            return new VendedorDto(vendedor.getNome(),vendedor.getId());
        } catch (Exception e){
            throw new EntityNotFoundException(VENDEDOR_NAO_LOCALIZADO);
        }
    }

    @Transactional
    public void atualizarVendedor(Long id, VendedorDto vendedorDto){
        try{
            var vendedor = repository.getById(id);
            vendedor.setNome(vendedorDto.getNome());
        } catch (Exception e){
            throw new EntityNotFoundException(VENDEDOR_NAO_LOCALIZADO);
        }
    }

    public List<RelatorioVendaDto> relatorio(LocalDate dataInicio, LocalDate dataFinal){
        var vendedores = repository.findByVendasDatasDaVendaBetween(
                dataInicio.atTime(LocalTime.MIN), dataFinal.atTime(LocalTime.MAX));
                var totalDeDias = DAYS.between(dataInicio, dataFinal) + 1;
                var relatorioVenda = vendedores.stream().map(
                        vendedor -> new RelatorioVendaDto(vendedor.getNome(),
                        vendedor.getId(),getTotalVendas(dataInicio, dataFinal, vendedor)/ totalDeDias))
                        .collect(Collectors.toList());
                return relatorioVenda;
    }

    private int getTotalVendas(LocalDate dataInicio, LocalDate dataFinal, Vendedor vendedor) {
        return vendaRepository.findByVendedorIdAndDataDaVendaBetween(vendedor.getId(),
                dataInicio.atTime(0, 0, 0),
                dataFinal.atTime(23, 59, 59)).size();
    }

    public List<RelatorioVendaDto> relatorioAll(LocalDate dataInicio, LocalDate dataFinal){
        var vendedores = repository.findAll();
        var totalDeDias = DAYS.between(dataInicio, dataFinal) + 1;
        return vendedores.stream().map(
                vendedor -> new RelatorioVendaDto(vendedor.getNome(),
                        vendedor.getId(),
                        vendedor.getVendas().size(),
                        vendedor.getVendas().size()/ totalDeDias)).collect(Collectors.toList());
    }
}
