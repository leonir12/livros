package br.com.leonir.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonir.livros.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
