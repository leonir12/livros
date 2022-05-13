package br.com.leonir.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonir.livros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
