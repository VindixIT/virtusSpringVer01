package com.java.virtusVer010.model;
import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name="ComponentePilar")
@Data
@Table(
		name = "componentes_pilares",
		uniqueConstraints = {
				@UniqueConstraint(name = "componentes_pilares_unique", 
						   columnNames = {"id_pilar", "id_componente"})
		}			
)
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "id_componentes_pilares_seq", sequenceName = "id_componentes_pilares_seq")
public class ComponentePilar {

	@Id
	@Column(name = "id_componentes_pilares")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_componentes_pilares_seq")
	private Long idComponentePilar;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 4000)
	private String descricao;
	
	@Column(name = "sonda", nullable = false, length = 255)
	private String sonda;
	
	@Column(name = "id_autor")
	private Long idAutor;
	
	@Column(name = "criado_em")
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;
	
	@Column(name = "id_versao_origem")
	private String idVersaoOrigem;
	
	@Column(name = "id_Status")
	private Long idStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_componente")	
    private Componente componente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pilar")	
    private Pilar pilar;
	
}
