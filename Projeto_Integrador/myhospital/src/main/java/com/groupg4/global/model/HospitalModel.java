package com.groupg4.global.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_hospital")
public class HospitalModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Faz com que o ID seja auto increment, e também já indica que é uma chave primaria (PRIMARY KEY).
	private Long idHospital;
	@Column
	private String nomeHospital;
	@Column
	private String enderecoHospital;
	@Column
	private String codigoHospital;
	@NotNull
	private int tipoPessoa;
	@NotNull
	private String loginHospital;
	@NotNull
	private String senhaHospital;

	
	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("hospital")
	private List<CategoriaModel> categoria;
	
/*	
	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("funcionario")
	private List<FuncionarioModel> funcionarioHospital;
*/
	
	//Getters and Setters
	
	public Long getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(Long idHospital) {
		this.idHospital = idHospital;
	}
	public String getNomeHospital() {
		return nomeHospital;
	}
	public void setNomeHospital(String nomeHospital) {
		this.nomeHospital = nomeHospital;
	}
	public String getEnderecoHospital() {
		return enderecoHospital;
	}
	public void setEnderecoHospital(String enderecoHospital) {
		this.enderecoHospital = enderecoHospital;
	}
	public String getCodigoHospital() {
		return codigoHospital;
	}
	public void setCodigoHospital(String codigoHospital) {
		this.codigoHospital = codigoHospital;
	}
	public List<CategoriaModel> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<CategoriaModel> categoria) {
		this.categoria = categoria;
	}
	public String getLoginHospital() {
		return loginHospital;
	}
	public void setLoginHospital(String loginHospital) {
		this.loginHospital = loginHospital;
	}
	public String getSenhaHospital() {
		return senhaHospital;
	}
	public void setSenhaHospital(String senhaHospital) {
		this.senhaHospital = senhaHospital;
	}
	public int getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
