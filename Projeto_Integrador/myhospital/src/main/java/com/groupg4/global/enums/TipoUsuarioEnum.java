package com.groupg4.global.enums;

public enum TipoUsuarioEnum {
	//teste
	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");
	private Integer codigo;
	private String descricao;
	private static TipoUsuarioEnum [] values = TipoUsuarioEnum.values();
	
	
	private TipoUsuarioEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoUsuarioEnum getTipoUsuarioCodigo(int codigo){
		for(TipoUsuarioEnum t: values) {
			if(t.getCodigo().equals(codigo)) {
				return t;
			}
		}
		return null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	//get set

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
