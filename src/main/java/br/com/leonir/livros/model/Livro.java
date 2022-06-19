package br.com.leonir.livros.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min= 3, max = 25, message = "O título deve ter entre 3 a 25 caracteres")
	private String titulo;
	
	@NotNull
	@NotBlank
	@Size(min= 3, max = 25, message = "O nome da editora deve ter entre 3 a 25 caracteres")
	private String editora;
	
	@NotNull
	@NotBlank	
	@Size(min= 3, max = 25, message = "O nome do autor deve ter entre 3 a 25 caracteres")
	private String autor;
	
	@NotNull
	@NotBlank
	@Size(min= 3, max = 25, message = "O nome da categoria deve ter entre 3 a 25 caracteres")
	private String categoria;
	
	@NotNull
	@Min(value = 1901, message = "O ano de publicação não pode ser antes de 1901")
	@Max(value = 2022, message = "O ano de publicação não pode passar de 2022")
	private int ano;
	
	@NotNull
	@Min(value=1, message = "Deve ter pelo menos 1 exemplar")
	@Max(value = 30, message = "A quantidade máxima permitida é de 30 exemplares")
	private int quantidade;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "livro", 
			  fetch = FetchType.EAGER)
	private Aluno aluno;
	
	

	public Livro(String titulo, String editora, String autor, String categoria, int ano, int quantidade,Aluno aluno) {
		super();
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.categoria = categoria;
		this.ano = ano;
		this.quantidade = quantidade;
		this.aluno = aluno;
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
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
