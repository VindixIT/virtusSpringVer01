package com.java.virtusVer010.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity(name="Componente")
@Data
@Table(name = "componentes")
@SequenceGenerator(allocationSize = 1, 
						initialValue = 1,
						name = "id_componentes_seq", 
						sequenceName = "id_componentes_seq")
public class Componente {

	@Id
	@Column(name = "id_componente")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_componentes_seq")
	private Long idComponente;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 4000)
	private String descricao;
	
	@Column(name = "referencia", nullable = false, length = 500)
	private String referencia;
	
	@Column(name = "id_autor")
	private Long idAutor;
	
	@Column(name = "criado_em")
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;
	
	@Column(name = "id_Status")
	private Long idStatus;
	
}
