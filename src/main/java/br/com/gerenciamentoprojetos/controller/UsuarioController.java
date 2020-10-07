package br.com.gerenciamentoprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gerenciamentoprojetos.model.Usuario;
import br.com.gerenciamentoprojetos.repository.UsuarioRepository;


@Controller
public class UsuarioController {
    	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario/list")
	public String listUsuario(Model model) {
		
		model.addAttribute("usuario", usuarioRepository.findAll(Sort.by("cargo")));
		return "usuario/list";
	}
	
	@GetMapping("/usuario/add")
	public String addUsuario(Model model) {
		try {
			model.addAttribute("usuario", new Usuario());
			
		}catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return "usuario/add";
	}
	
	@GetMapping("/usuario/view/{id}")
	public String viewUsuario(@PathVariable long id, Model model) {
		model.addAttribute("usuario", usuarioRepository.findById(id));
		return "usuario/view";
	}
	
	@GetMapping("/usuario/edit/{id}")
	public String editUsuario(@PathVariable long id, Model model) {
		model.addAttribute("usuario", usuarioRepository.findById(id));
		return "usuario/edit";
	}
	
	@GetMapping("/usuario/delete/{id}")
	public String deleteUsuario(@PathVariable long id, Model model) {
		try {
			funcionarioRepository.deleteById(id);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return "redirect:/usuario/list";
	}
    
    @PostMapping("/usuario/save")
	public String saveUsuario(Usuario usuario) {
		try {
			funcionarioRepository.save(funcionario);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return "redirect:/usuario/view/" + usuario.getId();
	}

}