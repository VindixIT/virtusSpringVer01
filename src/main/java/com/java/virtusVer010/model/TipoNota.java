package com.java.virtusVer010.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity(name="TipoNota")
@Data
@Table(name = "tipos_notas")
@SequenceGenerator(allocationSize = 1,
					initialValue = 1,
					name = "id_tipos_notas_seq",
					sequenceName = "id_tipos_notas_seq")
public class TipoNota {

	@Id
	@Column(name = "id_tipo_nota")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_tipos_notas_seq")
	private Long idTipoNota;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 4000)
	private String descricao;
	
	@Column(name = "referencia", nullable = false, length = 500)
	private String referencia;
	
	@Column(name = "letra", nullable = false, length = 1)
	private String letra;
	
	@Column(name = "cor_letra", nullable = false, length = 6)
	private String corLetra;
	
	@Column(name = "id_autor")
	private Long idAutor;
	
	@Column(name = "criado_em")
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;
	
	@Column(name = "id_versao_origem")
	private String idVersaoOrigem;
	
	@Column(name = "id_Status")
	private Long idStatus;
	
	//@OneToMany(mappedBy = "idNotaComponente")
	//private List<TipoNotaComponente> tipoNotaComponente = new ArrayList<TipoNotaComponente>();
	
	//@OneToMany(mappedBy = "idElementoComponente")
	//private List<ElementoComponente> elementocomponente = new ArrayList<ElementoComponente>();
	
}
