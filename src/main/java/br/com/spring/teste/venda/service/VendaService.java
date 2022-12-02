package br.com.spring.teste.venda.service;

import br.com.spring.teste.venda.dto.VendaDto;
import br.com.spring.teste.venda.model.Venda;
import br.com.spring.teste.venda.repository.VendaRepository;
import br.com.spring.teste.vendedor.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private static final String VENDA_NAO_LOCALIZADA = "Não foi possível localizar a venda!";

    @Autowired
    private VendaRepository repository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public Venda cadastrar(VendaDto dadosVenda){
        var vendedor = vendedorRepository.getById(dadosVenda.getIdVendedor());
        var venda = new Venda();
        venda.setDataDaVenda(dadosVenda.getDataDaVenda());
        venda.setValor(dadosVenda.getValor());
        venda.setVendedor(vendedor);
        return repository.save(venda);
    }

    public List<VendaDto> findAll() {
        return repository.findAll().stream()
                .map(venda -> new VendaDto(venda.getId(),
                        venda.getVendedor().getId(),
                        venda.getVendedor().getNome(),
                        venda.getDataDaVenda(),
                        venda.getValor()))
                .collect(Collectors.toList());
    }

    public VendaDto getById(Long id) {
        try {
            var venda = repository.getById(id);
            return new VendaDto(venda.getId(), venda.getVendedor().getId(), venda.getVendedor().getNome(), venda.getDataDaVenda(), venda.getValor());
        } catch (Exception e) {
            throw new EntityNotFoundException(VENDA_NAO_LOCALIZADA);
        }
    }

    @Transactional
    public void atualizarVenda(Long id, VendaDto vendaDto){
        try {
            var venda = repository.getById(id);
            venda.setValor(vendaDto.getValor());
            repository.save(venda);
        } catch (Exception e) {
            throw new EntityNotFoundException(VENDA_NAO_LOCALIZADA);
        }
    }
}
