package com.java.virtusVer010.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity(name="Pilar")
@Data
@Table(name = "pilares")
@SequenceGenerator(allocationSize = 1, initialValue = 1,
					name = "id_pilares_seq", 
					sequenceName = "id_pilares_seq")

public class Pilar {

	@Id
	@Column(name = "id_pilar")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_pilares_seq")
	private Long idPilar;

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
	
	@Column(name = "id_versao_origem")
	private String idVersaoOrigem;
	
	@Column(name = "id_Status")
	private Long idStatus;
	
	@OneToMany(mappedBy = "idPilarCiclo")
	private List<PilarCiclo> pilaresciclos = new ArrayList<PilarCiclo>();
	
}
