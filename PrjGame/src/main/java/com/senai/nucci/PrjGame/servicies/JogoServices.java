package com.senai.nucci.PrjGame.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senai.nucci.PrjGame.Repositories.JogoRepository;
import com.senai.nucci.PrjGame.entities.Jogo;

@Service
public class JogoServices {

	private JogoRepository jogoRepository;

	public JogoServices(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo); 
		}
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	public List<Jogo> getAllJogo() {
		return jogoRepository.findAll();
		}
	public void deletejogo(Long id) {
		jogoRepository.deleteById(id);
		}
	public Jogo savejogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
		public Jogo updateJogo(Long id, Jogo novoJogo) {
	        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
	        
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }
}