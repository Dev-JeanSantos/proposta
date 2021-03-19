package br.com.zup.proposta.novaproposta;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{

	Optional<Proposta> findByDocumento(@NotBlank String documento);

	List<Proposta> findByStatusAndCartao(StatusProposta estado, String cartao);

}
