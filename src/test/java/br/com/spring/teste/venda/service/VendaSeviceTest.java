package br.com.spring.teste.venda.service;

import br.com.spring.teste.venda.dto.VendaDto;
import br.com.spring.teste.venda.model.Venda;
import br.com.spring.teste.venda.repository.VendaRepository;
import br.com.spring.teste.vendedor.model.Vendedor;
import br.com.spring.teste.vendedor.repository.VendedorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class VendaSeviceTest {

    @InjectMocks
    private VendaService vendaService;

    @Mock
    private VendaRepository repository;

    @Mock
    private VendedorRepository vendedorRepository;

    @Test
    public void cadastrar_deveAdicionarVenda_quandoForAdicionadaVenda() {

        Vendedor vendedor = new Vendedor(1L , "nomeVendedor");
        VendaDto vendaDto = new VendaDto(null,1L, "Nome Vendedor", LocalDateTime.of(2022,01,01,12,00),2.002F);
        Venda vendaNova = new Venda(null, LocalDateTime.of(2022,01,01,12,00), 2.002F, vendedor);
        Venda vendaSave = new Venda(1L, LocalDateTime.of(2022,01,01,12,00), 2.002F, vendedor);
        Mockito.when(vendedorRepository.getById(1L)).thenReturn(vendedor);
        Mockito.when(repository.save(vendaNova)).thenReturn(vendaSave);

        Assertions.assertThat(vendaService.cadastrar(vendaDto)).extracting("id","dataDaVenda","valor").contains(vendaSave.getId(),vendaSave.getDataDaVenda(),vendaSave.getValor());
    }
}
