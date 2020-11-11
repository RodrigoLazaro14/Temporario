package com.groupg4.global.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupg4.global.model.HospitalModel;
import com.groupg4.global.model.UsuarioLogin;
import com.groupg4.global.model.UsuarioModel;
import com.groupg4.global.repository.HospitalRepository;
import com.groupg4.global.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private HospitalRepository hospitalRepository;

	public UsuarioModel CadastrarUsuario(UsuarioModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenhaUsuarioModel());
		usuario.setSenhaUsuarioModel(senhaEncoder);

		return repository.save(usuario);
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByLoginUsuarioModel(user.get().getLoginUsuarioLogin());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenhaUsuarioLogin(), usuario.get().getSenhaUsuarioModel())) {

				String auth = user.get().getLoginUsuarioLogin() + ":" + user.get().getSenhaUsuarioLogin();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setTokenUsuarioLogin(authHeader);				
				user.get().setNomeUsuarioLogin(usuario.get().getNomeUsuarioModel());
				user.get().setTipoPessoa(usuario.get().getTipoPessoa());
				return user;

			}
		}
		return null;
	}
//-------------------------------------------------------------------------------------------------------------------
	


	public HospitalModel CadastrarUsuario(HospitalModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenhaHospital());
		usuario.setSenhaHospital(senhaEncoder);

		return hospitalRepository.save(usuario);
	}

	public Optional<UsuarioLogin> Logar2(Optional<UsuarioLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<HospitalModel> usuario2 = hospitalRepository.findByLoginHospital(user.get().getLoginUsuarioLogin());

		if (usuario2.isPresent()) {
			if (encoder.matches(user.get().getSenhaUsuarioLogin(), usuario2.get().getSenhaHospital())) {

				String auth = user.get().getLoginUsuarioLogin() + ":" + user.get().getSenhaUsuarioLogin();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setTokenUsuarioLogin(authHeader);				
				user.get().setNomeUsuarioLogin(usuario2.get().getNomeHospital());
				user.get().setTipoPessoa(usuario2.get().getTipoPessoa());
				return user;

			}
		}
		return null;
	}
	
}
