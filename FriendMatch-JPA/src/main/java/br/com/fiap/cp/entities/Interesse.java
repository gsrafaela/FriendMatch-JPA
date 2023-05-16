package br.com.fiap.cp.entities;

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
@Table(name = "tb_interesse")
@SequenceGenerator(name="intrs", sequenceName = "SQ_TB_INTERESSE", allocationSize = 1)
public class Interesse {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "intrs")
private Integer id;

@Column(name = "nome_interesse", nullable = false)
private String nome;

@Column(name = "descricao_interesse", nullable = false)
private String descricao;

@ManyToOne
@JoinColumn(name = "usuario_id", nullable = false)
private Integer usuario;

public Interesse(String string, Usuario usuario1) {}

public Interesse(String nome, String descricao, Integer usuario) {
    this.nome = nome;
    this.descricao = descricao;
    this.usuario = usuario;
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

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public Integer getUsuario() {
	return usuario;
}

public void setUsuario(Integer usuario) {
	this.usuario = usuario;
}

    
}