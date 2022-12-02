package br.com.spring.teste.venda.repository;

import br.com.spring.teste.venda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {


    @Query("select v from Venda v where v.vendedor.id = ?1 and v.dataDaVenda between ?2 and ?3")
    List<Venda> findByVendedorIdAndDataDaVendaBetween(Long id, LocalDateTime dataInicio, LocalDateTime dataFinal);
}

