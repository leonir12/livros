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



import br.com.leonir.livros.model.Livro;
import br.com.leonir.livros.repository.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@RequestMapping("") 
	public String index() {
		return "redirect:/livros";
	}
	
	@RequestMapping("/livros") 
	public String index(Model model) {
		model.addAttribute("livros", livroRepository.findAll());
		return "index";
	}
	
	@GetMapping("/livros/novo")
	public String adicionarUsuario(Model model) {
		model.addAttribute("livro", new Livro());
		return "/form-cadastrar-livros";
	}
	
	@PostMapping("/livros/salvar")
	public String salvarLivro(@Valid Livro livro, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Ocorreu um erro!");
			return "/form-cadastrar-livros";
		}
		livroRepository.save(livro);
		attributes.addFlashAttribute("mensagem", "Livro cadastrado com sucesso!");
		return "redirect:/livros";
	}
	
	@GetMapping("/livros/apagar/{id}")
	public String deleteLivro(@PathVariable("id") long id, Model model, RedirectAttributes attributes) {
		Livro livro = livroRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		livroRepository.delete(livro);
		attributes.addFlashAttribute("mensagem", "Livro deletado com sucesso!");
		return "redirect:/livros";
	}
	
	@GetMapping("/livros/editar/{id}")
	public String editarLivro(@PathVariable("id") long id, Model model) {
		Optional<Livro> livroVelho = livroRepository.findById(id);
		if (!livroVelho.isPresent()) {
			throw new IllegalArgumentException("Livro inválido:" + id);
		}
		Livro livro = livroVelho.get();
		model.addAttribute("livro", livro);
		return "/form-editar-livros";
	}

	@PostMapping("/livros/editar/{id}")
	public String editarLivro(@PathVariable("id") long id, @Valid Livro livro, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			livro.setId(id);
			return "/form-editar-livros";
		}
		livroRepository.save(livro);
		attributes.addFlashAttribute("mensagem", "Livro atualizado com sucesso!");
		return "redirect:/livros";
	}
}
