package com.java.virtusVer010.model;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Entity(name="PilarCiclo")
@Data
@Table(
		name = "pilares_ciclo",
		uniqueConstraints = {
				@UniqueConstraint(name = "pilares_ciclo_unique", 
						   columnNames = {"id_ciclo","id_pilar"})
		}			
)
@SequenceGenerator(allocationSize = 1,
					initialValue = 1,
					name = "id_pilares_ciclo_seq",
					sequenceName = "id_pilares_ciclo_seq")
public class PilarCiclo {

	@Id
	@Column(name = "id_pilares_ciclo")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_pilares_ciclo_seq")
	private Long idPilarCiclo;

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
	
	@ManyToOne(fetch=FetchType.EAGER) // ManytoOne is Eager... One to Many is Lazy
	@JoinColumn(name="id_ciclo")	
    private Ciclo ciclo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pilar")	
    private Pilar pilar;
	
}
