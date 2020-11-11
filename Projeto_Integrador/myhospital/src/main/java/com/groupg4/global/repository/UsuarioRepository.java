package com.groupg4.global.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupg4.global.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	public List<UsuarioModel>findByNomeUsuarioModelContainingIgnoreCase(String nome);

	public Optional<UsuarioModel> findByLoginUsuarioModel(String loginUsuarioModel);

}
