package com.java.virtusVer010.model;
import javax.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="Elemento")
@Data
@Table(name = "elementos")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "id_elementos_seq", sequenceName = "id_elementos_seq")
public class Elemento {

	@Id
	@Column(name = "id_elemento")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_elementos_seq")
	private Long idElemento;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 4000)
	private String descricao;
	
	@Column(name = "referencia", nullable = false, length = 500)
	private String referencia;
	
	@Column(name = "peso")
	private String peso;
	
	@Column(name = "id_autor")
	private Long idAutor;
	
	@Column(name = "criado_em")
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;
	
	@Column(name = "id_Status")
	private Long idStatus;
	
	//@OneToMany(mappedBy = "idElementoComponente")
	//private List<ElementoComponente> elementocomponente = new ArrayList<ElementoComponente>();

	
}
