package com.groupg4.global.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.groupg4.global.model.HospitalModel;
import com.groupg4.global.model.UsuarioModel;
import com.groupg4.global.repository.HospitalRepository;
import com.groupg4.global.repository.UsuarioRepository;

@Service
public class UserDetailsServiceUsuario implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> user = usuarioRepository.findByLoginUsuarioModel(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		return user.map(UserDetailsUsuario::new).get();
	}
	public UserDetails loadUser2ByUsername(String userName) throws UsernameNotFoundException {
		Optional<HospitalModel> user2 = hospitalRepository.findByLoginHospital(userName);
		user2.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user2.map(UserDetailsUsuario::new).get();
	}

	
	
		

}
