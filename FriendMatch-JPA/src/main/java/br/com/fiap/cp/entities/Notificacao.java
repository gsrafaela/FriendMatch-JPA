package br.com.fiap.cp.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_notificacao")
@SequenceGenerator(name="notf", sequenceName = "SQ_TB_NOTIFICACAO", allocationSize = 1)
public class Notificacao {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notf")
private Integer id;
    
@ManyToOne
@JoinColumn(name = "usuario_id", nullable = false)
private Integer usuario;

@Enumerated(EnumType.STRING)
@Column(name = "tipo_notificacao", nullable = false)
private String tipo;

@Column(name = "texto_notificacao", nullable = false)
private String texto;

@Column(name = "data_notificacao", nullable = false)
private LocalDateTime data;

public Notificacao(String string, Usuario usuario1) {}

public Notificacao(Integer usuario, String tipo, String texto, LocalDateTime data) {
    this.usuario = usuario;
    this.tipo = tipo;
    this.texto = texto;
    this.data = data;
  }

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getUsuario() {
	return usuario;
}

public void setUsuario(Integer usuario) {
	this.usuario = usuario;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public LocalDateTime getData() {
	return data;
}

public void setData(LocalDateTime data) {
	this.data = data;
}

public char[] getDescricao() {
	// TODO Auto-generated method stub
	return null;
}

public String getStatus() {
	// TODO Auto-generated method stub
	return null;
}

public Mensagem getMensagem() {
	// TODO Auto-generated method stub
	return null;
}

public String getDataHora() {
	// TODO Auto-generated method stub
	return null;
}


}
