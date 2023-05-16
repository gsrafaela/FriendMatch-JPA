package br.com.fiap.cp.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mensagem")
@SequenceGenerator(name="msg", sequenceName = "SQ_TB_MENSAGEM", allocationSize = 1)
public class Mensagem{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msg")
	private Integer id;
    
	@ManyToOne
	@JoinColumn(name = "remetente_id", nullable = false)
	private Integer remetente;

	@ManyToOne
	@JoinColumn(name = "destinatario_id", nullable = false)
	private Integer destinatario;

	@Column(name = "texto_mensagem", nullable = false)
	private String texto;

	@Column(name = "data_envio", nullable = false)
	private LocalDateTime dataEnvio;

	public Mensagem() {}

	public Mensagem(Integer remetente, Integer destinatario, String texto, LocalDateTime dataEnvio) {
	    this.remetente = remetente;
	    this.destinatario = destinatario;
	    this.texto = texto;
	    this.dataEnvio = dataEnvio;
	}

	public Mensagem(String string, Usuario usuario1, Usuario usuario2) {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRemetente() {
		return remetente;
	}

	public void setRemetente(Integer remetente) {
		this.remetente = remetente;
	}

	public Integer getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Integer destinatario) {
		this.destinatario = destinatario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public char[] getConteudo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}