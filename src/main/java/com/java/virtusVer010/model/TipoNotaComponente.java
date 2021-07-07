package com.java.virtusVer010.model;

import java.util.Date;
import lombok.Data;
import javax.persistence.*;

@Entity(name="TipoNotaComponente")
@Data
@Table(
		name = "tipos_notas_componentes",
		uniqueConstraints = {
			@UniqueConstraint(name = "tipos_notas_componentes_unique", 
					columnNames = {"id_componente", "id_tipo_nota"})
						}		
)
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "id_tipos_notas_componentes_seq", sequenceName = "id_tipos_notas_componentes_seq")
public class TipoNotaComponente {

	@Id
	@Column(name = "id_tipos_notas_componentes")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_tipos_notas_componentes_seq")
	private Long idTipoNotaComponente;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_componente")	
    private Componente componente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_nota")	
    private TipoNota tipoNota;

	
}
