package br.com.fiap.cp.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_correspondencia")
@SequenceGenerator(name="corr", sequenceName = "SQ_TB_CORRESPONDENCIA", allocationSize = 1)
public class Correspondencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corr")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "remetente_id")
	private Integer remetente;

	@ManyToOne
	@JoinColumn(name = "destinatario_id")
	private Integer destinatario;

	@Enumerated(EnumType.STRING)
	@Column(name = "correspondencia_status", nullable = false)
	private String status;

	@Column(name = "correspondencia_data_iniciada", nullable = false)
	private LocalDate dataIniciada;

	@Column(name = "correspondencia_data_atualizada")
	private LocalDate dataAtualizada;

	@OneToMany(mappedBy = "correspondencia")
	private List<Mensagem> mensagens;

	public Correspondencia(Integer remetente, Integer destinatario, String status, LocalDate dataIniciada) {
	    this.remetente = remetente;
	    this.destinatario = destinatario;
	    this.status = status;
	    this.dataIniciada = dataIniciada;
	}

	public Correspondencia(String string, String string2, String string3, String string4, Usuario usuario1) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataIniciada() {
		return dataIniciada;
	}

	public void setDataIniciada(LocalDate dataIniciada) {
		this.dataIniciada = dataIniciada;
	}

	public LocalDate getDataAtualizada() {
		return dataAtualizada;
	}

	public void setDataAtualizada(LocalDate dataAtualizada) {
		this.dataAtualizada = dataAtualizada;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
   
}

