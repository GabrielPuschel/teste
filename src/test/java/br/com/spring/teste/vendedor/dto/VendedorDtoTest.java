package br.com.spring.teste.vendedor.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VendedorDtoTest {

@Test
    void construtor_deveCriarVendedorDto() {

        VendedorDto vendedorTest = new VendedorDto("nome vendedor", 12L);
        Assertions.assertThat(vendedorTest.getNome()).isEqualTo("nome vendedor");
    }
}
