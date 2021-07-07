package com.java.virtusVer010.model;
import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name="ElementoComponente")
@Data
@Table(
		name = "elementos_componentes",
		uniqueConstraints = {
				@UniqueConstraint(name = "elementos_componentes_unique", 
						columnNames = {"id_componente", "id_elemento", "id_tipo_nota"})
				}		
)
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "id_elementos_componentes_seq", sequenceName = "id_elementos_componentes_seq")
public class ElementoComponente {

	@Id
	@Column(name = "id_elementos_componentes")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_elementos_componentes_seq")
	private Long idElementoComponente;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "descricao", nullable = true, length = 4000)
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_componente")	
    private Componente componente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_elemento")	
    private Elemento elemento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_nota")	
    private TipoNota tipoNota;
	
}
