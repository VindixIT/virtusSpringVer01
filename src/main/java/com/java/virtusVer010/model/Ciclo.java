package com.java.virtusVer010.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.java.virtusVer010.model.Ciclo;
//import com.java.virtusVer010.model.PilarCiclo;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import lombok.Data;

@Entity(name="Ciclo")
@Data
@Table(name = "ciclos")
@SequenceGenerator(allocationSize = 1, 
					initialValue = 1,
					name = "id_ciclos_seq", 
					sequenceName = "id_ciclos_seq")

public class Ciclo {

	@Id
	@Column(name = "id_ciclo")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_ciclos_seq" )
	private Long idCiclo;

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
	
	//@OneToMany(mappedBy = "idPilarCiclo") //mudei para idPilarCiclo
	//private List<PilarCiclo> pilaresciclo = new ArrayList<PilarCiclo>();
	
}