package br.com.fiap.cp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@SequenceGenerator(name="usr", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr")
	private Integer id;

	@Column(name = "usuario_nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "usuario_idade", nullable = false)
	private int idade;

	@Enumerated(EnumType.STRING)
	@Column(name = "usuario_genero", nullable = false)
	private String genero;

	@Column(name = "usuario_cidade", length = 50, nullable = false)
	private String cidade;

	@Column(name = "usuario_estado_civil", length = 20, nullable = false)
	private String estadoCivil;

	@OneToMany(mappedBy = "usuario")
	private List<Interesse> interesses;

	@OneToMany(mappedBy = "remetente")
	private List<Correspondencia> correspondenciasEnviadas;

	@ManyToMany
	@JoinTable(name = "tb_correspondencia_usuario", 
	    joinColumns = @JoinColumn(name = "usuario_id"), 
	    inverseJoinColumns = @JoinColumn(name = "correspondencia_id"))
	private List<Correspondencia> correspondenciasRecebidas;


	@OneToMany(mappedBy = "remetente")
	private List<Notificacao> notificacoes;

	@Column(name = "usuario_foto_perfil", nullable = false)
	private byte[] fotoPerfil;

	public Usuario(String nome, int idade, String genero, String cidade, String estadoCivil, byte[] fotoPerfil) {
	    this.nome = nome;
	    this.idade = idade;
	    this.genero = genero;
	    this.cidade = cidade;
	    this.estadoCivil = estadoCivil;
	    this.fotoPerfil = fotoPerfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Interesse> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}

	public List<Correspondencia> getCorrespondenciasEnviadas() {
		return correspondenciasEnviadas;
	}

	public void setCorrespondenciasEnviadas(List<Correspondencia> correspondenciasEnviadas) {
		this.correspondenciasEnviadas = correspondenciasEnviadas;
	}

	public List<Correspondencia> getCorrespondenciasRecebidas() {
		return correspondenciasRecebidas;
	}

	public void setCorrespondenciasRecebidas(List<Correspondencia> correspondenciasRecebidas) {
		this.correspondenciasRecebidas = correspondenciasRecebidas;
	}

	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Usuario() {
		
	}
	
   
}

