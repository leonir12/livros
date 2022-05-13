package br.com.leonir.livros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String titulo;
	
	@NotNull
	@NotBlank
	private String editora;
	
	@NotNull
	@NotBlank	
	@Size(min= 3, max = 25, message = "Quantidade de caracteres fora do limite")
	private String autor;
	
	@NotNull
	@NotBlank
	private String categoria;
	
	@NotNull
	@Min(value = 1500, message = "Valor mínimo é 1500 ")
	private int ano;
	
	@NotNull
	@Min(value=1, message = "A quantidade mínima é 1")
	private int quantidade;
	
	public Livro(String titulo, String editora, String autor, String categoria, int ano, int quantidade) {
		super();
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.categoria = categoria;
		this.ano = ano;
		this.quantidade = quantidade;
	}
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
