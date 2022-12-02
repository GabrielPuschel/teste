package br.com.spring.teste.vendedor.repository;

import br.com.spring.teste.vendedor.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("select distinct v from Vendedor v inner join v.vendas vendas where vendas.dataDaVenda between ?1 and ?2")
    List<Vendedor> findByVendasDatasDaVendaBetween(LocalDateTime dataInicio, LocalDateTime dataFinal);
}
