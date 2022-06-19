package br.com.leonir.livros.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min= 3, max = 50, message = "O nome do aluno deve ter entre 3 a 50 caracteres")
	private String nome;
	
	@NotNull
	@NotBlank
	private String telefone;
	
	@NotNull
	@NotBlank
	@Size(min= 3, max = 50, message = "O nome do campus deve ter entre 3 a 50 caracteres")
	private String campus;
	
	@NotNull
	@NotBlank
	@Size(min= 3, max = 50, message = "O nome do curso deve ter entre 3 a 50 caracteres")
	private String curso;
	
	@NotNull
	@Min(value = 1, message = "O aluno deve estar pelo menos no primeiro semestre")
	@Max(value = 10, message = "O semestre não pode passar de 10")
	private int semestre;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "livro_id")
	private Livro livro;
	
	
	
	public Aluno(String nome, String telefone, String campus, String curso, int semestre, Livro livro) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.campus = campus;
		this.curso = curso;
		this.semestre = semestre;
		this.livro = livro;
	}
	
	
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	
	
	
}
