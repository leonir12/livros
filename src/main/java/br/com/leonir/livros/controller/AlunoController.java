package br.com.leonir.livros.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.leonir.livros.model.Aluno;
import br.com.leonir.livros.model.Livro;
import br.com.leonir.livros.repository.AlunoRepository;
import br.com.leonir.livros.repository.LivroRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/novo/{id}")
	public String adicionarAluno(@PathVariable("id") long id,Model model) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (!livro.isPresent()) {
			throw new IllegalArgumentException("Livro inválido:" + id);
		}
		Livro livroSelecionado = new Livro();
		livroSelecionado = livro.get();
		model.addAttribute("livro", livroSelecionado);
		model.addAttribute("aluno", new Aluno());
		return "/form-cadastrar-aluno";
	}
	
	@PostMapping("/salvar")
	public String salvarAluno(
				@Valid Aluno aluno, 				
				BindingResult result, 
				Model model,
				RedirectAttributes attributes) {
		//Optional<Livro> livroBanco = livroRepository.findById(idLivro);
		//Livro livro = livroBanco.get();
		if (result.hasErrors()) {
			//aluno.setLivro(livro);
			attributes.addFlashAttribute("mensagem", "Ocorreu um erro!");
			return "/form-cadastrar-aluno";
		}
		
		//aluno.setLivro(livro);
		alunoRepository.save(aluno);
		attributes.addFlashAttribute("mensagem", "Livro reservado com sucesso!");
		return "redirect:/livros";
	}
	
	
}
