package br.com.pamcary.avaliacao.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.pamcary.avaliacao.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	public List<Pessoa> findAllByNomeContainingIgnoreCase(String nome); 
	public Optional<Pessoa> findByCpf(String cpf);
	public Optional<Pessoa> findById (Long id);
}
