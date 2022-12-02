package br.com.spring.teste.venda.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class VendaDtoTest {

@Test
    void construtor_deveCriarVendaDto() {

        VendaDto vendaTest = new VendaDto(1321L,1123L, "Nome Vendedor", LocalDateTime.now(),2.002F);
        Assertions.assertThat(vendaTest.getNomeVendedor()).isEqualTo("Nome Vendedor");
    }
}
